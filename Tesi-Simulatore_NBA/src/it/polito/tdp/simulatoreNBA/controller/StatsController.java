package it.polito.tdp.simulatoreNBA.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.simulatoreNBA.model.Match;
import it.polito.tdp.simulatoreNBA.model.Model;
import it.polito.tdp.simulatoreNBA.model.PlayerAVGStats;
import it.polito.tdp.simulatoreNBA.model.Series;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StatsController {
	
	Model model;
	Stage stage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTeamHome;

    @FXML
    private TextField txtTeamAway;

    @FXML
    private TextArea txtAreaResult;

    @FXML
    private TableView<PlayerAVGStats> tableHome;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerH;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameH;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointH;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistH;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebH;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopH;

    @FXML
    private TableView<PlayerAVGStats> tableAway;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerA;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameA;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointA;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistA;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebA;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopA;

    @FXML
    void initialize() {
        assert txtTeamHome != null : "fx:id=\"txtTeamHome\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert txtTeamAway != null : "fx:id=\"txtTeamAway\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert txtAreaResult != null : "fx:id=\"txtAreaResult\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableHome != null : "fx:id=\"tableHome\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerH != null : "fx:id=\"colPlayerH\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameH != null : "fx:id=\"colGameH\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointH != null : "fx:id=\"colPointH\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistH != null : "fx:id=\"colAssistH\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebH != null : "fx:id=\"colRebH\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopH != null : "fx:id=\"colStopH\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableAway != null : "fx:id=\"tableAway\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerA != null : "fx:id=\"colPlayerA\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameA != null : "fx:id=\"colGameA\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointA != null : "fx:id=\"colPointA\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistA != null : "fx:id=\"colAssistA\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebA != null : "fx:id=\"colRebA\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopA != null : "fx:id=\"colStopA\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        
        colPlayerH.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameH.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointH.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistH.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebH.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopH.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        
        colPlayerA.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameA.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointA.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistA.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebA.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopA.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        
      
    }
    
    public void setModel(Model model, Stage stage, String sourceId) {
		this.model = model;
		this.stage = stage;
		
		Series toShow = null;
		
		//OUTPUT OVEST
		if(sourceId.equals("txt1vs8West")) {
			toShow = model.getSeriesMapWest().get(1);
			
		}else if(sourceId.equals("txt4vs5West")) {
			toShow = model.getSeriesMapWest().get(2);			
			
		}else if(sourceId.equals("txt3vs6West")) {
			toShow = model.getSeriesMapWest().get(3);
			
		}else if(sourceId.equals("txt2vs7West")) {
			toShow = model.getSeriesMapWest().get(4);
			
		}else if(sourceId.equals("txtFinalist1West")) {
			toShow = model.getSeriesMapWest().get(5);
			
		}else if(sourceId.equals("txtFinalist2West")) {
			toShow = model.getSeriesMapWest().get(6);
			
		}else if(sourceId.equals("txtWestWinner")) {
			toShow = model.getSeriesMapWest().get(7);
			
		}else if(sourceId.equals("txt1vs8East")) {//DA QUI OUTPUT EST
			toShow = model.getSeriesMapEast().get(1);
			
		}else if(sourceId.equals("txt4vs5East")) {
			toShow = model.getSeriesMapEast().get(2);
			
		}else if(sourceId.equals("txt3vs6East")) {
			toShow = model.getSeriesMapEast().get(3);
			
		}else if(sourceId.equals("txt2vs7East")) {
			toShow = model.getSeriesMapEast().get(4);
			
		}else if(sourceId.equals("txtFinalist1East")) {
			toShow = model.getSeriesMapEast().get(5);
			
		}else if(sourceId.equals("txtFinalist2East")) {
			toShow = model.getSeriesMapEast().get(6);
			
		}else if(sourceId.equals("txtEastWinner")) {
			toShow = model.getSeriesMapEast().get(7);
			
		}
		
		List<PlayerAVGStats> homeTeam = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(0).getHomeStats());
		List<PlayerAVGStats> awayTeam = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(0).getAwayStats());
		
		Collections.sort(homeTeam);
		Collections.sort(awayTeam);
		
		ObservableList<PlayerAVGStats> valuesH = FXCollections.observableArrayList(homeTeam);
		tableHome.setItems(valuesH);
		
		ObservableList<PlayerAVGStats> valuesA = FXCollections.observableArrayList(awayTeam);
		tableAway.setItems(valuesA);
		
		txtTeamHome.setText(toShow.getHome().getName());
		txtTeamAway.setText(toShow.getAway().getName());
		
		txtAreaResult.appendText("<<< RISULTATI PARTITE >>>\n *** Vincente: " + toShow.getWinner().getName() +" ***\n");
		txtAreaResult.appendText(toShow.toString() + "\n");
		
		
		for(Match m : toShow.getMatches()) {
			txtAreaResult.appendText(m + "\n");
		}
		
		
	}
}
