package com.codingwithkuba.football.controller;

import com.codingwithkuba.football.model.Team;
import com.codingwithkuba.football.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }


    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }


    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }


    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
        return teamService.updateTeam(id, team);
    }


    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}