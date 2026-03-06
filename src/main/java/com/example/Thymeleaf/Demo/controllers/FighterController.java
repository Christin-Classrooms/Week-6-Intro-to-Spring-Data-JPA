package com.example.Thymeleaf.Demo.controllers;

import com.example.Thymeleaf.Demo.Service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FighterController {

    @Autowired
    private FighterService fighterService;

    @GetMapping("/fighters")
    public String showFighters(Model model) {
        model.addAttribute("fighters", fighterService.getAllFighters());
        return "fighters";
    }
}