package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    private final FighterRepository repo;

    public FighterService(FighterRepository repo) {
        this.repo = repo;
    }

    public List<Fighter> getAllFighters() {
        return findAll();
    }

    public void addFighter(Fighter fighter) {
        save(fighter);
    }

    public Fighter save(Fighter fighter) {
        return repo.save(fighter);
    }

    public Optional<Fighter> findById(int id) {
        return repo.findById(id);
    }

    public List<Fighter> findAll() {
        return repo.findAll();
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public long count() {
        return repo.count();
    }

    public boolean existsById(int id) {
        return repo.existsById(id);
    }

}
