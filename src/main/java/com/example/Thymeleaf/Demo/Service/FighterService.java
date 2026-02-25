package com.example.Thymeleaf.Demo.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;

@Service
public class FighterService {
    private final FighterRepository fightRepo;
    public FighterService(FighterRepository fightRepo) {
        this.fightRepo = fightRepo;
    }
    //save fighter
    public Fighter saveFighter(Fighter fighter) {
        return fightRepo.save(fighter);
    }

    //select all fighters
    public List<Fighter> getAllFighters() {
        return fightRepo.findAll();
    }

    //select single fighter by id
    public Fighter getFighterById(int id) {
        return fightRepo.findById(id).orElse(null);
    }

    // deleter by id
    public void deleteFighterById(int id) {
        fightRepo.deleteById(id);
    }

    // count fighters
    public long count() {
        return fightRepo.count();
    }
    
    // check if fighter exists
    public boolean fighterExists(int id) {
        return fightRepo.existsById(id);
    }
}
