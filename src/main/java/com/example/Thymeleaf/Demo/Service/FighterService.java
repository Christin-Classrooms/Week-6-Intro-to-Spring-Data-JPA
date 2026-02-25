package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepo;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class FighterService {

    
   private final FighterRepo fighterRepo;

    public FighterService(FighterRepo fighterRepo) {
        this.fighterRepo = fighterRepo;
    }

    public List<Fighter> getAllFighters() {
        return fighterRepo.findAll();
    }

    public void addFighter(Fighter fighter) {
        fighterRepo.save(fighter);
    }
}
