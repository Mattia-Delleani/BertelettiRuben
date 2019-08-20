package it.polito.tdp.simulatoreNBA.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.simulatoreNBA.model.Team;
import it.polito.tdp.simulatoreNBA.model.Player;
import it.polito.tdp.simulatoreNBA.model.PlayerAVGStats;

public class NBADao {
	
	public List<Team> getEastTeams(){
		
		String sql = "SELECT * " + 
				"FROM teams t " + 
				"WHERE t.conference = 'east'";
		
		List<Team> result = new ArrayList<Team>();
		

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Team team = new Team(rs.getString("abbreviation"), rs.getString("name"), "east");
				result.add(team);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return result;
		
	}
	
	public List<Team> getWestTeams(){
		
		String sql = "SELECT * " + 
				"FROM teams t " + 
				"WHERE t.conference = 'west'";	
		
		List<Team> result = new ArrayList<Team>();
		

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Team team = new Team(rs.getString("abbreviation"), rs.getString("name"), "west");
				result.add(team);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return result;
		
	}
	
	public List<Player> getPlayerByTeam(String team){
		
		
		String sql = "SELECT * " + 
				"from player_stats p " + 
				"WHERE p.Team = ?";
		
		List<Player> teamsPlayers = new ArrayList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, team);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Player p = new Player(rs.getString("name"),
						team,
						rs.getInt("age"), 
						rs.getDouble("points"),
						rs.getDouble("blocks"),
						rs.getDouble("steals"),
						rs.getDouble("assists"),
						rs.getDouble("rebounds"),
						rs.getDouble("ft"),
						rs.getDouble("fta"),
						rs.getDouble("fg3"),
						rs.getDouble("fg3a"),
						rs.getDouble("fg"),
						rs.getDouble("fga"),
						rs.getDouble("mp"));
				teamsPlayers.add(p);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return teamsPlayers;
	}
	
	public Map<String, PlayerAVGStats> getAllPlayer(){
		
		String sql = "SELECT name " + 
				"FROM player_stats " + 
				"WHERE team IS NOT null";
		
		Map<String, PlayerAVGStats> allPlayers = new HashMap<String, PlayerAVGStats>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				PlayerAVGStats p = new PlayerAVGStats(rs.getString("name"),
						0,
						0.0,
						0.0,
						0.0,
						0.0);
						
				
				allPlayers.put(p.getName(), p);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return allPlayers;
		
	}

}
