package com.example.Thymeleaf.Demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public Fighter save(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    public List<Fighter> findAll() {
        return fighterRepository.findAll();
    }

    public Optional<Fighter> findById(Long id) {
        return fighterRepository.findById(id);
    }

    public void deleteById(Long id) {
        fighterRepository.deleteById(id);
    }

    public long count() {
        return fighterRepository.count();
    }

    public boolean existsById(Long id) {
        return fighterRepository.existsById(id);
    }
}