package com.example.Thymeleaf.Demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;

// =========================================================================================
// FIGHTER CONTROLLER - LISTING AND DELETING

@Controller
public class FighterController {

    // FIGHTERSERVICE DOES THE DATA STUFF
    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    // LOAD ALL FIGHTERS FROM THE DATABASE
    @GetMapping("/fighters")
    public String getFighters(Model model) {
        List<Fighter> fighters = fighterService.getAllFighters();

        model.addAttribute("fighters", fighters);
        
        // ALSO PASS THE COUNT SO THE TEMPLATE DOESN'T HAVE TO DO MATHS
        model.addAttribute("total", fighters.size());
        return "Fighters";
    }

    // =========================================================================================
    // ONE CLICK DEAD FIGHTER PUNCH
    
    @PostMapping("/fighters/{id}/delete")
    public String deleteFighter(@PathVariable int id) {
        fighterService.deleteFighterById(id);
        
        // OH NO. THE CONSEQUENCES OF MY ACTIONS HAVE ARRIVED.
        return "redirect:/fighters";
    }

}
