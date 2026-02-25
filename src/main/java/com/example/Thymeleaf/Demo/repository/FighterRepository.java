package com.example.Thymeleaf.Demo.repository;

import com.example.Thymeleaf.Demo.Model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {

    // Spring Data JPA will auto-implement these based on method naming conventions
    List<Fighter> findByName(String name);

    List<Fighter> findByHealthGreaterThan(Integer health);

    List<Fighter> findByDamageLessThan(Integer damage);
}