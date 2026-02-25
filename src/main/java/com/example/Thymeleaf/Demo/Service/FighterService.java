package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    private FighterRepository repo;

    public FighterService(FighterRepository repo) {
        this.repo = repo;
    }

    public List<Fighter> getAllFighters() {
        return repo.findAll();
    }

    public void addFighter(Fighter fighter) {
        repo.save(fighter);
    }

    public Fighter getFighterById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Fighter saveFighter(Fighter fighter) {
        return repo.save(fighter);
    }

    public void deleteFighter(int id) {
        repo.deleteById(id);
    }

    public long countFighters() {
        return repo.count();
    }

    public boolean fighterExists(int id) {
        return repo.existsById(id);
    }

}