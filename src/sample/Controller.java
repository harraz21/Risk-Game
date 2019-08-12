package sample;

import Model.Agents.Agent;
import Model.Agents.Pacifist;
import Model.Map.RiskMap;
import Model.Map.Territory;
import Model.MapLoading.EgyptCities;
import Model.MapLoading.Maps;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private Canvas myCanvas;
    Maps map;
    int w= 250;
    int l = 250;
    static int selectCountry = 0;
    @FXML
    private ListView<String> cityList;

    static boolean once = false;

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
            if (!once){
                Agent A  = new Pacifist();
                Agent B = new Pacifist();
                myMap = new RiskMap(A,B);
                loadEgypt();
                once = true;
            }
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
        for (int i = 0; i < 26; i++) {
            try {


                for (int j :
                        list.get(i)) {
                    Territory.neighbor(myMap.getTerritories().get(i), myMap.getTerritories().get(j));
                }
            }catch (Exception e){
                //System.out.println("No problem");
            }
        }


    }
    public void nextTurn(ActionEvent mouseEvent){
        update();
    }
    public void update(){
        cityList.getItems().clear();
        String ss = String.format("%-16.16s |  Player  | Army","City");
        cityList.getItems().add(ss);
        EgyptCities.loadCitiesList();
        for (int i = 0; i < 26; i++) {

            String s = String.format("%-16.16s | Player %1d | %4d", EgyptCities.citiesList[i],
                    myMap.getPlayers().indexOf(myMap.getTerritories().get(i))+1,
                    myMap.getTerritories().get(i).getArmyUnits().getNoOfUnits());
            cityList.getItems().add(s);
        }

    }
    public void onMousePressed(MouseEvent mouseEvent) {
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
    }
}
