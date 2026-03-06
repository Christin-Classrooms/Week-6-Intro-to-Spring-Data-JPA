package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FighterService {

    @Autowired
    private FighterRepo fighterRepo;

    public void saveFighter(Fighter fighter) {
        fighterRepo.save(fighter); 
    }

    public List<Fighter> getAllFighters() {
        return fighterRepo.findAll(); 
    }
}