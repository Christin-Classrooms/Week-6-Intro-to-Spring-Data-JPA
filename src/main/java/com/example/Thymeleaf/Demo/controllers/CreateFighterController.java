package com.example.Thymeleaf.Demo.controllers;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateFighterController {

    private final FighterService fighterService;

    public CreateFighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping("/createFighter")
    public String showForm(Model model) {
        model.addAttribute("fighter", new Fighter());
        return "createFighter";
    }

    @PostMapping("/createFighter")
    public String createFighter(
            @Valid @ModelAttribute("fighter") Fighter fighter,
            BindingResult result) {

        if (result.hasErrors()) {
            return "createFighter";
        }

        fighterService.save(fighter);
        return "redirect:/fighters";
    }
}
