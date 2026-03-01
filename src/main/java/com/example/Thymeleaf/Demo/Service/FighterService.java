package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {
    
    @Autowired
    private FighterRepository fighterRepository;
    
    public Fighter save(Fighter fighter) {
        return fighterRepository.save(fighter);
    }
    
    public Optional<Fighter> findById(Long id) {
        return fighterRepository.findById(id);
    }
    
    public List<Fighter> findAll() {
        return fighterRepository.findAll();
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