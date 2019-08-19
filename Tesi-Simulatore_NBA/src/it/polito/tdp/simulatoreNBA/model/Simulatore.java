package it.polito.tdp.simulatoreNBA.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.simulatoreNBA.db.NBADao;
import it.polito.tdp.simulatoreNBA.model.Evento.TipoEvento;

public class Simulatore {
	
	private PriorityQueue<Evento> queue = new PriorityQueue<>();
	private Random rand;
	private Match match;
	private Integer idMatch = 0;
	private List<Player> playerRandom;
	private Integer homePoints;
	private Integer awayPoints;
	private NBADao dao;
	private List<Evento> eventList;
	
	
	//Parametri simulazione
	private final Integer matchDurations = 48 * 60; //rappresentazione in secondi
	private Integer TEMPO_COSTANTE_AZIONE = 5; 
	private Integer TEMPO_RANDOM_AZIONE = 15;
	
	
	public void init(Team home, Team away) {
		
		this.awayPoints = 0;
		this.homePoints = 0;
		
		this.playerRandom = new ArrayList<Player>();
				
		this.eventList = new ArrayList<>();
		
		this.match = new Match(idMatch, this.homePoints, this.awayPoints, home, away, null);
		
		this.dao = new NBADao();
		this.rand = new Random();
		
		List<Player> hPlayers = dao.getPlayerByTeam(home.getName());
		List<Player> aPlayers = dao.getPlayerByTeam(away.getName());
				
		home.setPlayers(hPlayers);
		away.setPlayers(aPlayers);
		
		this.playerRandom.addAll(hPlayers);
		this.playerRandom.addAll(aPlayers);
		
		Collections.shuffle(playerRandom);
		
		this.match.setAway(away);
		this.match.setHome(home);
		
		Integer matchTime = 0;
		//Durata partita 48 minuti
			
		// Metto in coda un'azione in un periodo casuale tra 30s e 60s
			 
			/*
			 * CARICAMENTO CODA AZIONI
			 */
			for(Player homeP : this.playerRandom) {
				/*
				 * Ogni giocatore prende tiri in base alla media della regular season
				 * impostato attualmente al tra il 70% e 100% in modo randomico
				 */
				
				//trovare modo per aggiungere assist e stoppote
				Integer attempt3 = (int) ((((rand.nextInt(30) + 70) * homeP.getThreePointsAttempts()) / 100));
				for(int i = 0; i < attempt3; i++) {
					
					if(homeP.getTeam().equals(home.getName())) {
						
						this.eventList.add(new Evento(null, TipoEvento.THREE_POINTS_ATTEMPT,home, homeP, null, null));
						
					}else {
						
						this.eventList.add(new Evento(null, TipoEvento.THREE_POINTS_ATTEMPT,away, homeP, null, null));
						
					}
					
				}
				
				Integer attempt2 = (int) ((((rand.nextInt(30) + 70) * homeP.getFieldGoalAttempts()) / 100));
				for(int i = 0; i < attempt2; i++) {
					
					if(homeP.getTeam().equals(home.getName())) {
						
						this.eventList.add(new Evento(null, TipoEvento.FIELD_GOAL_ATTEMPT, home, homeP, null, null));
						
					}else {
						
						this.eventList.add(new Evento(null, TipoEvento.FIELD_GOAL_ATTEMPT, away, homeP, null, null));
						
					}
					
				}
				
				Integer freeT = (int) ((((rand.nextInt(30) + 70) * homeP.getFreeThrowsAttempts()) / 100));
				for(int i = 0; i < freeT; i++) {
					if(homeP.getTeam().equals(home.getName())) {
						
						this.eventList.add(new Evento(null, TipoEvento.FREE_THROW_ATTEMPT, home, homeP, null, null));
						
					}else {
						
						this.eventList.add(new Evento(null, TipoEvento.FREE_THROW_ATTEMPT, away, homeP, null, null));
						
					}
					
				}
				
			}
			
			/*
			 * Le istruzioni seguenti randomizzano la coda eventi:
			 * gli eventi si recuperano dalla lista, gli si assegna un tempo secondo i parametri e si aggiunge alla coda,
			 * fino a quando non si arriva a 48 minuti di partita
			 * 
			 */
			
			Collections.shuffle(eventList);
			
			for(Evento ev : this.eventList) {
				if(matchTime <= matchDurations) {
					matchTime = matchTime + ((rand.nextInt(this.TEMPO_RANDOM_AZIONE)) + this.TEMPO_COSTANTE_AZIONE);
					ev.setTime(matchTime);
					this.queue.add(ev);
				}
			}
		
	}
	
	public void run() {
		
		while(!queue.isEmpty()) {
			Evento ev = queue.poll();
			Team team = ev.getTeam();
			
			/*
			 * In base alle medie di realizzazione si valuta il successo del tentativo
			 */
			switch (ev.getType()) {
			
			case FIELD_GOAL_ATTEMPT:
				if(ev.getPlayer().getFieldGoalsPercentage() > rand.nextDouble()) {
					//aggiorno lo score player globale
					
					if(team.getName().equals(this.match.getHome().getName())) {
						this.homePoints = this.homePoints + 2;
					}else {
						this.awayPoints = this.awayPoints + 2;
					}
				}else {
					
				}
				break;
				
			case THREE_POINTS_ATTEMPT:
				if(ev.getPlayer().getThreePointsPercentage() > rand.nextDouble()) {
					//aggiorno lo score punti player globale
					
					if(team.getName().equals(this.match.getHome().getName())) {
						this.homePoints = this.homePoints + 3;
					}else {
						this.awayPoints = this.awayPoints + 3;
					}
				}else {
					
				}
				break;
				
			case FREE_THROW_ATTEMPT:
				if(ev.getPlayer().getFreeThrowsPercentage() > rand.nextDouble()) {
					//aggiorno lo score player globale
				
					if(team.getName().equals(this.match.getHome().getName())) {
						this.homePoints ++;
					}else {
						this.awayPoints ++;
					}
				}else {
					
				}
				break;
				
			case FAILED_ATTEMPT:
				break;
				
			case SUCCESSFUL_ATTEMPT:
				break;
			}
		}
		
		this.match.setAwayPoints(awayPoints);
		this.match.setHomePoints(homePoints);
		
		if(homePoints > awayPoints) {
			this.match.setWinner(this.match.getHome());
		}else {
			this.match.setWinner(this.match.getAway());
		}
		
	}
	
	

	public Match getMatch() {
		return match;
	}

	public PriorityQueue<Evento> getQueue() {
		return queue;
	}

	public List<Player> getPlayerRandom() {
		return playerRandom;
	}

	
	
	
	
	
	
	
	

}
