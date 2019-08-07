package sample;

import Model.Map.Map;
import Model.MapLoading.EgyptCities;
import Model.MapLoading.Maps;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private Canvas myCanvas;
    Maps map;
    Image country = new Image("file:res/Maps_Images/EgyptMap.png");
    Image colouredCountry = new Image("file:res/Maps_Images/EgyptColouredMap.png");
    Boolean aBoolean = false;

    public void initialize(URL url, ResourceBundle rb) {
        map = new Maps();
        map.loadCityPixelsList();
        myCanvas.getGraphicsContext2D().drawImage(country, 0, 0, 337, 300, 0, 0, 337 * 4, 300 * 3);

    }


    public void onMousePressed(MouseEvent mouseEvent) {
        if (colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3) != null) {
            if (EgyptCities.isAcity(colouredCountry.getPixelReader().getColor((int) mouseEvent.getX()/4 , (int) mouseEvent.getY() / 3))) {
                if (aBoolean) {
                    map.ColourAcity(myCanvas, EgyptCities.getCity(colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3)), Color.YELLOW);
                    aBoolean = false;
                } else {
                    map.ColourAcity(myCanvas, EgyptCities.getCity(colouredCountry.getPixelReader().getColor((int) mouseEvent.getX() / 4, (int) mouseEvent.getY() / 3)), Color.RED);
                    aBoolean = true;
                }
            }
        }
    }
}
