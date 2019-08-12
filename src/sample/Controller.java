package sample;

import Model.Agents.Agent;
import Model.Agents.Aggressive;
import Model.Agents.Human;
import Model.Agents.Pacifist;
import Model.Map.RiskMap;
import Model.Map.Territory;
import Model.MapLoading.EgyptCities;
import Model.MapLoading.Maps;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

import static sample.Main.primarystage;


public class Controller implements Initializable {

    @FXML
    private Canvas myCanvas;
    Maps map;
    int w= 250;
    int l = 250;
    static int selectCountry = 0;
    @FXML
    private ListView<String> cityList;
    static int turn = 0;
    static Territory source = null;
    static Territory destination = null;

    Image country = (new Image("file:res/Maps_Images/EgyptMap.png",w,l,false,true));
    Image colouredCountry = new Image("file:res/Maps_Images/EgyptColouredMap.png",w,l,false,true);
    Boolean aBoolean  = false;
    static RiskMap myMap = null;
    static HashMap<String,Territory> Egypt = new HashMap<String,Territory>();
    public void initialize(URL url, ResourceBundle rb) {
        map = new Maps();
        map.loadCityPixelsList(w,l);
        myCanvas.getGraphicsContext2D().drawImage(country, 0, 0, w, l, 0, 0, w * 4, l * 3);
        //        myCanvas.getGraphicsContext2D().drawImage(country, 0, 0, 337, 300, 0, 0, 337 * 4, 300 * 3);
        if (url.getPath().contains("sample")){
            if (!Message.once){
                turn = 0;
                Agent A  = Message.Player1;
                Agent B = Message.Player2;
                myMap = new RiskMap(A,B);
                loadEgypt();

                Message.once = true;
            }
        }
    }
    void place(){
        for (int i = 0; i < 20; i++) {
            myMap.getPlayers().get(0).getTerritoriesOccuopied().get((new Random()
            .nextInt(myMap.getPlayers().get(0).getTerritoriesOccuopied().size()))).addSoldiers(1);
            myMap.getPlayers().get(1).getTerritoriesOccuopied().get((new Random()
                    .nextInt(myMap.getPlayers().get(1).getTerritoriesOccuopied().size()))).addSoldiers(1);

        }
    }
    public void loadEgypt(){
        /*ArrayList<String> names  = new ArrayList<String>();
        {
            names.add(new String(new String("AL_GHARBEYA")));
            names.add(new String("AL_ISMAELIA"));// 1;
            names.add(new String("AL_MONOFIYA"));// 2;
            names.add(new String("AL_QAHERA"));// 3;
            names.add(new String("AL_QALUOBIYA"));// 4;
            names.add(new String("AL_SHARQIYA"));// 5;
            names.add(new String("AL_SUAIS"));// 6;
            names.add(new String("AL_DAKAHLIYA"));// 7;
            names.add(new String("PORT_SAID"));// 8;
            names.add(new String("DUMYAT"));// 9;
            names.add(new String("MATROUH"));// 10;
            names.add(new String("AL_BUHEIRA"));// 11;
            names.add(new String("AL_FAYOUM"));// 12;
            names.add(new String("AL_ISKINDERIA"));// 13;
            names.add(new String("AL_GIZA"));// 14;
            names.add(new String("AL_MINIA"));// 15;
            names.add(new String("BANI_SUAIF"));// 16;
            names.add(new String("KAFR_EL_SHIEKH"));// 17;
            names.add(new String("ASWAN"));// 18;
            names.add(new String("ASYOUT"));// 19;
            names.add(new String("AL_WADI_AL_JADID"));// 20;
            names.add(new String("QINA"));// 21;
            names.add(new String("SUHAJ"));
            names.add(new String("AL_BAHR_AL_AHMAR"));
            names.add(new String("SHMAL_SINAA"));
            names.add(new String("JANUB_SINAA"));
        }
        
        for (String x:
             names) {
            System.out.println(x);
            Egypt.put(x,new Territory());
        }
        {
            ArrayList <Territory> buffer;
            Egypt.get("AL_GHARBEYA");
            buffer =   Egypt.get("AL_GHARBEYA").getNeighboringTerritories();
            buffer.add( Egypt.get("AL_DAKAHLIYA"));
            buffer.add(KAFR_EL_SHIEKH);
            buffer.add(AL_BUHEIRA);
            buffer.add(AL_MONOFIYA);
            buffer.add(AL_QALUOBIYA);

        }
        System.out.println("size eg" + names.size());

        */
        for (int i = 0; i < 26; i++) {
            myMap.addTerritory(new Territory());
        }
        EgyptCities.loadAdjacencyList();
        HashMap<Integer, ArrayList<Integer>> list = EgyptCities.adjacencyList;
        System.out.println("list is " + list);
        for (int i = 0; i < 26; i++) {
            try {
                for (int j : list.get(i)) {
                    Territory.neighbor(myMap.getTerritories().get(i), myMap.getTerritories().get(j));
                }
            }catch (Exception e){

            }

        }

        for (Territory x:
             myMap.getTerritories()) {
            x.setDefender(myMap.getPlayers().get( (new Random()).nextInt(2)));
        }
        place();

        updateIndex();
        update();
    }
    @FXML
    private Label unitsAvailable;

    @FXML
    private TextField numberOfUnits;

    @FXML
    private Label playerTurn;

    @FXML
    private Label turns;

    public void nextTurn(ActionEvent mouseEvent){
        if (myMap.isGoal()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Game Ended " , ButtonType.OK);
            alert.show();

        }
        System.out.println("herere");
        RiskMap newMyMap =  myMap.getPlayers().get(turn%2).play(myMap);
        System.out.println("ffffffherere");
        if (newMyMap != null){
            myMap = newMyMap;

            System.out.println("Not Null");
        }
        if (myMap.getPlayers().get(turn%2).getNoOfUnitsAvaliable()>0){
            System.out.println("Please Place All units "
                    +myMap.getPlayers().get(turn%2).getNoOfUnitsAvaliable());
            return;
        }
        turn++;

        myMap.getPlayers().get(turn%2).updateUnitsAvaliable();

        updateIndex();
        update();
        source = destination= null;

    }
    @FXML
    void next100Turn(ActionEvent event) {
        for (int i = 0; i < 10; i++) {
            nextTurn(event);
        }
    }

    public void update(){
        if (myMap.isGoal()){
            System.out.println("GOAL Reached");
        }

        cityList.getItems().clear();
        String ss = String.format("%-16.16s |  Player  | Army","City");
        cityList.getItems().add(ss);
        EgyptCities.loadCitiesList();
        for (int i = 0; i < 26; i++) {

            String s = String.format("%-16.16s | Player %1d | %4d", EgyptCities.citiesList[i],
                    myMap.getPlayers().indexOf(myMap.getTerritories().get(i).getDefender())+1,
                    myMap.getTerritories().get(i).getArmyUnits().getNoOfUnits());
            cityList.getItems().add(s);
        }
        updateColors();
        myMap.print();
    }
    @FXML
    private Label player1Terr;

    @FXML
    private Label player2Terr;

    void updateIndex(){
        unitsAvailable.setText(Integer.toString(myMap.getPlayers().get(turn%2)
                .getNoOfUnitsAvaliable()));
        turns.setText(Integer.toString(turn));
        playerTurn.setText(Integer.toString(turn%2));
        player1Terr.setText(Integer.toString( myMap.getPlayers().get(0)
                .getTerritoriesOccuopied().size()));
        player2Terr.setText(Integer.toString( myMap.getPlayers().get(1)
                .getTerritoriesOccuopied().size()));
    }
    void updateColors(){
        for (int i = 0; i < 26; i++) {
            Color myColor;
            int index = myMap.getPlayers().indexOf (myMap.getTerritories().get(i).getDefender());
            if (index == 0){
                myColor = Color.RED;
            }else if (index ==1){
                myColor = Color.YELLOW;
            }else {
                myColor = Color.CYAN;
            }
            map.ColourAcity(myCanvas,i,myColor);
        }
    }
    public void onMousePressed(MouseEvent mouseEvent) {
        /*
        if (colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3) != null) {
            if (EgyptCities.isAcity(colouredCountry.getPixelReader().getColor((int) mouseEvent.getX()/4 , (int) mouseEvent.getY() / 3))) {
                if (aBoolean) {
                    map.ColourAcity(myCanvas, EgyptCities.getCity(colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3)), Color.YELLOW);
                    aBoolean  =  false;
                } else {
                    map.ColourAcity(myCanvas, EgyptCities.getCity(colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3)), Color.RED);
                    aBoolean  =  true;
                }
            }
        }
        */
        if ((turn %2)==0){
            if (colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3) != null) {
                if (EgyptCities.isAcity(colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3))) {
                    int cityindex = EgyptCities.getCity(colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3));

                    if (myMap.getTerritories().get(cityindex).getDefender() instanceof Human) {
                        if (myMap.getTerritories().get(cityindex).getDefender().getNoOfUnitsAvaliable() > 0) {
                            myMap.getTerritories().get(cityindex).addSoldiers(1);
                            myMap.getTerritories().get(cityindex).getDefender().setNoOfUnitsAvaliable(
                                    myMap.getTerritories().get(cityindex).getDefender()
                                            .getNoOfUnitsAvaliable() - 1);
                            updateIndex();
                            return;
                        }
                    }
                    if (source == null) {
                        if (myMap.getTerritories().get(cityindex).getDefender() instanceof Human) {
                            map.ColourAcity(myCanvas, cityindex, Color.GREEN);
                            source = myMap.getTerritories().get(cityindex);
                        }
                    }else {
                        if (destination == null){
                            if (myMap.getTerritories().get(cityindex).isNeighbor(source)) {
                                map.ColourAcity(myCanvas, cityindex, Color.BLUE);
                                destination = myMap.getTerritories().get(cityindex);
                            }
                        }
                    }


                }
            }
        }

    }

    @FXML
    void move(ActionEvent event) {
        if ((source!=null) && (destination!=null)){
            source.move(destination);
            System.out.println("moved");
            source = destination= null;
            updateColors();
        }
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("startingScene.fxml"));
        primarystage.setTitle("Risk Game");
        primarystage.setScene(new Scene(root));//, 300, 275));
        primarystage.show();
    }
}
