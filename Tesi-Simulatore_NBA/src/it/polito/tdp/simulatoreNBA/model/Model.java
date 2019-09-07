package it.polito.tdp.simulatoreNBA.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.simulatoreNBA.db.NBADao;

public class Model {
	
	private List<Team> EastTeams;
	private List<Team> WestTeams;
	private Map<String, Team> winnerTeamMap; 
	private Simulatore sim;
	private Team eastWinner;
	private Team westWinner;
	private Integer winH;
	private Integer winA;
	private Team globalWinner;
	private List<Match> matchs;
	private List<PlayerAVGStats> finalStats;
	
	/**
	 * Mappe che tengono traccia delle serie:
	 * -l'indice Integer parte da 1 in alto a sx per l'ovest a scendere
	 * 	e da 1 in alto a dx per l'est, 
	 * la finale viene salvata nella mappa west
	 */
	private Map<Integer, Series> seriesMapWest;
	private Integer idSeriesWest = 1;
	
	private Map<Integer, Series> seriesMapEast;
	private Integer idSeriesEast = 1;
	

		
	private NBADao dao;
	
	public Model() {
		
		this.dao = new NBADao();
		this.sim = new Simulatore();
				
		this.EastTeams = dao.getEastTeams();
		this.WestTeams = dao.getWestTeams();
		this.matchs = new ArrayList<>();
		this.finalStats = new ArrayList<PlayerAVGStats>();
		this.seriesMapWest = new HashMap<>();
		this.seriesMapEast = new HashMap<>();
		
		this.winnerTeamMap = new HashMap<String, Team>();
		
		this.eastWinner = null;
		this.westWinner = null;
		this.globalWinner = null;
	}
	
	public Team SimulationWinner(Team home, Team away) {
		
		Series series = new Series(home, away);
		
		this.winA = 0;
		this.winH = 0;		
		
		for(int i = 1; i <= 7 ; i++) {
			if(winA == 4 || winH == 4) {
				break;
			}else{
				sim.init(home, away);
				sim.run();
				
				if(sim.getMatch().getWinner().equals(home)) {
					this.winH++;
					series.setWinHome(series.getWinHome() + 1);
					series.getMatches().add(sim.getMatch()); 
				}else {
					this.winA++;
					series.setWinAway(series.getWinAway() + 1);
					series.getMatches().add(sim.getMatch());
				}
				
				this.matchs.add(sim.getMatch());
				if(this.eastWinner != null && this.westWinner != null) {
					this.finalStats.addAll(sim.getMatch().getPlayerStats());
				}
				
				
			}
			
			
		}
		
		if(winA > winH) {
			this.winnerTeamMap.put(away.getAbbreviation(), away);
			series.setWinner(away);
			if(this.WestTeams.contains(home)) {
				this.seriesMapWest.put(idSeriesWest, series);
				this.idSeriesWest ++;
			}else {
				this.seriesMapEast.put(idSeriesEast, series);
				this.idSeriesEast ++;
			}
			
			return away;
		}
			
		else {
			this.winnerTeamMap.put(home.getAbbreviation(), home);
			series.setWinner(home);
			if(this.WestTeams.contains(home)) {
				this.seriesMapWest.put(idSeriesWest, series);
				this.idSeriesWest ++;
			}else {
				this.seriesMapEast.put(idSeriesEast, series);
				this.idSeriesEast ++;
			}
			return home;
		}
	}
	
	public PlayerAVGStats avgByPlayer(Player player){
		int ngame = 0;
		Double points = 0.0;
		Double assists = 0.0;
		Double rebounds = 0.0;
		Double blocks = 0.0;
			
			for(PlayerAVGStats pas : this.finalStats) {
				if(player.getName().equals(pas.getName()) && pas.getNgames() == 1) {
					ngame ++;
					points = points + pas.getPoint();
					assists = assists + pas.getAssist();
					rebounds = rebounds + pas.getRebounds();
					blocks = blocks + pas.getBlock();
										
				}
			}
		
		
		PlayerAVGStats avg = new PlayerAVGStats(player.getName(), ngame, points / ngame, assists / ngame, rebounds / ngame, blocks / ngame);
		
		return avg;
	}
	
	public PlayerAVGStats findMVP() {
		
		List<PlayerAVGStats> east = new ArrayList<>();
		List<PlayerAVGStats> west = new ArrayList<>();
		List<PlayerAVGStats> all = new ArrayList<>();
		
		for(Player p1 : this.eastWinner.getPlayers()) {
			east.add(this.avgByPlayer(p1));
		}
		
		for(Player p2 : this.westWinner.getPlayers()) {
			west.add(this.avgByPlayer(p2));
		}
		
		all.addAll(west);
		all.addAll(east);
		
		PlayerAVGStats best = null;
		Double bestTotal = Double.MIN_VALUE;
		
		for(PlayerAVGStats pas : all) {
			Double tot = pas.getPoint() + pas.getAssist() + pas.getBlock() +pas.getRebounds();
			if(tot > bestTotal) {
				best = pas;
				bestTotal = tot;
			}
		}
		
		return best;
		
	}
	
	/*public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}*/
	
	public String res() {
		return winH + " " + winA;
	}

	public List<Team> getEastTeams() {
		return EastTeams;
	}

	public List<Team> getWestTeams() {
		return WestTeams;
	}

	public Map<String, Team> getWinnerTeamMap() {
		return winnerTeamMap;
	}

	public void saveEastWinner(Team eastWinner) {
		this.eastWinner = eastWinner;
	}
	
	public void saveWestWinner(Team westWinner) {
		this.westWinner = westWinner;
	}

	public Team getEastWinner() {
		return eastWinner;
	}

	public Team getWestWinner() {
		return westWinner;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public Team getGlobalWinner() {
		return globalWinner;
	}

	public void setGlobalWinner(Team globalWinner) {
		this.globalWinner = globalWinner;
	}

	public List<PlayerAVGStats> getFinalStats() {
		return finalStats;
	}

	public Map<Integer, Series> getSeriesMapWest() {
		return seriesMapWest;
	}

	public Map<Integer, Series> getSeriesMapEast() {
		return seriesMapEast;
	}

	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	

}
