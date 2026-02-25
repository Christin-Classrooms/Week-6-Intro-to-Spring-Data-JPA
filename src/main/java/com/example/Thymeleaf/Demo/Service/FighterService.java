package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    public Fighter saveFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }
    
    public Fighter getFighterById(Long id) {
        return fighterRepository.findById(id).orElse(null);
    }
    
    public void deleteFighter(Long id) {
        fighterRepository.deleteById(id);
    }
    
    public long countFighters() {
        return fighterRepository.count();
    }
    
    public boolean existsById(Long id) {
        return fighterRepository.existsById(id);
    }
}