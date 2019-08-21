package it.polito.tdp.simulatoreNBA.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	private List<Player> hPlayers;
	private List<Player> aPlayers;
	private NBADao dao;
	private List<Evento> eventList;
	
	
	//Parametri simulazione
	private final Integer matchDurations = 48 * 60; //rappresentazione in secondi
	private Integer TEMPO_COSTANTE_AZIONE = 5; 
	private Integer TEMPO_RANDOM_AZIONE = 15;
	private Double PROB_RIMBALZO = 0.8;
	private Double PROB_STOPPATA = 0.5;
	private Integer PROB_TENTATIVO_FISSA = 70;
	private Integer PROB_TENTATIVO_RANDOM = 50;		
	
	
	public void init(Team home, Team away) {
		
		this.awayPoints = 0;
		this.homePoints = 0;
		
		this.playerRandom = new ArrayList<Player>();
				
		this.eventList = new ArrayList<>();
		
		this.match = new Match(idMatch, this.homePoints, this.awayPoints, home, away, null);
		
		this.dao = new NBADao();
		this.rand = new Random();
		
		this.hPlayers = dao.getPlayerByTeam(home.getName());
		this.aPlayers = dao.getPlayerByTeam(away.getName());
				
		home.setPlayers(hPlayers);
		away.setPlayers(aPlayers);
		
		this.playerRandom.addAll(hPlayers);
		this.playerRandom.addAll(aPlayers);
		
		Collections.shuffle(playerRandom);
		
		this.match.setAway(away);
		this.match.setHome(home);
		
		this.match.initStats();
		
		for(PlayerAVGStats pas : match.getPlayerStats()) {//aggiornamento match giocato
			pas.setnGames(pas.getnGames() + 1);
		}
		
		//System.out.println(match.getPlayerStats());
		
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
				Integer attempt3 = (int) ((((rand.nextInt(this.PROB_TENTATIVO_RANDOM) + this.PROB_TENTATIVO_FISSA) * homeP.getThreePointsAttempts()) / 100));
				for(int i = 0; i < attempt3; i++) {
					
					if(homeP.getTeam().equals(home.getName())) {
						
						this.eventList.add(new Evento(null, TipoEvento.THREE_POINTS_ATTEMPT,home, homeP));
						
					}else {
						
						this.eventList.add(new Evento(null, TipoEvento.THREE_POINTS_ATTEMPT,away, homeP));
						
					}
					
				}
				
				Integer attempt2 = (int) ((((rand.nextInt(this.PROB_TENTATIVO_RANDOM) + this.PROB_TENTATIVO_FISSA) * homeP.getFieldGoalAttempts()) / 100));
				for(int i = 0; i < attempt2; i++) {
					
					if(homeP.getTeam().equals(home.getName())) {
						
						this.eventList.add(new Evento(null, TipoEvento.FIELD_GOAL_ATTEMPT, home, homeP));
						
					}else {
						
						this.eventList.add(new Evento(null, TipoEvento.FIELD_GOAL_ATTEMPT, away, homeP));
						
					}
					
				}
				
				Integer freeT = (int) ((((rand.nextInt(this.PROB_TENTATIVO_RANDOM) + this.PROB_TENTATIVO_FISSA) * homeP.getFreeThrowsAttempts()) / 100));
				for(int i = 0; i < freeT; i++) {
					if(homeP.getTeam().equals(home.getName())) {
						
						this.eventList.add(new Evento(null, TipoEvento.FREE_THROW_ATTEMPT, home, homeP));
						
					}else {
						
						this.eventList.add(new Evento(null, TipoEvento.FREE_THROW_ATTEMPT, away, homeP));
						
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
					String name = "";
					for(PlayerAVGStats pas : match.getPlayerStats()) {
						if(pas.getName().equals(ev.getPlayer().getName())) {
							pas.setPoint(pas.getPoint() + 2);
							name = pas.getName();
						}
						if(!name.equals("") && !pas.getName().equals(name)) {//MODELLAZIONE ASSIST
							//seleziono un giocatore dello stesso team
							if(team.equals(match.getHome())) {
								Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
								for(PlayerAVGStats pas2 : match.getPlayerStats()) {
									if(pas2.getName().equals(random.getName()) && pas2.getAssist() < (random.getAssists() + 0.2 * rand.nextDouble())) {
										pas2.setAssist(pas2.getAssist() + 1);
									}
								}
								
							}else {
								Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
								for(PlayerAVGStats pas2 : match.getPlayerStats()) {
									if(pas2.getName().equals(random.getName()) && pas2.getAssist() < (random.getAssists() + 0.2 * rand.nextDouble())) {
										pas2.setAssist(pas2.getAssist() + 1);
									}
								}
							}
						}
					}
					
					if(team.getName().equals(this.match.getHome().getName())) {
						this.homePoints = this.homePoints + 2;
					}else {
						this.awayPoints = this.awayPoints + 2;
					}//FINO A QUI TENTATIVO RIUSCITO
					
				}else {//se non fanno canestro il team avversario può prendere un rimbalzo o stoppare casi separati per team
					if(team.equals(this.match.getHome())) {
						if(rand.nextDouble() < this.PROB_RIMBALZO) {//rimbalzo al 50%
							Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
							for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
								if(pas.getName().equals(random.getName()) /*&& pas.getRebounds() < (random.getRebounds() + 0.2 * rand.nextDouble())*/) {
									pas.setRebounds(pas.getRebounds() + 1);	//do uno scarto fino al 10% della edia rimbalzi
								}
							}
						}else if(rand.nextDouble() <= this.PROB_STOPPATA) {//stoppata 
							Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
							for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
								if(pas.getName().equals(random.getName()) && pas.getBlock() < (random.getBlocks() + 0.2 * rand.nextDouble())) {
									pas.setBlock(pas.getBlock() + 1);
								}
							}
						}						
					}else {													
							if(rand.nextDouble() < this.PROB_RIMBALZO) {//rimbalzo al 30%
								Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
								for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
									if(pas.getName().equals(random.getName()) /*&& pas.getRebounds() < (random.getRebounds() + 0.2 * rand.nextDouble())*/) {
										pas.setRebounds(pas.getRebounds() + 1);	//do uno scarto fino al 10% della edia rimbalzi
									}
								}
							}else if(rand.nextDouble() < this.PROB_STOPPATA) {//stoppata al 10%
								Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
								for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
									if(pas.getName().equals(random.getName()) && pas.getBlock() < (random.getBlocks() + 0.2 * rand.nextDouble())) {
										pas.setBlock(pas.getBlock() + 1);
									}
								}
							}							
						
					}
					
				}
				break;
				
			case THREE_POINTS_ATTEMPT:
				if(ev.getPlayer().getThreePointsPercentage() > rand.nextDouble()) {
					String name = "";
					//aggiorno lo score punti player globale
					for(PlayerAVGStats pas : match.getPlayerStats()) {
						if(pas.getName().equals(ev.getPlayer().getName())) {
							pas.setPoint(pas.getPoint() + 3);
						}
						if(!name.equals("") && !pas.getName().equals(name)) {//MODELLAZIONE ASSIST
							//seleziono un giocatore dello stesso team
							if(team.equals(match.getHome())) {
								Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
								for(PlayerAVGStats pas2 : match.getPlayerStats()) {
									if(pas2.getName().equals(random.getName()) && pas2.getAssist() < (random.getAssists() + 0.2 * rand.nextDouble())) {
										pas2.setAssist(pas2.getAssist() + 1);
									}
								}
							}else {
								Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
								for(PlayerAVGStats pas2 : match.getPlayerStats()) {
									if(pas2.getName().equals(random.getName()) && pas2.getAssist() < (random.getAssists() + 0.2 * rand.nextDouble())) {
										pas2.setAssist(pas2.getAssist() + 1);
									}
								}
							}
						}
					}
					
					if(team.getName().equals(this.match.getHome().getName())) {
						this.homePoints = this.homePoints + 3;
					}else {
						this.awayPoints = this.awayPoints + 3;
					}//FINO A QUI TENTATIVO RIUSCITO
					
				}else {
					/*
					 * Se il giocatore sbaglia il tiro, un giocatore random del team avversario ha la possibilità di prendere un rimbalzo;
					 * altrimenti si assegna una stoppata oppure nulla
					 */
					

					if(team.equals(this.match.getHome())) {
						if(rand.nextDouble() < this.PROB_RIMBALZO) {//rimbalzo al 50%
							Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
							for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
								if(pas.getName().equals(random.getName()) /*&& pas.getRebounds() < (random.getRebounds() + 0.2 * rand.nextDouble())*/) {
									pas.setRebounds(pas.getRebounds() + 1);	//do uno scarto fino al 10% della edia rimbalzi
								}
							}
						}else if(rand.nextDouble() < this.PROB_STOPPATA) {//stoppata 
							Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
							for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
								if(pas.getName().equals(random.getName()) && pas.getBlock() < (random.getBlocks() + 0.2 * rand.nextDouble())) {
									pas.setBlock(pas.getBlock() + 1);
								}
							}
						}						
					}else {													
							if(rand.nextDouble() < this.PROB_RIMBALZO) {//rimbalzo al 30%
								Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
								for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
									if(pas.getName().equals(random.getName()) /*&& pas.getRebounds() < (random.getRebounds() + 0.2 * rand.nextDouble())*/) {
										pas.setRebounds(pas.getRebounds() + 1);	//do uno scarto fino al 10% della edia rimbalzi
									}
								}
							}else if(rand.nextDouble() < this.PROB_STOPPATA) {//stoppata al 10%
								Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
								for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
									if(pas.getName().equals(random.getName()) && pas.getBlock() < (random.getBlocks() + 0.2 * rand.nextDouble())) {
										pas.setBlock(pas.getBlock() + 1);
									}
								}
							}							
						
					}
					
				}
				break;
				
			case FREE_THROW_ATTEMPT:
				if(ev.getPlayer().getFreeThrowsPercentage() > rand.nextDouble()) {
					//aggiorno lo score player globale
					for(PlayerAVGStats pas : match.getPlayerStats()) {
						if(pas.getName().equals(ev.getPlayer().getName())) {
							pas.setPoint(pas.getPoint() + 1);
						}
					}
					
					if(team.getName().equals(this.match.getHome().getName())) {
						this.homePoints ++;
					}else {
						this.awayPoints ++;
					}
				}else {
					
				}
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
