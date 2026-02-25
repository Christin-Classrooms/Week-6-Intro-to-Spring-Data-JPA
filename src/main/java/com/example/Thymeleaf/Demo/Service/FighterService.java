package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    // CREATE / UPDATE
    public Fighter save(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    // READ ALL
    public List<Fighter> findAll() {
        return fighterRepository.findAll();
    }

    // READ ONE
    public Optional<Fighter> findById(Long id) {
        return fighterRepository.findById(id);
    }

    // DELETE
    public void deleteById(Long id) {
        fighterRepository.deleteById(id);
    }

    // EXTRA METHODS (from JpaRepository list)
    public long count() {
        return fighterRepository.count();
    }

    public boolean existsById(Long id) {
        return fighterRepository.existsById(id);
    }
}