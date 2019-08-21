package it.polito.tdp.simulatoreNBA.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.simulatoreNBA.model.Model;
import it.polito.tdp.simulatoreNBA.model.Player;
import it.polito.tdp.simulatoreNBA.model.PlayerAVGStats;
import it.polito.tdp.simulatoreNBA.model.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FinalsController {
	
	Model model;
	Stage stage;
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWestWinner;
    
    @FXML
    private TableView<PlayerAVGStats> tableWest;

    @FXML
    private TableColumn<PlayerAVGStats, String> columnPlayerWest;

    @FXML
    private TableColumn<PlayerAVGStats, Double> columnPointsWest;

    @FXML
    private TableColumn<PlayerAVGStats, Double> columnAssistsWest;

    @FXML
    private TableColumn<PlayerAVGStats, Double> columnStopWest;

    @FXML
    private TableColumn<PlayerAVGStats, Double> columnStealsWest;

    @FXML
    private TextField txtEastWinner;
    
    @FXML
    private TableView<PlayerAVGStats> tableEast;

    @FXML
    private TableColumn<PlayerAVGStats, String> columnPlayerEast;

    @FXML
    private TableColumn<PlayerAVGStats, Double> columnPointsEast;

    @FXML
    private TableColumn<PlayerAVGStats, Double> columnAssistsEast;

    @FXML
    private TableColumn<PlayerAVGStats, Double> columnStopEast;

    @FXML
    private TableColumn<PlayerAVGStats, Double> columnStealsEast;

    @FXML
    private TextField txtChamp;

    @FXML
    private TextArea txtAreaResults;

    @FXML
    void doSimulaFinals(ActionEvent event) {
    	
    	
    	txtAreaResults.clear();
    	txtChamp.clear();
    	
    	Team champ = model.SimulationWinner(model.getEastWinner(), model.getWestWinner());
    	
    	txtChamp.appendText(champ.getName());
    	
    	List<PlayerAVGStats> westStats = new ArrayList<PlayerAVGStats>();
		
		for(Player p : model.getWestWinner().getPlayers()) {
			westStats.add(model.avgByPlayer(p));
		}
		
		Collections.sort(westStats); //prima chi ha segnato più punti
		
		ObservableList<PlayerAVGStats> values = FXCollections.observableArrayList(westStats);
		tableWest.setItems(values);
		
		List<PlayerAVGStats> eastStats = new ArrayList<PlayerAVGStats>();
		
		for(Player p : model.getEastWinner().getPlayers()) {
			eastStats.add(model.avgByPlayer(p));
		}
		
		Collections.sort(eastStats);//prima chi ha segnato più punti
		
		ObservableList<PlayerAVGStats> valuesE = FXCollections.observableArrayList(eastStats);
		tableEast.setItems(valuesE);

    	
    	for(String s : model.getResult()) {
    		txtAreaResults.appendText(s + "\n");
    	}
    	

    }

    @FXML
    void initialize() {
        assert txtWestWinner != null : "fx:id=\"txtWestWinner\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert tableWest != null : "fx:id=\"tableWest\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnPlayerWest != null : "fx:id=\"columnPlayerWest\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnPointsWest != null : "fx:id=\"columnPointsWest\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnAssistsWest != null : "fx:id=\"columnAssistsWest\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnStopWest != null : "fx:id=\"columnStopWest\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnStealsWest != null : "fx:id=\"columnStealsWest\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert txtEastWinner != null : "fx:id=\"txtEastWinner\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert tableEast != null : "fx:id=\"tableEast\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnPlayerEast != null : "fx:id=\"columnPlayerEast\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnPointsEast != null : "fx:id=\"columnPointsEast\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnAssistsEast != null : "fx:id=\"columnAssistsEast\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnStopEast != null : "fx:id=\"columnStopEast\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert columnStealsEast != null : "fx:id=\"columnStealsEast\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert txtChamp != null : "fx:id=\"txtChamp\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        assert txtAreaResults != null : "fx:id=\"txtAreaResults\" was not injected: check your FXML file 'GoToFinals.fxml'.";
        
        columnPlayerWest.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        columnPointsWest.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        columnAssistsWest.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        columnStopWest.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        columnStealsWest.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        
        columnPlayerEast.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        columnPointsEast.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        columnAssistsEast.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        columnStopEast.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds"));
        columnStealsEast.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 

    }
    
    public void setModel(Model model, Stage stage) {
		this.model = model;
		this.stage = stage;
		txtEastWinner.appendText(model.getEastWinner().getName());
		txtWestWinner.appendText(model.getWestWinner().getName());
	}
}
