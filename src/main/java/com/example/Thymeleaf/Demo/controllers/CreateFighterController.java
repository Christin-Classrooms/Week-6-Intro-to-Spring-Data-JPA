package com.example.Thymeleaf.Demo.controllers;


import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create-fighter")
public class CreateFighterController {

    private final FighterService fighterService;

    @Autowired
    public CreateFighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping
    public String showCreateForm(Model model) {
        model.addAttribute("fighter", new Fighter());
        return "create-fighter";
    }

    @PostMapping
    public String createFighter(@Valid @ModelAttribute("fighter") Fighter fighter,
                                BindingResult bindingResult) {
        // If there are validation errors, return to the form
        if (bindingResult.hasErrors()) {
            return "create-fighter";
        }

        // Save fighter to database via repository (replaces old in-memory list)
        fighterService.saveFighter(fighter);

        // Redirect to fighter list on success
        return "redirect:/fighters";
    }
}