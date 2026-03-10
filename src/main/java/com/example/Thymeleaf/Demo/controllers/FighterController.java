package com.example.Thymeleaf.Demo.controllers;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam(defaultValue = "all") String filterType,
            Model model
    ) {

        Sort.Direction dir = direction.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;

        // allow sorting only by these fields
        if (!sort.equals("id") && !sort.equals("name") && !sort.equals("health") && !sort.equals("damage") && !sort.equals("resistance")) {
            sort = "id";
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<Fighter> fighterPage;

        switch (filterType) {
            case "name":
                fighterPage = fighterService.searchByName(search == null ? "" : search, pageable);
                break;
            case "health":
                fighterPage = fighterService.filterByHealth(1200, pageable);
                break;
            case "strongest":
                fighterPage = fighterService.strongest(pageable);
                break;
            case "balanced":
                fighterPage = fighterService.balanced(1200, 60, pageable);
                break;
            default:
                fighterPage = fighterService.getAllFighters(pageable);
        }

        model.addAttribute("fighters", fighterPage.getContent());
        model.addAttribute("totalElements", fighterPage.getTotalElements());

        model.addAttribute("totalPages", fighterPage.getTotalPages());
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