package com.example.Thymeleaf.Demo.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;

@Controller
public class FighterController {

    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping("/fighters")
    public String getFighters(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String filterType,
            Model model) {

        // RESTRICT SORT FIELDS
        List<String> allowedSortFields = List.of("id", "name", "health", "damage", "resistance");
        if (!allowedSortFields.contains(sort)) {
            sort = "id";
        }

        Sort.Direction sortDir = "DESC".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDir, sort));

        Pageable unsortedPageable = PageRequest.of(page, size);

        if (filterType == null) {
            filterType = "";
        }
        if (search == null) {
            search = "";
        }

        Page<Fighter> fighterPage;

        // HAVEN'T YET REALIZED WHY JAVA IN VSCODE ENCOURAGES RULE SWITCH SYNTAX
        switch (filterType) {
            case "name" ->
                fighterPage = fighterService.findByName(search, pageable);

            case "health" -> {
                // TRY TO PARSE THE SEARCH AS AN INT, OR DEFAULT TO 1200
                int healthThreshold = 1200;
                if (!search.isBlank()) {
                    try {
                        healthThreshold = Integer.parseInt(search.trim());
                    } catch (NumberFormatException ignored) {
                    }
                }
                fighterPage = fighterService.findByHealth(healthThreshold, pageable);
            }

            case "strongest" ->
                fighterPage = fighterService.findStrongest(unsortedPageable);

            case "balanced" -> {
                // MMMM, BALANCED BUILD... HIGH HEALTH, CONTROLLED DAMAGE.
                fighterPage = fighterService.findBalanced(1200.0, 80.0, unsortedPageable);
            }

            default ->
                fighterPage = fighterService.getAllFighters(pageable);
        }

        model.addAttribute("fighters", fighterPage.getContent());
        model.addAttribute("totalPages", fighterPage.getTotalPages());
        model.addAttribute("totalElements", fighterPage.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("hasPrevious", fighterPage.hasPrevious());
        model.addAttribute("hasNext", fighterPage.hasNext());
        model.addAttribute("search", search);
        model.addAttribute("sort", sort);
        model.addAttribute("direction", direction);
        model.addAttribute("filterType", filterType);

        return "Fighters";
    }
}
