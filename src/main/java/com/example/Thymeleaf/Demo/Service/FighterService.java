package com.example.Thymeleaf.Demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepo;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class FighterService {

    
   private final FighterRepo fighterRepo;

    public FighterService(FighterRepo fighterRepo) {
        this.fighterRepo = fighterRepo;
    }

    public List<Fighter> getAllFighters() {
        return fighterRepo.findAll();
    }

    public void addFighter(Fighter fighter) {
        fighterRepo.save(fighter);
    }


    public Page<Fighter> getAllFighters(Pageable pageable) {
    return fighterRepo.findAll(pageable);
    }

    public Page<Fighter> searchByName(String name, Pageable pageable) {
    return fighterRepo.findByNameContainingIgnoreCase(name, pageable);
    }

    public Page<Fighter> filterByHealth(int health, Pageable pageable) {
    return fighterRepo.findByHealthGreaterThan(health, pageable);
    }

    public Page<Fighter> strongest(Pageable pageable) {
    return fighterRepo.findStrongestFighters(pageable);
    }

    public Page<Fighter> balanced(double minHealth, double maxDamage, Pageable pageable) {
    return fighterRepo.findBalancedFighters(minHealth, maxDamage, pageable);
}
    }

    
