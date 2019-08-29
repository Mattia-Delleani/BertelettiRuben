package it.polito.tdp.simulatoreNBA.model;


import java.util.ArrayList;
import java.util.Collections;
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
	private Double PROB_RANDOM_ASSIST = 0.15;
	private Double PROB_PLUS_RANDOM_STOPPATA = 0.3;
	private Integer PROB_TENTATIVO_FISSA = 10;
	private Integer PROB_TENTATIVO_RANDOM = 140;	
	private Double PROB_INJURED = 0.0015;
	private Integer MAX_INJURED_TIME = 2;
	
	
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
		
		/*
		 * aggiornamento n partite		
		 */
		
		Integer matchTime = 0;
		//Durata partita 48 minuti
			
			 
			/*
			 * CARICAMENTO CODA AZIONI
			 */
			for(Player homeP : this.playerRandom) {
				
				/**
				 * Aggiornamento contegio infortuni
				 */
				if(home.getInjured().containsKey(homeP.getName()) && home.getInjured().get(homeP.getName()) > 0){
				
					home.getInjured().put(homeP.getName(), home.getInjured().get(homeP.getName()) -1);
					//System.err.println(homeP.getName() + " ANCORA INFORTUNATO");
					if(home.getInjured().get(homeP.getName()) == 0)
						home.getInjured().remove(homeP.getName());
					
				}else if(away.getInjured().containsKey(homeP.getName()) && away.getInjured().get(homeP.getName()) > 0) {
					
					away.getInjured().put(homeP.getName(), away.getInjured().get(homeP.getName()) -1);
					//System.err.println(homeP.getName() + " ANCORA INFORTUNATO");
					if(away.getInjured().get(homeP.getName()) == 0)
						away.getInjured().remove(homeP.getName());
					
				}else {
					
					for(PlayerAVGStats pas : match.getPlayerStats()) {
						if(pas.getName().equals(homeP.getName())) {
							pas.setNgames(pas.getNgames() + 1);
						}
					}
					
					/*
					 * Ogni giocatore prende tiri in base alla media della regular season
					 * impostato attualmente al tra il 70% e 100% in modo randomico
					 */
					
					
						Integer attempt3 = (int) ((((rand.nextInt(this.PROB_TENTATIVO_RANDOM) - rand.nextInt(this.PROB_TENTATIVO_FISSA)) * homeP.getThreePointsAttempts()) / 100));
						for(int i = 0; i < attempt3; i++) {
							
							if(homeP.getTeam().equals(home.getName())) {
								
								this.eventList.add(new Evento(null, TipoEvento.THREE_POINTS_ATTEMPT,home, homeP));
								
							}else {
								
								this.eventList.add(new Evento(null, TipoEvento.THREE_POINTS_ATTEMPT,away, homeP));
								
							}
							
							for(PlayerAVGStats pas : match.getPlayerStats()) {//aggiornamento tentativi
								if(pas.getName().equals(homeP.getName())) {
									pas.setThreeAttempts(pas.getThreeAttempts() + 1);
								}
							}
							
						}
						
						Integer attempt2 = (int) ((((rand.nextInt(this.PROB_TENTATIVO_RANDOM) - rand.nextInt(this.PROB_TENTATIVO_FISSA)) * homeP.getFieldGoalAttempts()) / 100));
						for(int i = 0; i < attempt2; i++) {
							
							if(homeP.getTeam().equals(home.getName())) {
								
								this.eventList.add(new Evento(null, TipoEvento.FIELD_GOAL_ATTEMPT, home, homeP));
								
							}else {
								
								this.eventList.add(new Evento(null, TipoEvento.FIELD_GOAL_ATTEMPT, away, homeP));
								
							}
							
							for(PlayerAVGStats pas : match.getPlayerStats()) {//aggiornamento tentativi
								if(pas.getName().equals(homeP.getName())) {
									pas.setFgAttempts(pas.getFgAttempts() + 1);
								}
							}
							
						}
						
						Integer freeT = (int) ((((rand.nextInt(this.PROB_TENTATIVO_RANDOM) - rand.nextInt(this.PROB_TENTATIVO_FISSA)) * homeP.getFreeThrowsAttempts()) / 100));
						for(int i = 0; i < freeT; i++) {
							if(homeP.getTeam().equals(home.getName())) {
								
								this.eventList.add(new Evento(null, TipoEvento.FREE_THROW_ATTEMPT, home, homeP));
								
							}else {
								
								this.eventList.add(new Evento(null, TipoEvento.FREE_THROW_ATTEMPT, away, homeP));
								
							}
							
							for(PlayerAVGStats pas : match.getPlayerStats()) {//aggiornamento tentativi
								if(pas.getName().equals(homeP.getName())) {
									pas.setFreeAttempts(pas.getFreeAttempts() + 1);
								}
							}
							
						}
					
				}
				
					
				
			}
				
			
			/*
			 * Le istruzioni seguenti randomizzano la coda eventi:
			 * gli eventi si recuperano dalla lista, gli si assegna un tempo secondo i parametri e si aggiunge alla coda,
			 * fino a quando non si arriva a 48 minuti di partita
			 * 
			 */
			
			/*
			 * Modellazione infortunio
			 */
			
			for(Player p : this.playerRandom) {
				if(rand.nextDouble() < this.PROB_INJURED) {
					if(p.getTeam().equals(home.getName()))
						this.eventList.add(new Evento(null, TipoEvento.INJURED, home, p));
					else
						this.eventList.add(new Evento(null, TipoEvento.INJURED, away, p));
				}
			}
			
			Collections.shuffle(eventList);
			
			
			
			for(Evento ev : this.eventList) {
				if(matchTime <= matchDurations) {
					matchTime = matchTime + ((rand.nextInt(this.TEMPO_RANDOM_AZIONE)) + this.TEMPO_COSTANTE_AZIONE);
					ev.setTime(matchTime);
					this.queue.add(ev);
					
				}
			}
			//System.out.println(queue);
		
	}
	
	public void run() {
		
		while(!queue.isEmpty()) {
			Evento ev = queue.poll();
			Team team = ev.getTeam();
			Player toConsider = ev.getPlayer();
			Boolean injFlag = false;
			
			for(Player p : this.playerRandom) {
				if(p.equals(toConsider)) {
					if(p.getInjured()) {
						injFlag = true;
						//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					}
				}
			}
				/*
				 * In base alle medie di realizzazione si valuta il successo del tentativo
				 */
			if(injFlag.equals(false)) {
				
				switch (ev.getType()) {
				
				case FIELD_GOAL_ATTEMPT:
					//System.out.println(toConsider.getName()+ " da 2");
					if(ev.getPlayer().getFieldGoalsPercentage() > rand.nextDouble()) {
						//aggiorno lo score player globale
						String name = "";
						for(PlayerAVGStats pas : match.getPlayerStats()) {
							if(pas.getName().equals(ev.getPlayer().getName())) {
								pas.setPoint(pas.getPoint() + 2);//update punti
								pas.setFgDone(pas.getFgDone() + 1);//update successi
								name = pas.getName();
							}
							if(!name.equals("") && !pas.getName().equals(name)) {//MODELLAZIONE ASSIST
								//seleziono un giocatore dello stesso team
								if(team.equals(match.getHome())) {
									Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
									if(!team.getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas2 : match.getPlayerStats()) {
											if(pas2.getName().equals(random.getName()) && pas2.getAssist() < (random.getAssists() * (1 + rand.nextDouble()))) {
												if(this.PROB_RANDOM_ASSIST > rand.nextDouble())
													pas2.setAssist(pas2.getAssist() + 1);
											}
										}
									}								
									
								}else {
									Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
									if(!team.getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas2 : match.getPlayerStats()) {
											if(pas2.getName().equals(random.getName()) && pas2.getAssist() < (random.getAssists() * (1 + rand.nextDouble()))) {
												if(this.PROB_RANDOM_ASSIST > rand.nextDouble())
													pas2.setAssist(pas2.getAssist() + 1);
											}
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
							if(rand.nextDouble() < this.PROB_RIMBALZO) {
								Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));//prendo un giocatore a caso dal team avversario
								if(!match.getAway().getInjured().containsKey(random.getName())) {
									for(PlayerAVGStats pas : match.getPlayerStats()) {
										if(pas.getName().equals(random.getName())) {
											pas.setRebounds(pas.getRebounds() + 1);	
										}
									}
								}
							}else if(rand.nextDouble() <= this.PROB_STOPPATA) {//stoppata 
								Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
								if(!match.getAway().getInjured().containsKey(random.getName())) {
									for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
										if(pas.getName().equals(random.getName()) && pas.getBlock() < (random.getBlocks() + this.PROB_PLUS_RANDOM_STOPPATA * rand.nextDouble())) {
											pas.setBlock(pas.getBlock() + 1);
										}
									}
								}
							}						
						}else {													
								if(rand.nextDouble() < this.PROB_RIMBALZO) {//rimbalzo al 30%
									Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
									if(!match.getHome().getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
											if(pas.getName().equals(random.getName())) {
												pas.setRebounds(pas.getRebounds() + 1);	//do uno scarto fino al 10% della edia rimbalzi
											}
										}
									}
								}else if(rand.nextDouble() < this.PROB_STOPPATA) {//stoppata al 10%
									Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
									if(!match.getHome().getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
											if(!random.getInjured() && pas.getName().equals(random.getName()) && pas.getBlock() < (random.getBlocks() + this.PROB_PLUS_RANDOM_STOPPATA * rand.nextDouble())) {
												pas.setBlock(pas.getBlock() + 1);
											}
										}
									}
								}							
							
						}
						
					}
					break;
					
				case THREE_POINTS_ATTEMPT:
					//System.out.println(toConsider.getName()+ " da 3");
					if(ev.getPlayer().getThreePointsPercentage() > rand.nextDouble()) {
						String name = "";
						//aggiorno lo score punti player globale
						for(PlayerAVGStats pas : match.getPlayerStats()) {
							if(pas.getName().equals(ev.getPlayer().getName())) {
								pas.setPoint(pas.getPoint() + 3);
								pas.setThreeDone(pas.getThreeDone() + 1);//update successi
								name = pas.getName();
							}
							if(!name.equals("") && !pas.getName().equals(name)) {//MODELLAZIONE ASSIST
								//seleziono un giocatore dello stesso team
								if(team.equals(match.getHome())) {
									Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
									if(!team.getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas2 : match.getPlayerStats()) {
											if(pas2.getName().equals(random.getName()) && pas2.getAssist() < (random.getAssists() * (1 + rand.nextDouble()))) {
												if(this.PROB_RANDOM_ASSIST > rand.nextDouble())
													pas2.setAssist(pas2.getAssist() + 1);
											}
										}
									}
								}else {
									Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
									if(!team.getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas2 : match.getPlayerStats()) {
											if(pas2.getName().equals(random.getName()) && pas2.getAssist() < (random.getAssists() * (1 + rand.nextDouble()))) {
												if(this.PROB_RANDOM_ASSIST > rand.nextDouble())	
													pas2.setAssist(pas2.getAssist() + 1);
											}
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
								if(!match.getAway().getInjured().containsKey(random.getName())) {
									for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
										if(pas.getName().equals(random.getName()) /*&& pas.getRebounds() < (random.getRebounds() + this.PROB_PLUS_RANDOM_RIMBALZO * rand.nextDouble())*/) {
											pas.setRebounds(pas.getRebounds() + 1);	
										}
									}
								}
							}else if(rand.nextDouble() < this.PROB_STOPPATA) {//stoppata 
								Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
								if(!match.getAway().getInjured().containsKey(random.getName())) {
									for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
										if(pas.getName().equals(random.getName()) && pas.getBlock() < (random.getBlocks() + this.PROB_PLUS_RANDOM_STOPPATA * rand.nextDouble())) {
											pas.setBlock(pas.getBlock() + 1);
										}
									}
								}
							}						
						}else {													
								if(rand.nextDouble() < this.PROB_RIMBALZO) {//rimbalzo al 30%
									Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
									if(!match.getHome().getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
											if(pas.getName().equals(random.getName()) /*&& pas.getRebounds() < (random.getRebounds() + this.PROB_PLUS_RANDOM_RIMBALZO * rand.nextDouble())*/) {
												pas.setRebounds(pas.getRebounds() + 1);	
											}
										}
									}
								}else if(rand.nextDouble() < this.PROB_STOPPATA) {//stoppata al 10%
									Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
									if(!match.getHome().getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
											if(!random.getInjured() && pas.getName().equals(random.getName()) && pas.getBlock() < (random.getBlocks() + this.PROB_PLUS_RANDOM_STOPPATA * rand.nextDouble())) {
												pas.setBlock(pas.getBlock() + 1);
											}
										}
									}
								}							
							
						}
						
					}
					break;
					
				case FREE_THROW_ATTEMPT:
					//System.out.println(toConsider.getName()+ " da 1");
					if(ev.getPlayer().getFreeThrowsPercentage() > rand.nextDouble()) {
						//aggiorno lo score player globale
						for(PlayerAVGStats pas : match.getPlayerStats()) {
							if(pas.getName().equals(ev.getPlayer().getName())) {
								pas.setPoint(pas.getPoint() + 1);
								pas.setFreeDone(pas.getFreeDone() + 1);//update successi
							}
						}
						
						if(team.getName().equals(this.match.getHome().getName())) {
							this.homePoints ++;
						}else {
							this.awayPoints ++;
						}
					}else {
						if(team.equals(this.match.getHome())) {
							if(rand.nextDouble() < this.PROB_RIMBALZO) {//rimbalzo al 50%
								Player random = aPlayers.get(rand.nextInt(this.aPlayers.size()));
								if(!match.getAway().getInjured().containsKey(random.getName())) {
									for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
										if(pas.getName().equals(random.getName()) /*&& pas.getRebounds() < (random.getRebounds() + this.PROB_PLUS_RANDOM_RIMBALZO * rand.nextDouble())*/) {
											pas.setRebounds(pas.getRebounds() + 1);	
										}
									}
								}
							}
												
						}else {													
								if(rand.nextDouble() < this.PROB_RIMBALZO) {//rimbalzo al 30%
									Player random = hPlayers.get(rand.nextInt(this.hPlayers.size()));
									if(!match.getHome().getInjured().containsKey(random.getName())) {
										for(PlayerAVGStats pas : match.getPlayerStats()) {//prendo un giocatore a caso dal team avversario
											if(pas.getName().equals(random.getName()) /*&& pas.getRebounds() < (random.getRebounds() + this.PROB_PLUS_RANDOM_RIMBALZO * rand.nextDouble())*/) {
												pas.setRebounds(pas.getRebounds() + 1);	
											}
										}
									}
								}						
							
						}
					}
					break;
					
				case INJURED:
					/*
					 * se infortunato rimuovo il giocatore dal team per un numero random di partite
					 */
					for(Player p : this.playerRandom) {
						if(toConsider.equals(p)) {
							p.setInjured(true);
							Map<String, Integer> teamInjured = team.getInjured();
							Integer time =  rand.nextInt(this.MAX_INJURED_TIME) + 1;
							teamInjured.put(toConsider.getName(), time);//al max 3 giornate	, lo aggiungo al team
							this.match.getInjured().add(toConsider);//aggiungo infornutato al match
							//System.out.println("Giocatore " + toConsider.getName() + "INFORTUNATO per "+time);
						}
					}
					
					
					
					break;
				}
			}
		}
		
		this.match.setAwayPoints(awayPoints);
		this.match.setHomePoints(homePoints);
		
		if(homePoints > awayPoints) {
			this.match.setWinner(this.match.getHome());
		}else {
			this.match.setWinner(this.match.getAway());
		}
		
		for(PlayerAVGStats pas : match.getPlayerStats()) {
			pas.setFgAvg(pas.getFgDone()+"/"+pas.getFgAttempts());
			pas.setThreeAvg(pas.getThreeDone()+"/"+pas.getThreeAttempts());
			pas.setFreeAvg(pas.getFreeDone()+"/"+pas.getFreeAttempts());
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
