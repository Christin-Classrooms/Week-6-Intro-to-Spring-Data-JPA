package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    private final FighterRepository repo;

    public FighterService(FighterRepository repo) {
        this.repo = repo;
    }

    public Fighter save(Fighter fighter) {
        return repo.save(fighter);
    }

    public List<Fighter> findAll() {
        return repo.findAll();
    }

    public Fighter findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
