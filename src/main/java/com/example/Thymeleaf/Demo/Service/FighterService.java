package com.example.Thymeleaf.Demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;

@Service
public class FighterService {

    
    private FighterRepository repo;
   
    

    public FighterService(FighterRepository repo) {
        this.repo = repo;
    }

    public List<Fighter> getAllFighters() {
        return repo.findAll();
    }

    public void addFighter(Fighter fighter) {
        repo.save(fighter);
    }

    public Fighter getFighterById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public long count() {
        return repo.count();
    }

    public boolean existsById(int id){
        return repo.existsById(id);
    }

}
