package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Player;
import com.example.Thymeleaf.Demo.repository.PlayerRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private PlayerRepo repo;




    public PlayerService(PlayerRepo repo) {

        this.repo = repo;
    }

    public List<Player> getAllPlayers() {
        
        return repo.findAll();
    }


     public void addPlayer(Player player) {

        repo.save(player);
    }




}
