package com.codingwithkuba.football.service;

import com.codingwithkuba.football.model.Match;
import com.codingwithkuba.football.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
    }

    public Match updateMatch(Long id, Match match) {
        Match existing = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        existing.setHomeTeam(match.getHomeTeam());
        existing.setAwayTeam(match.getAwayTeam());
        existing.setHomeScore(match.getHomeScore());
        existing.setAwayScore(match.getAwayScore());

        return matchRepository.save(existing);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}