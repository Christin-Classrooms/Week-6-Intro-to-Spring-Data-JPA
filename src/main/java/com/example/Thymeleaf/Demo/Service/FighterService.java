package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Fighter findById(Integer id) {
        return fighterRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        fighterRepository.deleteById(id);
    }

    public long count() {
        return fighterRepository.count();
    }

    public boolean existsById(Integer id) {
        return fighterRepository.existsById(id);
    }
}