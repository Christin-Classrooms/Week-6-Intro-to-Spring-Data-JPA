package com.example.Thymeleaf.Demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;

// =========================================================================================
// FIGHTERSERVICE HANDLES DATA

@Service
public class FighterService {

    // INJECTED VIA CONSTRUCTOR.
    // VERY WEIRD TO SEE .NET CORE / ENTITY FRAMEWORK SIMILIARITIES
    private final FighterRepository repo;

    public FighterService(FighterRepository repo) {
        this.repo = repo;
    }

    // FETCH ALL FIGHTERS FROM THE DATABASE
    public List<Fighter> getAllFighters() {
        return repo.findAll();
    }

    // INSERT OR UPDATE A FIGHTER BASED ON EXISTING ID
    public void addFighter(Fighter fighter) {
        repo.save(fighter);
    }

    // LOOK UP SINGLE FIGHTER BY ID - RETURNS NULL IF NOT FOUND INSTEAD OF EXPLODING IN A MIST OF BLOOD
    public Fighter getFighterById(int id) {
        return repo.findById(id).orElse(null);
    }

    // PERFORM A FATALITY ON FIGHTER ( YES, WRONG FRANCHISE )
    public void deleteFighterById(int id) {
        repo.deleteById(id);
    }

    // GET TOTAL NUM OF FIGHTERS
    public long count() {
        return repo.count();
    }

    // CHECKS IF A FIGHTER WITH THE GIVEN ID EXISTS
    public boolean existsById(int id) {
        return repo.existsById(id);
    }

}
