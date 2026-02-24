package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FighterService {

    private FighterRepository repo;
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

    public Fighter save(Fighter fighter) {
        return repo.save(fighter);
    }

    public Fighter findById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Iterable<Fighter> findAll() {
        return repo.findAll();
    } 

    public Fighter deleteById(int id) {
        Fighter fighter = findById(id);

        if (fighter != null) {
            repo.deleteById(id);
        }
        return fighter;
    }

    public int count() {
        return (int) repo.count();
    }

    public Fighter update(Fighter fighter) {
        if (repo.existsById(fighter.getId())) {
            return repo.save(fighter);
            
        } else {
            return null;
        }
    }
}

