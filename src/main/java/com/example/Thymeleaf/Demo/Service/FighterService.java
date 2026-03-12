package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public void addFighter(Fighter fighter) {
        fighterRepository.save(fighter);
    }

    public Page<Fighter> getFighters(Pageable pageable){
        return fighterRepository.findAll(pageable);
    }

    public Page<Fighter> searchByName(String name, Pageable pageable){
        return fighterRepository.findByNameContainingIgnoreCase(name,pageable);
    }

    public Page<Fighter> filterByHealth(int health, Pageable pageable){
        return fighterRepository.findByHealthGreaterThan(health,pageable);
    }

    public Page<Fighter> strongest(Pageable pageable){
        return fighterRepository.findStrongestFighters(pageable);
    }

    public Page<Fighter> balanced(Pageable pageable){
        return fighterRepository.findBalancedFighters(1200,60,pageable);
    }
}