package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Fighter getFighterById(int id) {
        return fighterRepository.findById(id).orElse(null);
    }

    public void deleteFighter(int id) {
        fighterRepository.deleteById(id);
    }

    public long getFighterCount() {
        return fighterRepository.count();
    }

    public boolean fighterExists(int id) {
        return fighterRepository.existsById(id);
    }
}
