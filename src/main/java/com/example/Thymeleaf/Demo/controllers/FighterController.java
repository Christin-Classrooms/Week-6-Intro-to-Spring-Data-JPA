package com.example.Thymeleaf.Demo.controllers;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Service.FighterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FighterController {

    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping("/fighters")
    public String getFighters(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if(id != null)
        {
            Fighter fighter = fighterService.getFighterById(id);
            List<Fighter> fighters = new ArrayList<>();
            if(fighter != null){
                fighters.add(fighter);
            }
            model.addAttribute("fighters", fighters);
            model.addAttribute("total", fighters.size());
            return "Fighters";
        }


        List<Fighter> fighters = fighterService.getAllFighters();
        model.addAttribute("fighters", fighters);
        model.addAttribute("total", fighters.size());
        return "Fighters";
    }

}
