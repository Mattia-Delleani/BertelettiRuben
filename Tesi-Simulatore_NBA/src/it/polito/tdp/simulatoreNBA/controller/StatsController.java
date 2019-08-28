package it.polito.tdp.simulatoreNBA.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.layout.HBox;

import it.polito.tdp.simulatoreNBA.model.Match;
import it.polito.tdp.simulatoreNBA.model.Model;
import it.polito.tdp.simulatoreNBA.model.PlayerAVGStats;
import it.polito.tdp.simulatoreNBA.model.Series;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
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

   /* @FXML
    private HBox hBoxAvg;

    @FXML
    private TableView<PlayerAVGStats> tableHomeAvg;

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
    private TableColumn<PlayerAVGStats, String> col2PtH;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtH;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtH;

    @FXML
    private TableView<PlayerAVGStats> tableAwayAvg;

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
    private TableColumn<PlayerAVGStats, String> col2PtA;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtA;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtA;*/

    @FXML
    private TableView<PlayerAVGStats> tableHome1;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerH1;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameH1;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointH1;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistH1;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebH1;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopH1;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtH1;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtH1;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtH1;

    @FXML
    private TableView<PlayerAVGStats> tableAway1;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerA1;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameA1;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointA1;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistA1;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebA1;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopA1;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtA1;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtA1;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtA1;

    @FXML
    private TableView<PlayerAVGStats> tableHome2;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerH2;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameH2;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointH2;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistH2;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebH2;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopH2;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtH2;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtH2;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtH2;

    @FXML
    private TableView<PlayerAVGStats> tableAway2;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerA2;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameA2;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointA2;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistA2;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebA2;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopA2;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtA2;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtA2;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtA2;

    @FXML
    private TableView<PlayerAVGStats> tableHome3;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerH3;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameH3;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointH3;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistH3;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebH3;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopH3;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtH3;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtH3;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtH3;

    @FXML
    private TableView<PlayerAVGStats> tableAway3;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerA3;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameA3;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointA3;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistA3;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebA3;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopA3;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtA3;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtA3;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtA3;

    @FXML
    private TableView<PlayerAVGStats> tableHome4;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerH4;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameH4;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointH4;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistH4;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebH4;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopH4;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtH4;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtH4;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtH4;

    @FXML
    private TableView<PlayerAVGStats> tableAway4;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerA4;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameA4;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointA4;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistA4;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebA4;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopA4;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtA4;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtA4;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtA4;

    @FXML
    private HBox hBoxGame5;

    @FXML
    private TableView<PlayerAVGStats> tableHome5;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerH5;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameH5;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointH5;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistH5;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebH5;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopH5;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtH5;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtH5;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtH5;

    @FXML
    private TableView<PlayerAVGStats> tableAway5;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerA5;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameA5;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointA5;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistA5;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebA5;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopA5;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtA5;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtA5;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtA5;

    @FXML
    private HBox hBoxGame6;

    @FXML
    private TableView<PlayerAVGStats> tableHome6;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerH6;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameH6;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointH6;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistH6;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebH6;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopH6;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtH6;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtH6;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtH6;

    @FXML
    private TableView<PlayerAVGStats> tableAway6;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerA6;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameA6;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointA6;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistA6;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebA6;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopA6;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtA6;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtA6;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtA6;

    @FXML
    private HBox hBoxGame7;

    @FXML
    private TableView<PlayerAVGStats> tableHome7;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerH7;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameH7;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointH7;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistH7;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebH7;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopH7;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtH7;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtH7;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtH7;

    @FXML
    private TableView<PlayerAVGStats> tableAway7;

    @FXML
    private TableColumn<PlayerAVGStats, String> colPlayerA7;

    @FXML
    private TableColumn<PlayerAVGStats, Integer> colGameA7;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colPointA7;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colAssistA7;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colRebA7;

    @FXML
    private TableColumn<PlayerAVGStats, Double> colStopA7;

    @FXML
    private TableColumn<PlayerAVGStats, String> col2PtA7;

    @FXML
    private TableColumn<PlayerAVGStats, String> col3PtA7;

    @FXML
    private TableColumn<PlayerAVGStats, String> colFtA7;
    
    @FXML
    private ScrollPane scrollPane;


    @FXML
    void initialize() {
    	assert txtTeamHome != null : "fx:id=\"txtTeamHome\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert txtTeamAway != null : "fx:id=\"txtTeamAway\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert txtAreaResult != null : "fx:id=\"txtAreaResult\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableHome1 != null : "fx:id=\"tableHome1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerH1 != null : "fx:id=\"colPlayerH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameH1 != null : "fx:id=\"colGameH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointH1 != null : "fx:id=\"colPointH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistH1 != null : "fx:id=\"colAssistH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebH1 != null : "fx:id=\"colRebH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopH1 != null : "fx:id=\"colStopH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtH1 != null : "fx:id=\"col2PtH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtH1 != null : "fx:id=\"col3PtH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtH1 != null : "fx:id=\"colFtH1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableAway1 != null : "fx:id=\"tableAway1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerA1 != null : "fx:id=\"colPlayerA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameA1 != null : "fx:id=\"colGameA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointA1 != null : "fx:id=\"colPointA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistA1 != null : "fx:id=\"colAssistA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebA1 != null : "fx:id=\"colRebA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopA1 != null : "fx:id=\"colStopA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtA1 != null : "fx:id=\"col2PtA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtA1 != null : "fx:id=\"col3PtA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtA1 != null : "fx:id=\"colFtA1\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableHome2 != null : "fx:id=\"tableHome2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerH2 != null : "fx:id=\"colPlayerH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameH2 != null : "fx:id=\"colGameH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointH2 != null : "fx:id=\"colPointH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistH2 != null : "fx:id=\"colAssistH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebH2 != null : "fx:id=\"colRebH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopH2 != null : "fx:id=\"colStopH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtH2 != null : "fx:id=\"col2PtH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtH2 != null : "fx:id=\"col3PtH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtH2 != null : "fx:id=\"colFtH2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableAway2 != null : "fx:id=\"tableAway2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerA2 != null : "fx:id=\"colPlayerA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameA2 != null : "fx:id=\"colGameA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointA2 != null : "fx:id=\"colPointA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistA2 != null : "fx:id=\"colAssistA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebA2 != null : "fx:id=\"colRebA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopA2 != null : "fx:id=\"colStopA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtA2 != null : "fx:id=\"col2PtA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtA2 != null : "fx:id=\"col3PtA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtA2 != null : "fx:id=\"colFtA2\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableHome3 != null : "fx:id=\"tableHome3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerH3 != null : "fx:id=\"colPlayerH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameH3 != null : "fx:id=\"colGameH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointH3 != null : "fx:id=\"colPointH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistH3 != null : "fx:id=\"colAssistH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebH3 != null : "fx:id=\"colRebH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopH3 != null : "fx:id=\"colStopH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtH3 != null : "fx:id=\"col2PtH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtH3 != null : "fx:id=\"col3PtH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtH3 != null : "fx:id=\"colFtH3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableAway3 != null : "fx:id=\"tableAway3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerA3 != null : "fx:id=\"colPlayerA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameA3 != null : "fx:id=\"colGameA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointA3 != null : "fx:id=\"colPointA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistA3 != null : "fx:id=\"colAssistA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebA3 != null : "fx:id=\"colRebA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopA3 != null : "fx:id=\"colStopA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtA3 != null : "fx:id=\"col2PtA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtA3 != null : "fx:id=\"col3PtA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtA3 != null : "fx:id=\"colFtA3\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableHome4 != null : "fx:id=\"tableHome4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerH4 != null : "fx:id=\"colPlayerH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameH4 != null : "fx:id=\"colGameH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointH4 != null : "fx:id=\"colPointH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistH4 != null : "fx:id=\"colAssistH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebH4 != null : "fx:id=\"colRebH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopH4 != null : "fx:id=\"colStopH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtH4 != null : "fx:id=\"col2PtH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtH4 != null : "fx:id=\"col3PtH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtH4 != null : "fx:id=\"colFtH4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableAway4 != null : "fx:id=\"tableAway4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerA4 != null : "fx:id=\"colPlayerA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameA4 != null : "fx:id=\"colGameA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointA4 != null : "fx:id=\"colPointA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistA4 != null : "fx:id=\"colAssistA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebA4 != null : "fx:id=\"colRebA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopA4 != null : "fx:id=\"colStopA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtA4 != null : "fx:id=\"col2PtA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtA4 != null : "fx:id=\"col3PtA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtA4 != null : "fx:id=\"colFtA4\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert hBoxGame5 != null : "fx:id=\"hBoxGame5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableHome5 != null : "fx:id=\"tableHome5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerH5 != null : "fx:id=\"colPlayerH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameH5 != null : "fx:id=\"colGameH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointH5 != null : "fx:id=\"colPointH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistH5 != null : "fx:id=\"colAssistH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebH5 != null : "fx:id=\"colRebH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopH5 != null : "fx:id=\"colStopH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtH5 != null : "fx:id=\"col2PtH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtH5 != null : "fx:id=\"col3PtH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtH5 != null : "fx:id=\"colFtH5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableAway5 != null : "fx:id=\"tableAway5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerA5 != null : "fx:id=\"colPlayerA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameA5 != null : "fx:id=\"colGameA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointA5 != null : "fx:id=\"colPointA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistA5 != null : "fx:id=\"colAssistA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebA5 != null : "fx:id=\"colRebA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopA5 != null : "fx:id=\"colStopA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtA5 != null : "fx:id=\"col2PtA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtA5 != null : "fx:id=\"col3PtA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtA5 != null : "fx:id=\"colFtA5\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert hBoxGame6 != null : "fx:id=\"hBoxGame6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableHome6 != null : "fx:id=\"tableHome6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerH6 != null : "fx:id=\"colPlayerH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameH6 != null : "fx:id=\"colGameH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointH6 != null : "fx:id=\"colPointH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistH6 != null : "fx:id=\"colAssistH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebH6 != null : "fx:id=\"colRebH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopH6 != null : "fx:id=\"colStopH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtH6 != null : "fx:id=\"col2PtH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtH6 != null : "fx:id=\"col3PtH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtH6 != null : "fx:id=\"colFtH6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableAway6 != null : "fx:id=\"tableAway6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerA6 != null : "fx:id=\"colPlayerA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameA6 != null : "fx:id=\"colGameA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointA6 != null : "fx:id=\"colPointA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistA6 != null : "fx:id=\"colAssistA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebA6 != null : "fx:id=\"colRebA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopA6 != null : "fx:id=\"colStopA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtA6 != null : "fx:id=\"col2PtA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtA6 != null : "fx:id=\"col3PtA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtA6 != null : "fx:id=\"colFtA6\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert hBoxGame7 != null : "fx:id=\"hBoxGame7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableHome7 != null : "fx:id=\"tableHome7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerH7 != null : "fx:id=\"colPlayerH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameH7 != null : "fx:id=\"colGameH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointH7 != null : "fx:id=\"colPointH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistH7 != null : "fx:id=\"colAssistH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebH7 != null : "fx:id=\"colRebH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopH7 != null : "fx:id=\"colStopH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtH7 != null : "fx:id=\"col2PtH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtH7 != null : "fx:id=\"col3PtH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtH7 != null : "fx:id=\"colFtH7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert tableAway7 != null : "fx:id=\"tableAway7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPlayerA7 != null : "fx:id=\"colPlayerA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colGameA7 != null : "fx:id=\"colGameA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colPointA7 != null : "fx:id=\"colPointA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colAssistA7 != null : "fx:id=\"colAssistA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colRebA7 != null : "fx:id=\"colRebA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colStopA7 != null : "fx:id=\"colStopA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col2PtA7 != null : "fx:id=\"col2PtA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert col3PtA7 != null : "fx:id=\"col3PtA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
        assert colFtA7 != null : "fx:id=\"colFtA7\" was not injected: check your FXML file 'StatsForGame.fxml'.";
       
        
        
        colPlayerH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block"));
        col2PtH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtH1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        colPlayerA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        col2PtA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtA1.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        
        colPlayerH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block"));
        col2PtH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtH2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        colPlayerA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        col2PtA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtA2.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        
        colPlayerH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block"));
        col2PtH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtH3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        colPlayerA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        col2PtA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtA3.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        
        colPlayerH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block"));
        col2PtH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtH4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        colPlayerA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        col2PtA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtA4.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        
        colPlayerH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block"));
        col2PtH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtH5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        colPlayerA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        col2PtA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtA5.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        
        colPlayerH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block"));
        col2PtH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtH6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        colPlayerA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        col2PtA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtA6.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        
        colPlayerH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block"));
        col2PtH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtH7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
        colPlayerA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("name"));
        colGameA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Integer>("ngames"));
        colPointA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("point"));      
        colAssistA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("assist"));
        colRebA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("rebounds")); 
        colStopA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, Double>("block")); 
        col2PtA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("fgAvg"));
        col3PtA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("threeAvg"));
        colFtA7.setCellValueFactory(new PropertyValueFactory<PlayerAVGStats, String>("freeAvg"));
        
      
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
			
		}else if(sourceId.equals("finale")) {
			toShow = model.getSeriesMapWest().get(8);//la finale viene salvata nella mappa ovest
		}
	
		//inserimento valori tabella 1
		List<PlayerAVGStats> homeTeam1 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(0).getHomeStats());
		List<PlayerAVGStats> awayTeam1 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(0).getAwayStats());
		
		Collections.sort(homeTeam1);
		Collections.sort(awayTeam1);
		
		ObservableList<PlayerAVGStats> valuesH1 = FXCollections.observableArrayList(homeTeam1);
		tableHome1.setItems(valuesH1);
		
		ObservableList<PlayerAVGStats> valuesA1 = FXCollections.observableArrayList(awayTeam1);
		tableAway1.setItems(valuesA1);
		
		//inserimento valori tabella 2
		List<PlayerAVGStats> homeTeam2 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(1).getHomeStats());
		List<PlayerAVGStats> awayTeam2 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(1).getAwayStats());
		
		Collections.sort(homeTeam2);
		Collections.sort(awayTeam2);
		
		ObservableList<PlayerAVGStats> valuesH2 = FXCollections.observableArrayList(homeTeam1);
		tableHome2.setItems(valuesH2);
		
		ObservableList<PlayerAVGStats> valuesA2 = FXCollections.observableArrayList(awayTeam1);
		tableAway2.setItems(valuesA2);
		
		//inserimento valori tabella 3
		List<PlayerAVGStats> homeTeam3 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(2).getHomeStats());
		List<PlayerAVGStats> awayTeam3 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(2).getAwayStats());
		
		Collections.sort(homeTeam3);
		Collections.sort(awayTeam3);
		
		ObservableList<PlayerAVGStats> valuesH3 = FXCollections.observableArrayList(homeTeam3);
		tableHome3.setItems(valuesH3);
		
		ObservableList<PlayerAVGStats> valuesA3 = FXCollections.observableArrayList(awayTeam3);
		tableAway3.setItems(valuesA3);
		
		//inserimento valori tabella 4
		List<PlayerAVGStats> homeTeam4 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(3).getHomeStats());
		List<PlayerAVGStats> awayTeam4 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(3).getAwayStats());
		
		Collections.sort(homeTeam4);
		Collections.sort(awayTeam4);
		
		ObservableList<PlayerAVGStats> valuesH4 = FXCollections.observableArrayList(homeTeam4);
		tableHome4.setItems(valuesH4);
		
		ObservableList<PlayerAVGStats> valuesA4 = FXCollections.observableArrayList(awayTeam4);
		tableAway4.setItems(valuesA4);
		
		if(toShow.getMatches().size() > 4) {
			
			this.hBoxGame5.setDisable(false);
			
			//inserimento valori tabella 5
			List<PlayerAVGStats> homeTeam5 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(4).getHomeStats());
			List<PlayerAVGStats> awayTeam5 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(4).getAwayStats());
			
			Collections.sort(homeTeam5);
			Collections.sort(awayTeam5);
			
			ObservableList<PlayerAVGStats> valuesH5 = FXCollections.observableArrayList(homeTeam4);
			tableHome5.setItems(valuesH5);
			
			ObservableList<PlayerAVGStats> valuesA5 = FXCollections.observableArrayList(awayTeam4);
			tableAway5.setItems(valuesA5);
			
			if(toShow.getMatches().size() > 5) {
				
				this.hBoxGame6.setDisable(false);
				
				//inserimento valori tabella 6
				List<PlayerAVGStats> homeTeam6 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(5).getHomeStats());
				List<PlayerAVGStats> awayTeam6 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(5).getAwayStats());
				
				Collections.sort(homeTeam6);
				Collections.sort(awayTeam6);
				
				ObservableList<PlayerAVGStats> valuesH6 = FXCollections.observableArrayList(homeTeam6);
				tableHome6.setItems(valuesH6);
				
				ObservableList<PlayerAVGStats> valuesA6 = FXCollections.observableArrayList(awayTeam6);
				tableAway6.setItems(valuesA6);
				
				if(toShow.getMatches().size() > 6) {
					
					this.hBoxGame7.setDisable(false);
					
					//inserimento valori tabella 7
					List<PlayerAVGStats> homeTeam7 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(6).getHomeStats());
					List<PlayerAVGStats> awayTeam7 = new ArrayList<PlayerAVGStats>(toShow.getMatches().get(6).getAwayStats());
					
					Collections.sort(homeTeam7);
					Collections.sort(awayTeam7);
					
					ObservableList<PlayerAVGStats> valuesH7 = FXCollections.observableArrayList(homeTeam7);
					tableHome7.setItems(valuesH7);
					
					ObservableList<PlayerAVGStats> valuesA7 = FXCollections.observableArrayList(awayTeam7);
					tableAway7.setItems(valuesA7);
					
				}
				
				
				
			}
			
			
			
		}
		
		
		
		
		
		txtTeamHome.setText(toShow.getHome().getName());
		txtTeamAway.setText(toShow.getAway().getName());
		
		txtAreaResult.appendText("<<< RISULTATI PARTITE >>>\n *** Vincente: " + toShow.getWinner().getName() +" ***\n");
		txtAreaResult.appendText(toShow.toString() + "\n");
		
		
		for(Match m : toShow.getMatches()) {
			txtAreaResult.appendText(m + "\n");
		}
		
		
	}
}
