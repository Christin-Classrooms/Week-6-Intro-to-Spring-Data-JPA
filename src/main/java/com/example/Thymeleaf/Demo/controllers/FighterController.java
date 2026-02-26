package com.example.Thymeleaf.Demo.controllers;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;


import java.util.List;

@Controller
@RequestMapping("/fighters")
public class FighterController {

    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping
    public String getAllFighters(Model model) {
        List<Fighter> fighters = fighterService.getAllFighters();

        model.addAttribute("fighters", fighters);
        model.addAttribute("total", fighters.size());
        return "Fighters";
    }



@GetMapping("/new")
public String showNewFighterForm(Model model) {
    model.addAttribute("fighter", new Fighter());
    return "NewFighter";
}

@PostMapping("/save")
public String saveFighter(@Valid @ModelAttribute("fighter") Fighter fighter, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "NewFighter";
    }
    fighterService.saveFighter(fighter);
    return "redirect:/fighters";
}

@GetMapping("/delete/{id}")
public String deleteFighter(@PathVariable int id) {
    fighterService.deleteFighter(id);
    return "redirect:/fighters";
}

}