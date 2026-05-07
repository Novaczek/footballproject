package com.codingwithkuba.football.service;

import com.codingwithkuba.football.model.Player;
import com.codingwithkuba.football.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public Player updatePlayer(Long id, Player player) {
        Player existing = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        existing.setName(player.getName());
        existing.setAge(player.getAge());
        existing.setPosition(player.getPosition());
        existing.setTeam(player.getTeam());

        return playerRepository.save(existing);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}