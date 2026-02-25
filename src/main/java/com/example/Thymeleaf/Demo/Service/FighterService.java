package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class FighterService {

    private FighterRepository fighterRepository;
    
    private List<Fighter> fighters;
    private static int nextId = 6;

    public FighterService() {
        fighters = new ArrayList<>();
        fighters.add(new Fighter(1, "Fighter1", 100, 15.5, 0.2));
        fighters.add(new Fighter(2, "Fighter2", 120, 12.0, 0.3));
        fighters.add(new Fighter(3, "Fighter3", 90, 18.5, 0.15));
        fighters.add(new Fighter(4, "Fighter4", 110, 14.0, 0.25));
        fighters.add(new Fighter(5, "Fighter5", 95, 16.5, 0.18));
    }

    public List<Fighter> getAllFighters() {
        return fighters;
    }

    public void addFighter(Fighter fighter) {
        fighter.setId(nextId++);
        fighters.add(fighter);
    }

    public void saveFighter(Fighter fighter) {
        fighterRepository.save(fighter);    
    }

    public Fighter findFighter(int id) {
        return fighterRepository.findById(id).orElse(null);
    }

    public void deleteFighter(int id) {
        fighterRepository.deleteById(id);
    }

    public long playerCount() {
        return fighterRepository.count();
    }

    public boolean fighterExists(int id) {
        return fighterRepository.existsById(id);
    }



}
