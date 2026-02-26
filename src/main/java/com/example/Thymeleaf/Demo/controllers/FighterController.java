package com.example.Thymeleaf.Demo.controllers;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fighters")
public class FighterController {

    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping
    public String getFighters(Model model) {
        model.addAttribute("fighters", fighterService.getAllFighters());
        model.addAttribute("total", fighterService.getFighterCount());
        return "Fighters";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("fighter", new Fighter());
        return "fighter-form";
    }

    @PostMapping("/save")
    public String saveFighter(@Valid @ModelAttribute("fighter") Fighter fighter,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "fighter-form";
        }
        fighterService.saveFighter(fighter);
        return "redirect:/fighters";
    }

    @GetMapping("/delete/{id}")
    public String deleteFighter(@PathVariable int id) {
        fighterService.deleteFighter(id);
        return "redirect:/fighters";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        fighterService.getFighterById(id).ifPresent(f -> model.addAttribute("fighter", f));
        return "fighter-form";
    }
}