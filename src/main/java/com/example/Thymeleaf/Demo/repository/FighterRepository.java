package com.example.Thymeleaf.Demo.repository;

import com.example.Thymeleaf.Demo.Model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
    List<Fighter> id(long id);
}
