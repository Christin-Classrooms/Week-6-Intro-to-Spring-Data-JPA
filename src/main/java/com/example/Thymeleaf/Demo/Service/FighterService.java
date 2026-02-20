package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    @Autowired
    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    // READ: get all fighters from database
    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    // CREATE: save fighter to database
    public void addFighter(Fighter fighter) {
        fighterRepository.save(fighter);
    }
}