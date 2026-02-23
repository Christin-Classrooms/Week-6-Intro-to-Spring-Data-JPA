package com.example.Thymeleaf.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Thymeleaf.Demo.Model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
