package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    // INSERT or UPDATE a fighter
    public Fighter saveFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    // SELECT a single fighter by ID
    public Fighter getFighterById(int id) {
        return fighterRepository.findById(id).orElse(null);
    }

    // SELECT all fighters
    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    // DELETE a fighter by ID
    public void deleteFighterById(int id) {
        fighterRepository.deleteById(id);
    }

    // COUNT total fighters
    public long countFighters() {
        return fighterRepository.count();
    }

    // Check if a fighter exists
    public boolean fighterExists(int id) {
        return fighterRepository.existsById(id);
    }
}
