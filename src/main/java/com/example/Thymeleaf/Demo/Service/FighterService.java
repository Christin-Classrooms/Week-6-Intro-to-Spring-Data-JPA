package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    // Constructor Injection
    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    // CREATE (Add Fighter)
    public void addFighter(Fighter fighter) {
        fighterRepository.save(fighter);
    }

    // READ (Get All Fighters)
    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    // READ (Get Fighter By ID)
    public Optional<Fighter> getFighterById(Long id) {
        return fighterRepository.findById(id);
    }

    // DELETE
    public void deleteFighter(Long id) {
        fighterRepository.deleteById(id);
    }

    // COUNT (optional but useful)
    public long countFighters() {
        return fighterRepository.count();
    }

    // EXISTS CHECK (optional)
    public boolean fighterExists(Long id) {
        return fighterRepository.existsById(id);
    }
}