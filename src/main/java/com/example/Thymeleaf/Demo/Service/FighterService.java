package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    public Fighter addFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    public Optional<Fighter> getFighterById(Long id) {
        return fighterRepository.findById(id);
    }

    public void deleteFighterById(Long id) {
        fighterRepository.deleteById(id);
    }

    public long count() {
        return fighterRepository.count();
    }

    public boolean exists(Long id) {
        return fighterRepository.existsById(id);
    }
}
