package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    private final FighterRepository fighterRepo;

    public FighterService(FighterRepository fighterRepo) {
        this.fighterRepo = fighterRepo;
    }

    
    public List<Fighter> getAllFighters() {
        return fighterRepo.findAll();
    }

    
    public Fighter saveFighter(Fighter fighter) {
        return fighterRepo.save(fighter);
    }

    public Optional<Fighter> getFighterById(Long id) {
        return fighterRepo.findById(id);
    }

    
    public void deleteFighterById(Long id) {
        fighterRepo.deleteById(id);
    }

    
    public long countFighters() {
        return fighterRepo.count();
    }

   
    public boolean fighterExists(Long id) {
        return fighterRepo.existsById(id);
    }
}