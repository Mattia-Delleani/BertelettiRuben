package it.polito.tdp.simulatoreNBA.model;

import java.util.ArrayList;
import java.util.List;

public class Series {
	
	private Team home;
	private Team away;
	private List<Match> matches;
	private Integer winHome;
	private Integer winAway;
	private Team winner;
	
	public Series(Team home, Team away) {
		super();
		this.home = home;
		this.away = away;
		this.winHome = 0;
		this.winAway = 0;
		this.matches = new ArrayList<Match>();
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

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public Integer getWinHome() {
		return winHome;
	}

	public void setWinHome(Integer winHome) {
		this.winHome = winHome;
	}

	public Integer getWinAway() {
		return winAway;
	}

	public void setWinAway(Integer winAway) {
		this.winAway = winAway;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((away == null) ? 0 : away.hashCode());
		result = prime * result + ((home == null) ? 0 : home.hashCode());
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
		Series other = (Series) obj;
		if (away == null) {
			if (other.away != null)
				return false;
		} else if (!away.equals(other.away))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return winHome + " " + home + " - " + away + " " + winAway;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	

}
