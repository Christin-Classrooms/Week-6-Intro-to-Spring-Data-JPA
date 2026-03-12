package com.example.Thymeleaf.Demo.Service;
//Updated file for lab 4
import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    public void addFighter(Fighter fighter) {
        fighterRepository.save(fighter);
    }
}
