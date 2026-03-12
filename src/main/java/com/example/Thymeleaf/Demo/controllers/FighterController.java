package com.example.Thymeleaf.Demo.controllers;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class FighterController {

    private final FighterService fighterService;

    public FighterController(FighterService fighterService){
        this.fighterService = fighterService;
    }

    @GetMapping("/fighters")
    public String listFighters(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(defaultValue = "all") String filterType,
            Model model
    ) {

        Set<String> allowedSorts = Set.of("id", "name", "health", "damage", "resistance");
        if (!allowedSorts.contains(sort)) {
            sort = "id";
        }

        Sort.Direction dir = direction.equalsIgnoreCase("DESC")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sort));

        Page<Fighter> fighterPage;
        String trimmedSearch = search.trim();

        switch (filterType) {
            case "name":
                if (trimmedSearch.isEmpty()) {
                    fighterPage = fighterService.getFighters(pageable);
                    filterType = "all";
                } else {
                    fighterPage = fighterService.searchByName(trimmedSearch, pageable);
                }
                break;

            case "health":
                fighterPage = fighterService.filterByHealth(1200, pageable);
                break;

            case "strongest":
                fighterPage = fighterService.strongest(pageable);
                break;

            case "balanced":
                fighterPage = fighterService.balanced(pageable);
                break;

            default:
                fighterPage = fighterService.getFighters(pageable);
                filterType = "all";
                break;
        }

        model.addAttribute("fighters", fighterPage.getContent());
        model.addAttribute("totalPages", fighterPage.getTotalPages());
        model.addAttribute("totalElements", fighterPage.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("hasPrevious", fighterPage.hasPrevious());
        model.addAttribute("hasNext", fighterPage.hasNext());
        model.addAttribute("search", trimmedSearch);
        model.addAttribute("sort", sort);
        model.addAttribute("direction", dir.name());
        model.addAttribute("filterType", filterType);

        return "Fighters";
    }
}