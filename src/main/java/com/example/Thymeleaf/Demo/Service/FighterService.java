package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    private final FighterRepository repo;

    public FighterService(FighterRepository repo) {
        this.repo = repo;
    }

    public List<Fighter> getAllFighters() {
        return repo.findAll();
    }

    public void addFighter(Fighter fighter) {
        repo.save(fighter);
    }

    public Fighter getFighterById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteFighterById(Long id) {
        repo.deleteById(id);
    }

    public long countFighters() {
        return repo.count();
    }

    public boolean existsById(Long id) {
        return repo.existsById(id);
    }
}
