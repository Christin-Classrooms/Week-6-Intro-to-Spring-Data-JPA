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

    // findAll
    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    // save (insert/update)
    public Fighter save(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    // findById
    public Optional<Fighter> getById(Long id) {
        return fighterRepository.findById(id);
    }

    // deleteById
    public void deleteById(Long id) {
        fighterRepository.deleteById(id);
    }

    // count
    public long count() {
        return fighterRepository.count();
    }

    // existsById
    public boolean existsById(Long id) {
        return fighterRepository.existsById(id);
    }
}