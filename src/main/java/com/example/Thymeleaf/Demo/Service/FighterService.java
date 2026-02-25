package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    @Autowired
    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    public Fighter saveFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    public Optional<Fighter> getFighterById(Long id) {
        return fighterRepository.findById(id);
    }

    public void deleteFighter(Long id) {
        fighterRepository.deleteById(id);
    }

    public List<Fighter> searchByName(String name) {
        return fighterRepository.findByName(name);
    }
}