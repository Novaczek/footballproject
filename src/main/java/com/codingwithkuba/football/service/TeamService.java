package com.codingwithkuba.football.service;

import com.codingwithkuba.football.model.Team;
import com.codingwithkuba.football.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }


    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }


    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }


    public Team updateTeam(Long id, Team team) {
        team.setId(id);
        return teamRepository.save(team);
    }


    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
