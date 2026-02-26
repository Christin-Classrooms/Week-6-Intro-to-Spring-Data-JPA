package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FighterService {

    
    @Autowired
    private com.example.Thymeleaf.Demo.repository.FighterRepository fighterRepository;

    public List<Fighter> getAllFighters()
    {
        return fighterRepository.findAll();
    }

    public Fighter saveFighter(Fighter fighter)
    {
        return fighterRepository.save(fighter);
    }

    public void addFighter(Fighter fighter)
    {
        fighterRepository.save(fighter);
    }

    public Optional<Fighter> getFighter(int id)
    {
        return fighterRepository.findById(id);
    }

    public void deleteFighter(int id)
    {
        fighterRepository.deleteById(id);
    }   

    public long countFighters()
    {
        return fighterRepository.count();
    }

    public boolean existsFighter(int id)
    {
        return fighterRepository.existsById(id);
    }

    public Fighter updateFighter(Fighter fighter)
    {
        return fighterRepository.save(fighter);
    }
}
