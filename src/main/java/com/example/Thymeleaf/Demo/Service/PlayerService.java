package com.example.Thymeleaf.Demo.Service;

import com.example.Thymeleaf.Demo.Model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Player1", "player1@gmail.com"));
        players.add(new Player(2, "Player2", "player2@gmail.com"));
        players.add(new Player(3, "Player3", "player3@gmail.com"));
        players.add(new Player(4, "Player4", "player4@gmail.com"));
        players.add(new Player(5, "Player5", "player5@gmail.com"));
        return players;
    }

}
