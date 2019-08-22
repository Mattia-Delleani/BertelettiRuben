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
	private List<String> result;
	private List<Match> matchs;
	private List<PlayerAVGStats> totalStats;
	private List<PlayerAVGStats> finalStats;
		
	private NBADao dao;
	
	public Model() {
		
		this.dao = new NBADao();
		this.sim = new Simulatore();
				
		this.EastTeams = dao.getEastTeams();
		this.WestTeams = dao.getWestTeams();
		this.matchs = new ArrayList<>();
		this.totalStats = new ArrayList<>();
		this.finalStats = new ArrayList<PlayerAVGStats>();
		this.winnerTeamMap = new HashMap<String, Team>();
		
		this.eastWinner = null;
		this.westWinner = null;
		this.globalWinner = null;
	}
	
	public Team SimulationWinner(Team home, Team away) {
		
		this.winA = 0;
		this.winH = 0;
		
		this.result = new ArrayList<>();
		
		
		for(int i = 1; i <= 7 ; i++) {
			if(winA == 4 || winH == 4) {
				break;
			}else{
				//System.out.println("<<<Start Game "+i+">>>\n\n");
				sim.init(home, away);
				sim.run();
				if(sim.getMatch().getWinner().equals(home)) {
					this.winH++;
					String res = this.sim.getMatch().toString();
					this.result.add(res);
				}else {
					this.winA++;
					String res = this.sim.getMatch().toString();
					this.result.add(res);
				}
				
				this.matchs.add(sim.getMatch());
				this.totalStats.addAll(sim.getMatch().getPlayerStats());//salvo le statistiche dei match
				if(this.eastWinner != null && this.westWinner != null) {
					this.finalStats.addAll(sim.getMatch().getPlayerStats());
				}
				
				
			}
			
			
		}
		
		if(winA > winH) {
			this.winnerTeamMap.put(away.getAbbreviation(), away);
			return away;
		}
			
		else {
			this.winnerTeamMap.put(home.getAbbreviation(), home);
			return home;
		}
					
		
	}
	
	public PlayerAVGStats avgByPlayer(Player player){
		int ngame = 0;
		Double points = 0.0;
		Double assists = 0.0;
		Double rebounds = 0.0;
		Double blocks = 0.0;
		
		if(this.eastWinner == null && this.westWinner == null) {
			for(PlayerAVGStats pas : this.totalStats) {
				if(player.getName().equals(pas.getName()) && pas.getNgames() == 1) {
					ngame ++;
					points = points + pas.getPoint();
					assists = assists + pas.getAssist();
					rebounds = rebounds + pas.getRebounds();
					blocks = blocks + pas.getBlock();
					
				}
			}
		}else {
			
			for(PlayerAVGStats pas : this.finalStats) {
				if(player.getName().equals(pas.getName()) && pas.getNgames() == 1) {
					ngame ++;
					points = points + pas.getPoint();
					assists = assists + pas.getAssist();
					rebounds = rebounds + pas.getRebounds();
					blocks = blocks + pas.getBlock();
					
				}
			}
		}
		
		
		PlayerAVGStats avg = new PlayerAVGStats(player.getName(), ngame, points / ngame, assists / ngame, rebounds / ngame, blocks / ngame);
		
		return avg;
	}
	
	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}
	
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
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	

}
