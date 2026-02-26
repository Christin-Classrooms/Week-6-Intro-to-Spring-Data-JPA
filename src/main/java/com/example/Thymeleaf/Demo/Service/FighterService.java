package com.example.Thymeleaf.Demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;

@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    public void addFighter(Fighter fighter) {
        fighterRepository.save(fighter);
    }
}