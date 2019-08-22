package it.polito.tdp.simulatoreNBA.model;

public class TestSimulatore {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		Simulatore sim = new Simulatore();
		sim.init(model.getWestTeams().get(4), model.getWestTeams().get(7));
		
		
		//System.out.println(sim.getQueue() + "Numero azioni: " + sim.getQueue().size());
		sim.run();
		System.out.println("\n\n"+sim.getMatch());
		for(PlayerAVGStats p : sim.getMatch().getPlayerStats()) {
			System.out.println(p);
		}
		

	}

}
