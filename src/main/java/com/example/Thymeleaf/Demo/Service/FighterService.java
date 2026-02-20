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

    // findAll() -> SELECT all fighters
    public List<Fighter> getAllFighters() {
        return repo.findAll();
    }

    // save(fighter) -> INSERT or UPDATE a fighter
    public Fighter save(Fighter fighter) {
        return repo.save(fighter);
    }

    // use JPA
    public Fighter addFighter(Fighter fighter) {
        return repo.save(fighter);
    }

    // findById(id) -> SELECT a single fighter by ID
    public Optional<Fighter> findById(int id) {
        return repo.findById(id);
    }

    public Fighter getFighterById(int id) {
        return repo.findById(id).orElse(null);
    }

    // deleteById(id) -> DELETE a fighter by ID
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    // count() -> COUNT total fighters
    public long count() {
        return repo.count();
    }

    // existsById(id) -> Check if a fighter exists
    public boolean existsById(int id) {
        return repo.existsById(id);
    }
}