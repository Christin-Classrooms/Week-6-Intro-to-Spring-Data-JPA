package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }
    
    public Optional<Fighter> getFighterById(Long id) {
        return fighterRepository.findById(id);
    }
    
    public Fighter saveFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }
    
    public void deleteFighter(Long id) {
        fighterRepository.deleteById(id);
    }
    
    public long countFighters() {
        return fighterRepository.count();
    }
    
    public boolean existsFighter(Long id) {
        return fighterRepository.existsById(id);
    }
}