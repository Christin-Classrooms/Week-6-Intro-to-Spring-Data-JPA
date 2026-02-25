package com.example.Thymeleaf.Demo.controllers;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fighters")
public class FighterController {

    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping
    public String listFighters(Model model) {
        List<Fighter> fighters = fighterService.getAllFighters();
        model.addAttribute("fighters", fighters);
        model.addAttribute("total", fighterService.countFighters());
        return "Fighters";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("fighter", new Fighter());
        return "CreateFighter"; 
    }

    @PostMapping("/save")
    public String saveFighter(@Valid @ModelAttribute Fighter fighter, 
                              BindingResult result, 
                              Model model) {
        if (result.hasErrors()) {
            return "CreateFighter";  // form error return
        }
        fighterService.saveFighter(fighter);
        return "redirect:/fighters";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Fighter fighter = fighterService.getFighterById(id);
        if (fighter != null) {
            model.addAttribute("fighter", fighter);
            return "CreateFighter";  // use same form for editing
        }
        return "redirect:/fighters";
    }

    @GetMapping("/delete/{id}")
    public String deleteFighter(@PathVariable Long id) {
        fighterService.deleteFighter(id);
        return "redirect:/fighters";
    }
}