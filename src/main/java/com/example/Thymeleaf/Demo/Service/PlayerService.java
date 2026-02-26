package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Player;
import com.example.Thymeleaf.Demo.repository.PlayerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    // ADD PLAYER
    public void addPlayer(Player player) {
        playerRepo.save(player);
    }

    // GET ALL PLAYERS
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    // GET PLAYER BY ID
    public Player getPlayerById(Integer id) {
        return playerRepo.findById(id);
    }

    // DELETE PLAYER (optional)
    public void deletePlayer(Integer id) {
        // add later if needed
    }
}