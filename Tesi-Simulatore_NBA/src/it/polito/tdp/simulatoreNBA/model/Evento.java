package it.polito.tdp.simulatoreNBA.model;


public class Evento implements Comparable<Evento>{
	
	public enum TipoEvento{
		/*
		 * tentativi
		 */
		FREE_THROW_ATTEMPT,
		THREE_POINTS_ATTEMPT,
		FIELD_GOAL_ATTEMPT,
		
		/*
		 * infortunio
		 */
		INJURED
		
	}
	
	private Integer time;
	private TipoEvento type;
	private Team team;
	private Player player;
	
	
	public Evento(Integer time, TipoEvento type, Team team, Player player) {
		super();
		this.time = time;
		this.type = type;
		this.team = team;
		this.player = player;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public TipoEvento getType() {
		return type;
	}

	public void setType(TipoEvento type) {
		this.type = type;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return String.format("Evento -> time = %s, type = %s, player = %s\n", time, type,
				player);
	}

	@Override
	public int compareTo(Evento o) {
		return this.time.compareTo(o.getTime());
	}
	
	
	
	

}
