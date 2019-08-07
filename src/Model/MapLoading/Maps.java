package Model.MapLoading;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;


import java.util.ArrayList;
import java.util.HashMap;

public class Maps {
    HashMap<Integer, ArrayList<Pair<Integer, Integer>>> cityPixelsList;

    public Maps() {
        EgyptCities.loadAdjacencyList();
        EgyptCities.loadCitiesList();
        EgyptCities.loadColourList();
        cityPixelsList = new HashMap<>();
    }


    public void loadCityPixelsList() {
        for (int i = 0; i < EgyptCities.citiesList.length; i++) {
            ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<>();
            cityPixelsList.put(i, arrayList);
        }
        Image colouredMap = new Image("file:res/Maps_Images/EgyptColouredMap.png");
        PixelReader pixelReader = colouredMap.getPixelReader();
        int width = 337;
        int height = 300;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pair<Integer, Integer> pair = new Pair<>(x * 4, y * 3);
                if (EgyptCities.isAcity(colouredMap.getPixelReader().getColor(x, y))) {
                    cityPixelsList.get(EgyptCities.getCity(pixelReader.getColor(x, y))).add(pair);
                }
            }
        }
    }

    public void ColourAcity(Canvas canvas, int City, Color color) {
        int x;
        int y;
        for (Pair<Integer, Integer> XY : cityPixelsList.get(City)) {
            x = XY.getKey();
            y = XY.getValue();
            canvas.getGraphicsContext2D().setFill(Color.WHITE);
            canvas.getGraphicsContext2D().fillRect(x,y,4,3);
            canvas.getGraphicsContext2D().setFill(color);
            canvas.getGraphicsContext2D().fillRect(x, y, 4, 3);
        }
    }

}
