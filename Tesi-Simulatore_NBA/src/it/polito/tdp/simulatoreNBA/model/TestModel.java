package it.polito.tdp.simulatoreNBA.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		//model.SimulationWinner(model.getWestTeams().get(4), model.getWestTeams().get(7));
		
		model.saveEastWinner(model.getWestTeams().get(5));
		model.saveWestWinner( model.getEastTeams().get(6));
		
		model.SimulationWinner(model.getWestTeams().get(5), model.getEastTeams().get(6));
		
		List<PlayerAVGStats> prova = new ArrayList<PlayerAVGStats>();
		
		for(Player p : model.getEastWinner().getPlayers()) {
			prova.add(model.avgByPlayer(p));
			System.out.println(model.avgByPlayer(p));
		}
		
		List<PlayerAVGStats> prova2 = new ArrayList<PlayerAVGStats>();
		
		for(Player p : model.getWestWinner().getPlayers()) {
			prova2.add(model.avgByPlayer(p));
			System.out.println(model.avgByPlayer(p));
		}
		
		
		
		
		
		
	}

}
