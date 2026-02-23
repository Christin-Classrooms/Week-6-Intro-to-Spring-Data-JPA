package com.example.Thymeleaf.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Thymeleaf.Demo.Model.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
}