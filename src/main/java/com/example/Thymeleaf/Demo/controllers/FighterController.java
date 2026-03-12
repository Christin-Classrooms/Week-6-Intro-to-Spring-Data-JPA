package com.example.Thymeleaf.Demo.controllers;
//Lab 4 changes added
import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@Controller
public class FighterController {

@Autowired
    private FighterRepository fighterRepository;

    @GetMapping("/fighters")
    public String listFighters(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String filterType,
            Model model
    ) {

      
        List<String> allowedSortFields = Arrays.asList("id", "name", "health", "damage", "resistance");
        if (!allowedSortFields.contains(sort)) {
            sort = "id";
        }

        Sort.Direction sortDirection = direction.equalsIgnoreCase("DESC")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));

        Page<Fighter> fighterPage;

        if ("name".equalsIgnoreCase(filterType) && search != null && !search.trim().isEmpty()) {
            fighterPage = fighterRepository.findByNameContainingIgnoreCase(search, pageable);

        } else if ("health".equalsIgnoreCase(filterType) && search != null && !search.trim().isEmpty()) {
            try {
                int minHealth = Integer.parseInt(search);
                fighterPage = fighterRepository.findByHealthGreaterThan(minHealth, pageable);
            } catch (NumberFormatException e) {
                fighterPage = fighterRepository.findAll(pageable);
            }

        } else if ("strongest".equalsIgnoreCase(filterType)) {
            fighterPage = fighterRepository.findStrongestFighters(pageable);

        } else if ("balanced".equalsIgnoreCase(filterType) && search != null && !search.trim().isEmpty()) {
            try {
                String[] values = search.split(",");
                double minHealth = Double.parseDouble(values[0].trim());
                double maxDamage = Double.parseDouble(values[1].trim());

                fighterPage = fighterRepository.findBalancedFighters(minHealth, maxDamage, pageable);
            } catch (Exception e) {
                fighterPage = fighterRepository.findAll(pageable);
            }

        } else {
            fighterPage = fighterRepository.findAll(pageable);
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

        return "fighters";
    }
}
