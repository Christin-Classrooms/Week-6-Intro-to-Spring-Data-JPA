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

@Controller
public class CreateFighterController {

    @Autowired
    private FighterService fighterService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("fighter", new Fighter());
        return "createFighter";
    }

    @PostMapping("/register")
    public String processForm(@Valid @ModelAttribute("fighter") Fighter fighter, BindingResult result) {
        if (result.hasErrors()) {
            return "createFighter";
        }
        fighterService.saveFighter(fighter); 
        return "redirect:/fighters";
    }
}