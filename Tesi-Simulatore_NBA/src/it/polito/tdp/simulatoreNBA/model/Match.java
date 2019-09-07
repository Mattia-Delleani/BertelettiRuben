package it.polito.tdp.simulatoreNBA.model;

import java.util.ArrayList;
import java.util.List;

public class Match {
	
	private Integer idMatch;
	private Integer homePoints;
	private Integer awayPoints;
	private Team home;
	private Team away;
	private Team winner;
	private List<PlayerAVGStats> playerStats;
	private List<Player> injured;
	
	public Match(Integer idMatch, Integer homePoints, Integer awayPoints, Team home, Team away, Team winner) {
		super();
		this.idMatch = idMatch;
		this.homePoints = homePoints;
		this.awayPoints = awayPoints;
		this.home = home;
		this.away = away;
		this.winner = winner;
		this.playerStats = new ArrayList<PlayerAVGStats>();
		this.injured = new ArrayList<>();
		
	}
	
	public void initStats() {
		for(Player hp : home.getPlayers()) {
			playerStats.add(new PlayerAVGStats(hp.getName(), 0, 0.0, 0.0, 0.0, 0.0));
		}
		for(Player ap : away.getPlayers()) {
			playerStats.add(new PlayerAVGStats(ap.getName(), 0, 0.0, 0.0, 0.0, 0.0));
		}
	}
	
	public List<PlayerAVGStats> getHomeStats(){
		List<PlayerAVGStats> home = new ArrayList<>();
		for(PlayerAVGStats pas : this.playerStats) {
			for(Player p : this.home.getPlayers()) {
				if(p.getName().equals(pas.getName())) {
					home.add(pas);
				}
			}
		}
		
		return home;
	}
	
	public List<PlayerAVGStats> getAwayStats(){
		List<PlayerAVGStats> away = new ArrayList<>();
		for(PlayerAVGStats pas : this.playerStats) {
			for(Player p : this.away.getPlayers()) {
				if(p.getName().equals(pas.getName())) {
					away.add(pas);
				}
			}
		}
		
		return away;
	}

	public Integer getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(Integer idMatch) {
		this.idMatch = idMatch;
	}

	public Integer getHomePoints() {
		return homePoints;
	}

	public void setHomePoints(Integer homePoints) {
		this.homePoints = homePoints;
	}

	public Integer getAwayPoints() {
		return awayPoints;
	}

	public void setAwayPoints(Integer awayPoints) {
		this.awayPoints = awayPoints;
	}

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getAway() {
		return away;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}	

	public List<PlayerAVGStats> getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(List<PlayerAVGStats> playerStats) {
		this.playerStats = playerStats;
	}
	
	public List<Player> getInjured() {
		return injured;
	}

	public void setInjured(List<Player> injured) {
		this.injured = injured;
	}

	
	
	public String getScore(){
		return this.home.getAbbreviation() + " " + this.homePoints+ " vs " + this.away.getAbbreviation() + " " + this.awayPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMatch == null) ? 0 : idMatch.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (idMatch == null) {
			if (other.idMatch != null)
				return false;
		} else if (!idMatch.equals(other.idMatch))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.home.getAbbreviation() + " " + this.homePoints+ " vs " + this.away.getAbbreviation() + " " + this.awayPoints + " Winner: " + this.winner.getName();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
