package it.polito.tdp.simulatoreNBA.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import it.polito.tdp.simulatoreNBA.model.Team;
import it.polito.tdp.simulatoreNBA.model.Model;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

public class NBAController {
	
	private Model model;
	private Stage stage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    

    @FXML
    private ComboBox<Team> cmbBoxWest1;

    @FXML
    private ComboBox<Team> cmbBoxWest8;

    @FXML
    private ComboBox<Team> cmbBoxWest4;

    @FXML
    private ComboBox<Team> cmbBoxWest5;

    @FXML
    private ComboBox<Team> cmbBoxWest3;

    @FXML
    private ComboBox<Team> cmbBoxWest6;

    @FXML
    private ComboBox<Team> cmbBoxWest2;

    @FXML
    private ComboBox<Team> cmbBoxWest7;

    @FXML
    private ComboBox<Team> cmbBoxEast1;

    @FXML
    private ComboBox<Team> cmbBoxEast8;

    @FXML
    private ComboBox<Team> cmbBoxEast4;

    @FXML
    private ComboBox<Team> cmbBoxEast5;

    @FXML
    private ComboBox<Team> cmbBoxEast3;

    @FXML
    private ComboBox<Team> cmbBoxEast6;

    @FXML
    private ComboBox<Team> cmbBoxEast2;

    @FXML
    private ComboBox<Team> cmbBoxEast7;
    
    @FXML
    private TextField txtResult1West;

    @FXML
    private TextField txtResult8West;

    @FXML
    private TextField txtResult4West;

    @FXML
    private TextField txtResult5West;

    @FXML
    private TextField txtResult3West;

    @FXML
    private TextField txtResult6We;

    @FXML
    private TextField txtResult2West;

    @FXML
    private TextField txtResult7West;
    
    @FXML
    private TextField txt1vs8West;

    @FXML
    private TextField txt4vs5West;

    @FXML
    private TextField txt3vs6West;

    @FXML
    private TextField txt2vs7West;
    
    @FXML
    private TextField txtResult18West;

    @FXML
    private TextField txtResult45West;

    @FXML
    private TextField txtResult36West;

    @FXML
    private TextField txtResult27West;

    @FXML
    private TextField txtFinalist1West;

    @FXML
    private TextField txtFinalist2West;
    
    @FXML
    private TextField txtResult1FinalWest;

    @FXML
    private TextField txtResult2FinalWest;

    @FXML
    private TextField txtResult1FinalEst;

    @FXML
    private TextField txtResult2FinalEst;

    @FXML
    private TextField txtFinalist1East;

    @FXML
    private TextField txtFinalist2East;
    
    @FXML
    private TextField txtResult18Est;

    @FXML
    private TextField txtResult45Est;

    @FXML
    private TextField txtResult36Est;

    @FXML
    private TextField txtResult27Est;

    @FXML
    private TextField txt1vs8East;

    @FXML
    private TextField txt4vs5East;

    @FXML
    private TextField txt3vs6East;

    @FXML
    private TextField txt2vs7East;
    
    @FXML
    private TextField txtResult1Est;

    @FXML
    private TextField txtResult8Est;

    @FXML
    private TextField txtResult4Est;

    @FXML
    private TextField txtResult5Est;

    @FXML
    private TextField txtResult3Est;

    @FXML
    private TextField txtResult6Est;

    @FXML
    private TextField txtResult2Est;

    @FXML
    private TextField txtResult7Est;
    
    @FXML
    private TextField txtWestWinner;

    @FXML
    private TextField txtEastWinner;
    
    @FXML
    private CheckBox checkWset;
    
    @FXML
    private CheckBox checkEast;
    
    @FXML
    private TextArea txtLog;
    
    @FXML
    private Button btnToFinals;
    
    @FXML
    private Button btnSimulaOvest;
    
    @FXML
    private Button btnSimulaEst;

    
    @FXML
    void doSimulaEst(ActionEvent event) {
    	
    	txtLog.clear();
    	
    	Team team1 = cmbBoxEast1.getValue();
    	Team team2 = cmbBoxEast2.getValue();
    	Team team3 = cmbBoxEast3.getValue();
    	Team team4 = cmbBoxEast4.getValue();
    	Team team5 = cmbBoxEast5.getValue();
    	Team team6 = cmbBoxEast6.getValue();
    	Team team7 = cmbBoxEast7.getValue();
    	Team team8 = cmbBoxEast8.getValue();
    	
    	List<Team> teams = new ArrayList<Team>();
    	teams.add(team1);
    	teams.add(team2);
    	teams.add(team3);
    	teams.add(team4);
    	teams.add(team5);
    	teams.add(team6);
    	teams.add(team7);
    	teams.add(team8);
    	
    	/*
    	 * Controllo input -> tutte le squadre selezionate
    	 */
    	for(Team team : teams) {
    		if(team == null) {
    			txtLog.appendText("ERRORE SIMULAZIONE EAST: Selezionare tutti i teams partecipanti ai playoff per procedere.");
    			return;
    		}
    	}
    	
    	/*
    	 * Controllo input -> squadre tutte differenti
    	 */
    	for(Team t1 : teams) {   
    		int count = 0;
    		for(Team t2 : teams) {
    			if(t1.equals(t2)) {
    				count ++;
    				if(count > 1) {
    					txtLog.appendText("ERRORE SIMULAZIONE EAST: Assicurarsi di aver selezionato ogni squadra una sola volta.");
        				return;
    				}
    			}
    		}
    		
    	}
    	
    	/*
    	 * Simulazione quarti
    	 */
    	
    	Team winner1vs8 = model.SimulationWinner(team1, team8);
    	Team winner4vs5 = model.SimulationWinner(team4, team5);
    	Team winner3vs6 = model.SimulationWinner(team3, team6);
    	Team winner2vs7 = model.SimulationWinner(team2, team7);
    	
    	/*
    	 * Simulazione semifinale
    	 */
    	
    	Team finalist1East = model.SimulationWinner(winner1vs8, winner4vs5);
    	Team finalist2East = model.SimulationWinner(winner3vs6, winner2vs7);
    	
    	/*
    	 * Simulazione finale
    	 */
    	
    	Team eastWinner = model.SimulationWinner(finalist1East, finalist2East);
    	model.saveEastWinner(eastWinner);//salvataggio in Model
    	
    	if(checkEast.isSelected()) {
    		//Simulazione veloce
    		txtLog.clear();
    
    		//OUTPUT QUARTI
        	txt1vs8East.appendText(winner1vs8.getAbbreviation());
        	txt2vs7East.appendText(winner2vs7.getAbbreviation());
          	txt3vs6East.appendText(winner3vs6.getAbbreviation());
        	txt4vs5East.appendText(winner4vs5.getAbbreviation());
        	
        	txtResult1Est.appendText(model.getSeriesMapEast().get(1).getWinHome().toString());
        	txtResult8Est.appendText(model.getSeriesMapEast().get(1).getWinAway().toString());
        	
        	txtResult4Est.appendText(model.getSeriesMapEast().get(2).getWinHome().toString());
        	txtResult5Est.appendText(model.getSeriesMapEast().get(2).getWinAway().toString());
        	
        	txtResult3Est.appendText(model.getSeriesMapEast().get(3).getWinHome().toString());        	
        	txtResult6Est.appendText(model.getSeriesMapEast().get(3).getWinAway().toString());
        	
        	txtResult2Est.appendText(model.getSeriesMapEast().get(4).getWinHome().toString());
        	txtResult7Est.appendText(model.getSeriesMapEast().get(4).getWinAway().toString());
        	
        	//OUTPUT SEMIFINALI
        	txtFinalist1East.appendText(finalist1East.getAbbreviation());
         	txtFinalist2East.appendText(finalist2East.getAbbreviation());
        	
        	txtResult18Est.appendText(model.getSeriesMapEast().get(5).getWinHome().toString());
        	txtResult45Est.appendText(model.getSeriesMapEast().get(5).getWinAway().toString());
        	        	
        	txtResult36Est.appendText(model.getSeriesMapEast().get(6).getWinHome().toString());
        	txtResult27Est.appendText(model.getSeriesMapEast().get(6).getWinAway().toString());
        	        	
        	//OUTPUT FINALE
        	txtEastWinner.appendText(eastWinner.getAbbreviation());
        	
        	txtResult1FinalEst.appendText(model.getSeriesMapEast().get(7).getWinHome().toString());
        	txtResult2FinalEst.appendText(model.getSeriesMapEast().get(7).getWinAway().toString());
        	        	
        	
        	txtLog.appendText("Simulazione veloce EST avvenuta con successo!\n "
        			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
        	
        	this.btnSimulaEst.setDisable(true);
        	this.checkEast.setDisable(true);
        	if(this.btnSimulaOvest.isDisabled()) {
        		this.btnToFinals.setDisable(false);
    		
    	}else {//Mostro un risultato alla volta
    		
    		txtLog.clear();
    		
    		this.checkEast.setDisable(true);
    		
    		if(txt1vs8East.getText().equals("")) {
    			txt1vs8East.appendText(winner1vs8.getAbbreviation());
    			txtResult1Est.appendText(model.getSeriesMapEast().get(1).getWinHome().toString());
            	txtResult8Est.appendText(model.getSeriesMapEast().get(1).getWinAway().toString());
            	txtLog.appendText("Simulazione 1 vs 8 EST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txt4vs5East.getText().equals("")) {
    			txt4vs5East.appendText(winner3vs6.getAbbreviation());
    			txtResult4Est.appendText(model.getSeriesMapEast().get(2).getWinHome().toString());        	
            	txtResult5Est.appendText(model.getSeriesMapEast().get(2).getWinAway().toString());
            	txtLog.appendText("Simulazione 4 vs 5 EST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txt3vs6East.getText().equals("")) {
    			txt3vs6East.appendText(winner3vs6.getAbbreviation());
    			txtResult3Est.appendText(model.getSeriesMapEast().get(3).getWinHome().toString());        	
            	txtResult6Est.appendText(model.getSeriesMapEast().get(3).getWinAway().toString());
            	txtLog.appendText("Simulazione 3 vs 6 avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txt2vs7East.getText().equals("")) {
    			txt2vs7East.appendText(winner2vs7.getAbbreviation());
    			txtResult2Est.appendText(model.getSeriesMapEast().get(4).getWinHome().toString());
            	txtResult7Est.appendText(model.getSeriesMapEast().get(4).getWinAway().toString());
            	txtLog.appendText("Simulazione 2 vs 7 avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txtFinalist1East.getText().equals("")) {
    			txtFinalist1East.appendText(finalist1East.getAbbreviation());
    			txtResult18Est.appendText(model.getSeriesMapEast().get(5).getWinHome().toString());
            	txtResult45Est.appendText(model.getSeriesMapEast().get(5).getWinAway().toString());
            	txtLog.appendText("Simulazione Semifinale 1 EST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txtFinalist2East.getText().equals("")) {
    			txtFinalist2East.appendText(finalist2East.getAbbreviation());
    			txtResult36Est.appendText(model.getSeriesMapEast().get(6).getWinHome().toString());
            	txtResult27Est.appendText(model.getSeriesMapEast().get(6).getWinAway().toString());
            	txtLog.appendText("Simulazione Semifinale 2 EST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txtEastWinner.getText().equals("")) {
    			txtEastWinner.appendText(eastWinner.getAbbreviation());            	
            	txtResult1FinalEst.appendText(model.getSeriesMapEast().get(7).getWinHome().toString());
            	txtResult2FinalEst.appendText(model.getSeriesMapEast().get(7).getWinAway().toString());
            	txtLog.appendText("Simulazione Finale EST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
            	
            	
            	this.btnSimulaEst.setDisable(true);
            	this.checkEast.setDisable(true);
            	if(this.btnSimulaOvest.isDisabled())
            		this.btnToFinals.setDisable(false);
    		}
    		
    		
    	}
        	
    	}

    }

    @FXML
    void doSimulaOvest(ActionEvent event) {
    	
    	txtLog.clear();
    	
    	Team team1 = cmbBoxWest1.getValue();
    	Team team2 = cmbBoxWest2.getValue();
    	Team team3 = cmbBoxWest3.getValue();
    	Team team4 = cmbBoxWest4.getValue();
    	Team team5 = cmbBoxWest5.getValue();
    	Team team6 = cmbBoxWest6.getValue();
    	Team team7 = cmbBoxWest7.getValue();
    	Team team8 = cmbBoxWest8.getValue();
    	
    	List<Team> teams = new ArrayList<Team>();
    	teams.add(team1);
    	teams.add(team2);
    	teams.add(team3);
    	teams.add(team4);
    	teams.add(team5);
    	teams.add(team6);
    	teams.add(team7);
    	teams.add(team8);
    	
    	/*
    	 * Controllo input -> tutte le squadre selezionate
    	 */
    	for(Team team : teams) {
    		if(team == null) {
    			txtLog.appendText("ERRORE SIMULAZIONE WEST: Selezionare tutti i teams partecipanti ai playoff per procedere.");
    			return;
    		}
    	}
    	
    	/*
    	 * Controllo input -> squadre tutte differenti
    	 */
    	for(Team t1 : teams) {   
    		int count = 0;
    		for(Team t2 : teams) {
    			if(t1.equals(t2)) {
    				count ++;
    				if(count > 1) {
    					txtLog.appendText("ERRORE SIMULAZIONE WEST: Assicurarsi di aver selezionato ogni squadra una sola volta.");
        				return;
    				}
    			}
    		}
    		
    	}
    	/*
    	 * Simulazione quarti
    	 */
    	
    	Team winner1vs8 = model.SimulationWinner(team1, team8);
    	Team winner4vs5 = model.SimulationWinner(team4, team5);
    	Team winner3vs6 = model.SimulationWinner(team3, team6);
    	Team winner2vs7 = model.SimulationWinner(team2, team7);
    	
    	
    	
    	/*
    	 * Simulazione semifinale
    	 */
    	        	
    	Team finalist1West = model.SimulationWinner(winner1vs8, winner4vs5);
    	Team finalist2West = model.SimulationWinner(winner3vs6, winner2vs7);
    	
    	/*
    	 * Simulazione finale
    	 */
    	Team westWinner = model.SimulationWinner(finalist1West, finalist2West);
    	model.saveWestWinner(westWinner);//salvataggio in Model
    	
    	if(checkWset.isSelected()) {
    		//Simulazione veloce
    		txtLog.clear();
        	
        	//OUTPUT QUARTI
        	txt1vs8West.appendText(winner1vs8.getAbbreviation());     	
        	txt2vs7West.appendText(winner2vs7.getAbbreviation());
           	txt3vs6West.appendText(winner3vs6.getAbbreviation());
           	txt4vs5West.appendText(winner4vs5.getAbbreviation());
        	
        	txtResult1West.appendText(model.getSeriesMapWest().get(1).getWinHome().toString());
        	txtResult8West.appendText(model.getSeriesMapWest().get(1).getWinAway().toString());
        	        	
        	txtResult4West.appendText(model.getSeriesMapWest().get(2).getWinHome().toString());
        	txtResult5West.appendText(model.getSeriesMapWest().get(2).getWinAway().toString());
        	        	
        	txtResult3West.appendText(model.getSeriesMapWest().get(3).getWinHome().toString());        	
        	txtResult6We.appendText(model.getSeriesMapWest().get(3).getWinAway().toString());
        	        	
        	txtResult2West.appendText(model.getSeriesMapWest().get(4).getWinHome().toString());
        	txtResult7West.appendText(model.getSeriesMapWest().get(4).getWinAway().toString());
        	        	
        	//OUTPUT SEMIFINALI
        	txtFinalist1West.appendText(finalist1West.getAbbreviation());
        	txtFinalist2West.appendText(finalist2West.getAbbreviation());
        	
        	txtResult18West.appendText(model.getSeriesMapWest().get(5).getWinHome().toString());
        	txtResult45West.appendText(model.getSeriesMapWest().get(5).getWinAway().toString());
        	        	
        	txtResult36West.appendText(model.getSeriesMapWest().get(6).getWinHome().toString());
        	txtResult27West.appendText(model.getSeriesMapWest().get(6).getWinAway().toString());
        	        	
        	//OUTPUT FINALE
        	txtWestWinner.appendText(westWinner.getAbbreviation());
        	
        	txtResult1FinalWest.appendText(model.getSeriesMapWest().get(7).getWinHome().toString());
        	txtResult2FinalWest.appendText(model.getSeriesMapWest().get(7).getWinAway().toString());   	
        
        	txtLog.appendText("Simulazione veloce OVEST avvenuta con successo!\n "
        			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
        	
        	this.btnSimulaOvest.setDisable(true);
        	this.checkWset.setDisable(true);
        	if(this.btnSimulaEst.isDisabled())
        		this.btnToFinals.setDisable(false);
        	
    		
    	}else {//modificare con west
    		
    		txtLog.clear();
    		
    		this.checkWset.setDisable(true);
    		
    		if(txt1vs8West.getText().equals("")) {
    			txt1vs8West.appendText(winner1vs8.getAbbreviation());
    			txtResult1West.appendText(model.getSeriesMapWest().get(1).getWinHome().toString());
            	txtResult8West.appendText(model.getSeriesMapWest().get(1).getWinAway().toString());
            	txtLog.appendText("Simulazione 1 vs 8 OVEST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txt4vs5West.getText().equals("")) {
    			txt4vs5West.appendText(winner3vs6.getAbbreviation());
    			txtResult4West.appendText(model.getSeriesMapWest().get(2).getWinHome().toString());        	
            	txtResult5West.appendText(model.getSeriesMapWest().get(2).getWinAway().toString());
            	txtLog.appendText("Simulazione 4 vs 5 OVEST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txt3vs6West.getText().equals("")) {
    			txt3vs6West.appendText(winner3vs6.getAbbreviation());
    			txtResult3West.appendText(model.getSeriesMapWest().get(3).getWinHome().toString());        	
            	txtResult6We.appendText(model.getSeriesMapWest().get(3).getWinAway().toString());
            	txtLog.appendText("Simulazione 3 vs 6 OVEST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txt2vs7West.getText().equals("")) {
    			txt2vs7West.appendText(winner2vs7.getAbbreviation());
    			txtResult2West.appendText(model.getSeriesMapWest().get(4).getWinHome().toString());
            	txtResult7West.appendText(model.getSeriesMapWest().get(4).getWinAway().toString());
            	txtLog.appendText("Simulazione 2 vs 7 OVEST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txtFinalist1West.getText().equals("")) {
    			txtFinalist1West.appendText(finalist1West.getAbbreviation());
    			txtResult18West.appendText(model.getSeriesMapWest().get(5).getWinHome().toString());
            	txtResult45West.appendText(model.getSeriesMapWest().get(5).getWinAway().toString());
            	txtLog.appendText("Simulazione Semifinale 1 OVEST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txtFinalist2West.getText().equals("")) {
    			txtFinalist2West.appendText(finalist2West.getAbbreviation());
    			txtResult36West.appendText(model.getSeriesMapWest().get(6).getWinHome().toString());
            	txtResult27West.appendText(model.getSeriesMapWest().get(6).getWinAway().toString());
            	txtLog.appendText("Simulazione Semifinale 2 OVEST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
    		}else if(txtWestWinner.getText().equals("")) {
    			txtWestWinner.appendText(westWinner.getAbbreviation());            	
            	txtResult1FinalWest.appendText(model.getSeriesMapWest().get(7).getWinHome().toString());
            	txtResult2FinalWest.appendText(model.getSeriesMapWest().get(7).getWinAway().toString());
            	txtLog.appendText("Simulazione Finale EST avvenuta con successo!\n "
            			+ "Premere sull'abbreviazione della squadra vincente per accedere alle statistiche delle partite.");
            	//qui disabilitare bottone
            	this.btnSimulaOvest.setDisable(true);
            	this.checkWset.setDisable(true);
            	if(this.btnSimulaEst.isDisabled())
            		this.btnToFinals.setDisable(false);
    		}
    		
    	}

    }
    


    @FXML
    void doReset(ActionEvent event) {
    	
    	txtLog.clear();
    	txt1vs8East.clear();
    	txt1vs8West.clear();
    	txt2vs7East.clear();
    	txt2vs7West.clear();
    	txt3vs6East.clear();
    	txt3vs6West.clear();
    	txt4vs5East.clear();
    	txt4vs5West.clear();
    	txtFinalist1East.clear();
    	txtFinalist2East.clear();
    	txtFinalist1West.clear();
    	txtFinalist2West.clear();
    	txtEastWinner.clear();
    	txtWestWinner.clear();
    	btnToFinals.setDisable(true);

    }

    @FXML
    void doGoToFinals(ActionEvent event) {
    	
    	try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("GoToFinals.fxml"));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			FinalsController controller = loader.getController();
			controller.setModel(model, stage);
			
			stage.setScene(scene);
			stage.setTitle("Simulazione Finali Assolute NBA");
			stage.setAlwaysOnTop(true);
			stage.show();
		
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    
    
    @FXML
    void doViewStats(MouseEvent event) {
    	
    	txtLog.clear();
    	
    	try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("StatsForGame.fxml"));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			
			TextField source = (TextField) event.getSource();
			
			if(source.getText().equals("")) {
				txtLog.appendText("Prima di accedere alle statistiche, è necessario simulare la partita.");
				return;
			}
			
			String idField = source.getId();
			
			StatsController controller = loader.getController();
			controller.setModel(model, stage, idField);
			
			stage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Statistiche Serie");
			//stage.setAlwaysOnTop(true);
			stage.show();
			
			
		
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() {
        assert cmbBoxWest1 != null : "fx:id=\"cmbBoxWest1\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxWest8 != null : "fx:id=\"cmbBoxWest8\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxWest4 != null : "fx:id=\"cmbBoxWest4\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxWest5 != null : "fx:id=\"cmbBoxWest5\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxWest3 != null : "fx:id=\"cmbBoxWest3\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxWest6 != null : "fx:id=\"cmbBoxWest6\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxWest2 != null : "fx:id=\"cmbBoxWest2\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxWest7 != null : "fx:id=\"cmbBoxWest7\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult1West != null : "fx:id=\"txtResult1West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult8West != null : "fx:id=\"txtResult8West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult4West != null : "fx:id=\"txtResult4West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult5West != null : "fx:id=\"txtResult5West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult3West != null : "fx:id=\"txtResult3West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult6We != null : "fx:id=\"txtResult6We\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult2West != null : "fx:id=\"txtResult2West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult7West != null : "fx:id=\"txtResult7West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt1vs8West != null : "fx:id=\"txt1vs8West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt4vs5West != null : "fx:id=\"txt4vs5West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt3vs6West != null : "fx:id=\"txt3vs6West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt2vs7West != null : "fx:id=\"txt2vs7West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult18West != null : "fx:id=\"txtResult18West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult45West != null : "fx:id=\"txtResult45West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult36West != null : "fx:id=\"txtResult36West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult27West != null : "fx:id=\"txtResult27West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtFinalist1West != null : "fx:id=\"txtFinalist1West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtFinalist2West != null : "fx:id=\"txtFinalist2West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult1FinalWest != null : "fx:id=\"txtResult1FinalWest\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult2FinalWest != null : "fx:id=\"txtResult2FinalWest\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult1FinalEst != null : "fx:id=\"txtResult1FinalEst\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult2FinalEst != null : "fx:id=\"txtResult2FinalEst\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtFinalist1East != null : "fx:id=\"txtFinalist1East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtFinalist2East != null : "fx:id=\"txtFinalist2East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult18Est != null : "fx:id=\"txtResult18Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult45Est != null : "fx:id=\"txtResult45Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult36Est != null : "fx:id=\"txtResult36Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult27Est != null : "fx:id=\"txtResult27Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt1vs8East != null : "fx:id=\"txt1vs8East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt4vs5East != null : "fx:id=\"txt4vs5East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt3vs6East != null : "fx:id=\"txt3vs6East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt2vs7East != null : "fx:id=\"txt2vs7East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult1Est != null : "fx:id=\"txtResult1Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult8Est != null : "fx:id=\"txtResult8Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult4Est != null : "fx:id=\"txtResult4Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult5Est != null : "fx:id=\"txtResult5Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult3Est != null : "fx:id=\"txtResult3Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult6Est != null : "fx:id=\"txtResult6Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult2Est != null : "fx:id=\"txtResult2Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtResult7Est != null : "fx:id=\"txtResult7Est\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast1 != null : "fx:id=\"cmbBoxEast1\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast8 != null : "fx:id=\"cmbBoxEast8\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast4 != null : "fx:id=\"cmbBoxEast4\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast5 != null : "fx:id=\"cmbBoxEast5\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast3 != null : "fx:id=\"cmbBoxEast3\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast6 != null : "fx:id=\"cmbBoxEast6\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast2 != null : "fx:id=\"cmbBoxEast2\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast7 != null : "fx:id=\"cmbBoxEast7\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtWestWinner != null : "fx:id=\"txtWestWinner\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtEastWinner != null : "fx:id=\"txtEastWinner\" was not injected: check your FXML file 'Table.fxml'.";
        assert checkWset != null : "fx:id=\"checkWset\" was not injected: check your FXML file 'Table.fxml'.";
        assert btnToFinals != null : "fx:id=\"btnToFinals\" was not injected: check your FXML file 'Table.fxml'.";
        assert checkEast != null : "fx:id=\"checkEast\" was not injected: check your FXML file 'Table.fxml'.";
        assert btnSimulaOvest != null : "fx:id=\"btnSimulaOvest\" was not injected: check your FXML file 'Table.fxml'.";
        assert btnSimulaEst != null : "fx:id=\"btnSimulaEst\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'Table.fxml'.";


    }
    
    public void setModel(Model model, Stage stage) {
    	this.model = model;
    	this.stage = stage;
    	this.cmbBoxEast1.getItems().addAll(model.getEastTeams());
    	this.cmbBoxEast2.getItems().addAll(model.getEastTeams());
    	this.cmbBoxEast3.getItems().addAll(model.getEastTeams());
    	this.cmbBoxEast4.getItems().addAll(model.getEastTeams());
    	this.cmbBoxEast5.getItems().addAll(model.getEastTeams());
    	this.cmbBoxEast6.getItems().addAll(model.getEastTeams());
    	this.cmbBoxEast7.getItems().addAll(model.getEastTeams());
    	this.cmbBoxEast8.getItems().addAll(model.getEastTeams());
    	this.cmbBoxWest1.getItems().addAll(model.getWestTeams());
    	this.cmbBoxWest2.getItems().addAll(model.getWestTeams());
    	this.cmbBoxWest3.getItems().addAll(model.getWestTeams());
    	this.cmbBoxWest4.getItems().addAll(model.getWestTeams());
    	this.cmbBoxWest5.getItems().addAll(model.getWestTeams());
    	this.cmbBoxWest6.getItems().addAll(model.getWestTeams());
    	this.cmbBoxWest7.getItems().addAll(model.getWestTeams());
    	this.cmbBoxWest8.getItems().addAll(model.getWestTeams());
    }
    
    
    
    
}
