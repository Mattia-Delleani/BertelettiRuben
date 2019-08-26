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
    private TextField txt1vs8West;

    @FXML
    private TextField txt4vs5West;

    @FXML
    private TextField txt3vs6West;

    @FXML
    private TextField txt2vs7West;

    @FXML
    private TextField txtFinalist1West;

    @FXML
    private TextField txtFinalist2West;

    @FXML
    private TextField txtFinalist1East;

    @FXML
    private TextField txtFinalist2East;

    @FXML
    private TextField txt1vs8East;

    @FXML
    private TextField txt4vs5East;

    @FXML
    private TextField txt3vs6East;

    @FXML
    private TextField txt2vs7East;
    
    @FXML
    private TextField txtWestWinner;

    @FXML
    private TextField txtEastWinner;
    
    @FXML
    private TextArea txtLog;
    
    @FXML
    private Button btn4West;

    @FXML
    private Button btn2West;

    @FXML
    private Button btnFinalsWest;

    @FXML
    private Button btnToFinals;

    @FXML
    private Button btnFinalsEast;

    @FXML
    private Button btn2East;

    @FXML
    private Button btn4East;
    
    @FXML
    private Button doViewStats;
    


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
    	btn4East.setDisable(false);
    	btn4West.setDisable(false);
    	btn2West.setDisable(true);
    	btn2East.setDisable(true);
    	btnFinalsEast.setDisable(true);
    	btnFinalsWest.setDisable(true);
    	btnToFinals.setDisable(true);

    }

    @FXML
    void doGoToFinals(ActionEvent event) {
    	
    	try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("GoToFinals.fxml"));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			
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
    void doSimula2East(ActionEvent event) {
    	
    	txtLog.clear();
    	Team winner1v8 = model.getWinnerTeamMap().get(txt1vs8East.getText());
    	Team winner2v7 = model.getWinnerTeamMap().get(txt2vs7East.getText());
    	Team winner3v6 = model.getWinnerTeamMap().get(txt3vs6East.getText());
    	Team winner4v5 = model.getWinnerTeamMap().get(txt4vs5East.getText());
    	
    	Team finalist1East = model.SimulationWinner(winner1v8, winner4v5);
    	txtFinalist1East.appendText(finalist1East.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	Team finalist2East = model.SimulationWinner(winner3v6, winner2v7);
    	txtFinalist2East.appendText(finalist2East.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	btn2East.setDisable(true);
    	btnFinalsEast.setDisable(false);
    	
    	
    	

    }

    @FXML
    void doSimula2West(ActionEvent event) {
    	
    	txtLog.clear();
    	Team winner1v8 = model.getWinnerTeamMap().get(txt1vs8West.getText());
    	Team winner2v7 = model.getWinnerTeamMap().get(txt2vs7West.getText());
    	Team winner3v6 = model.getWinnerTeamMap().get(txt3vs6West.getText());
    	Team winner4v5 = model.getWinnerTeamMap().get(txt4vs5West.getText());
    	
    	Team finalist1West = model.SimulationWinner(winner1v8, winner4v5);
    	txtFinalist1West.appendText(finalist1West.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	Team finalist2West = model.SimulationWinner(winner3v6, winner2v7);
    	txtFinalist2West.appendText(finalist2West.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	btn2West.setDisable(true);
    	btnFinalsWest.setDisable(false);

    }

    @FXML
    void doSimula4East(ActionEvent event) {
    	
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
    	
    	Team winner1vs8 = model.SimulationWinner(team1, team8);
    	txt1vs8East.appendText(winner1vs8.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	Team winner2vs7 = model.SimulationWinner(team2, team7);
    	txt2vs7East.appendText(winner2vs7.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	Team winner3vs6 = model.SimulationWinner(team3, team6);
    	txt3vs6East.appendText(winner3vs6.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	Team winner4vs5 = model.SimulationWinner(team4, team5);
    	txt4vs5East.appendText(winner4vs5.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	btn4East.setDisable(true);
    	btn2East.setDisable(false);

    }

    @FXML
    void doSimulaFinalsEast(ActionEvent event) {
    	
    	txtLog.clear();
    	Team finalist1East = model.getWinnerTeamMap().get(txtFinalist1East.getText());
    	Team finalist2East = model.getWinnerTeamMap().get(txtFinalist2East.getText());
    	
    	
    	Team eastWinner = model.SimulationWinner(finalist1East, finalist2East);
    	txtEastWinner.appendText(eastWinner.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	model.saveEastWinner(eastWinner);//salvataggio in Model
    	
    	btnFinalsEast.setDisable(true);
    	if(btnFinalsWest.isDisabled() && btn2West.isDisabled() && btn4West.isDisabled()) {
    		btnToFinals.setDisable(false);
    	}

    }

    @FXML
    void doSimulaFinalsWest(ActionEvent event) {
    	
    	txtLog.clear();
    	Team finalist1West = model.getWinnerTeamMap().get(txtFinalist1West.getText());
    	Team finalist2West = model.getWinnerTeamMap().get(txtFinalist2West.getText());
    	
    	
    	Team westWinner = model.SimulationWinner(finalist1West, finalist2West);
    	txtWestWinner.appendText(westWinner.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	model.saveWestWinner(westWinner);//salvataggio in Model
    	
    	btnFinalsWest.setDisable(true);
    	if(btnFinalsEast.isDisabled() && btn2East.isDisabled() && btn4East.isDisabled()) {
    		btnToFinals.setDisable(false);
    	}

    }

    @FXML
    void simula4West(ActionEvent event) {
    	
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
    	
    	
    	Team winner1vs8 = model.SimulationWinner(team1, team8);
    	txt1vs8West.appendText(winner1vs8.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	Team winner2vs7 = model.SimulationWinner(team2, team7);
    	txt2vs7West.appendText(winner2vs7.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	Team winner3vs6 = model.SimulationWinner(team3, team6);
    	txt3vs6West.appendText(winner3vs6.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	Team winner4vs5 = model.SimulationWinner(team4, team5);
    	txt4vs5West.appendText(winner4vs5.getAbbreviation());
    	/*for(String s : model.getResult()) {
    		txtLog.appendText(s + "\n");
    	}*/
    	
    	btn4West.setDisable(true);
    	btn2West.setDisable(false);
    	
    	
    	
    	

    }
    
    @FXML
    void doViewStats(ActionEvent event) {
    	
    	try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("StatsForGame.fxml"));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			
			StatsController controller = loader.getController();
			controller.setModel(model, stage);
			
			stage.setScene(scene);
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
        assert cmbBoxEast1 != null : "fx:id=\"cmbBoxEast1\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast8 != null : "fx:id=\"cmbBoxEast8\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast4 != null : "fx:id=\"cmbBoxEast4\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast5 != null : "fx:id=\"cmbBoxEast5\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast3 != null : "fx:id=\"cmbBoxEast3\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast6 != null : "fx:id=\"cmbBoxEast6\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast2 != null : "fx:id=\"cmbBoxEast2\" was not injected: check your FXML file 'Table.fxml'.";
        assert cmbBoxEast7 != null : "fx:id=\"cmbBoxEast7\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt1vs8West != null : "fx:id=\"txt1vs8West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt4vs5West != null : "fx:id=\"txt4vs5West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt3vs6West != null : "fx:id=\"txt3vs6West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt2vs7West != null : "fx:id=\"txt2vs7West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtFinalist1West != null : "fx:id=\"txtFinalist1West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtFinalist2West != null : "fx:id=\"txtFinalist2West\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtFinalist1East != null : "fx:id=\"txtFinalist1East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtFinalist2East != null : "fx:id=\"txtFinalist2East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt1vs8East != null : "fx:id=\"txt1vs8East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt4vs5East != null : "fx:id=\"txt4vs5East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt3vs6East != null : "fx:id=\"txt3vs6East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txt2vs7East != null : "fx:id=\"txt2vs7East\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtWestWinner != null : "fx:id=\"txtWestWinner\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtEastWinner != null : "fx:id=\"txtEastWinner\" was not injected: check your FXML file 'Table.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'Table.fxml'.";
        assert btn4West != null : "fx:id=\"btn4West\" was not injected: check your FXML file 'Table.fxml'.";
        assert btn2West != null : "fx:id=\"btn2West\" was not injected: check your FXML file 'Table.fxml'.";
        assert btnFinalsWest != null : "fx:id=\"btnFinalsWest\" was not injected: check your FXML file 'Table.fxml'.";
        assert btnToFinals != null : "fx:id=\"btnToFinals\" was not injected: check your FXML file 'Table.fxml'.";
        assert btnFinalsEast != null : "fx:id=\"btnFinalsEast\" was not injected: check your FXML file 'Table.fxml'.";
        assert btn2East != null : "fx:id=\"btn2East\" was not injected: check your FXML file 'Table.fxml'.";
        assert btn4East != null : "fx:id=\"btn4East\" was not injected: check your FXML file 'Table.fxml'.";
        assert doViewStats != null : "fx:id=\"doViewStats\" was not injected: check your FXML file 'Table.fxml'.";


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
