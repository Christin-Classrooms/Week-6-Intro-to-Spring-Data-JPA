package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    // SELECT all fighters
    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    // INSERT or UPDATE a fighter
    public Fighter addFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    // SELECT a single fighter by ID
    public Optional<Fighter> getFighterById(int id) {
        return fighterRepository.findById(id);
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
    public boolean fighterExistsById(int id) {
        return fighterRepository.existsById(id);
    }

}
