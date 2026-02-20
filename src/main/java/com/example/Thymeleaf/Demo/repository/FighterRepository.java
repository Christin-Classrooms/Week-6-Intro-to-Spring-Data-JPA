package com.example.Thymeleaf.Demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Thymeleaf.Demo.Model.Fighter;

@Repository
public interface  FighterRepository extends JpaRepository<Fighter, Integer> {
    
}
