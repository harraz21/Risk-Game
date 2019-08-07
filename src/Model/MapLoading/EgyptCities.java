package Model.MapLoading;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class EgyptCities {
    public static final int AL_GHARBEYA = 0;
    public static final int AL_ISMAELIA = 1;
    public static final int AL_MONOFIYA = 2;
    public static final int AL_QAHERA = 3;
    public static final int AL_QALUOBIYA = 4;
    public static final int AL_SHARQIYA = 5;
    public static final int AL_SUAIS = 6;
    public static final int AL_DAKAHLIYA = 7;
    public static final int PORT_SAID = 8;
    public static final int DUMYAT = 9;
    public static final int MATROUH = 10;
    public static final int AL_BUHEIRA = 11;
    public static final int AL_FAYOUM = 12;
    public static final int AL_ISKINDERIA = 13;
    public static final int AL_GIZA = 14;
    public static final int AL_MINIA = 15;
    public static final int BANI_SUAIF = 16;
    public static final int KAFR_EL_SHIEKH = 17;
    public static final int ASWAN = 18;
    public static final int ASYOUT = 19;
    public static final int AL_WADI_AL_JADID = 20;
    public static final int QINA = 21;
    public static final int SUHAJ = 22;
    public static final int AL_BAHR_AL_AHMAR = 23;
    public static final int SHMAL_SINAA = 24;
    public static final int JANUB_SINAA = 25;
    // public static final int LUXOR = 26;

    public static Color[] citiesColourList = new  Color[27];
    public static String[] citiesList = new  String[27];
    public static HashMap<Integer, ArrayList<Integer>> adjacencyList;

    public static void loadAdjacencyList()
    {
        adjacencyList = new HashMap<>();
        ArrayList<Integer> buffer = new ArrayList<>();
        buffer.add(AL_DAKAHLIYA);
        buffer.add(KAFR_EL_SHIEKH);
        buffer.add(AL_BUHEIRA);
        buffer.add(AL_MONOFIYA);
        buffer.add(AL_QALUOBIYA);
        adjacencyList.put(AL_GHARBEYA,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_SHARQIYA);
        buffer.add(AL_QAHERA);
        buffer.add(AL_SUAIS);
        buffer.add(SHMAL_SINAA);
        buffer.add(PORT_SAID);
        adjacencyList.put(AL_ISMAELIA,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_GHARBEYA);
        buffer.add(AL_BUHEIRA);
        buffer.add(AL_QALUOBIYA);
        buffer.add(AL_GIZA);
        buffer.add(AL_DAKAHLIYA);
        adjacencyList.put(AL_MONOFIYA,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_GIZA);
        buffer.add(AL_SUAIS);
        buffer.add(AL_ISMAELIA);
        buffer.add(AL_SHARQIYA);
        buffer.add(AL_QALUOBIYA);
        adjacencyList.put(AL_QAHERA,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_QAHERA);
        buffer.add(AL_GIZA);
        buffer.add(AL_MONOFIYA);
        buffer.add(AL_GHARBEYA);
        buffer.add(AL_DAKAHLIYA);
        buffer.add(AL_SHARQIYA);
        adjacencyList.put(AL_QALUOBIYA,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_QAHERA);
        buffer.add(AL_QALUOBIYA);
        buffer.add(AL_DAKAHLIYA);
        buffer.add(AL_ISMAELIA);
        buffer.add(PORT_SAID);
        adjacencyList.put(AL_SHARQIYA,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(AL_GIZA);
        buffer.add(AL_QAHERA);
        buffer.add(AL_ISMAELIA);
        buffer.add(SHMAL_SINAA);
        buffer.add(JANUB_SINAA);
        adjacencyList.put(AL_SUAIS,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_SHARQIYA);
        buffer.add(AL_QALUOBIYA);
        buffer.add(AL_GHARBEYA);
        buffer.add(KAFR_EL_SHIEKH);
        buffer.add(DUMYAT);
        buffer.add(PORT_SAID);
        adjacencyList.put(AL_DAKAHLIYA,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_DAKAHLIYA);
        buffer.add(AL_SHARQIYA);
        buffer.add(AL_ISMAELIA);
        buffer.add(SHMAL_SINAA);
        adjacencyList.put(PORT_SAID,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_DAKAHLIYA);
        adjacencyList.put(DUMYAT,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_ISKINDERIA);
        buffer.add(AL_BUHEIRA);
        buffer.add(AL_GIZA);
        buffer.add(AL_WADI_AL_JADID);
        adjacencyList.put(MATROUH,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_ISKINDERIA);
        buffer.add(MATROUH);
        buffer.add(AL_GIZA);
        buffer.add(AL_MONOFIYA);
        buffer.add(AL_GHARBEYA);
        buffer.add(KAFR_EL_SHIEKH);
        adjacencyList.put(AL_BUHEIRA,buffer);
        buffer = new ArrayList<>();
        buffer.add(BANI_SUAIF);
        buffer.add(AL_GIZA);
        adjacencyList.put(AL_FAYOUM,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_SUAIS);
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(BANI_SUAIF);
        buffer.add(AL_FAYOUM);
        buffer.add(AL_MINIA);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(MATROUH);
        buffer.add(AL_BUHEIRA);
        buffer.add(AL_MONOFIYA);
        buffer.add(AL_QALUOBIYA);
        buffer.add(AL_QAHERA);
        adjacencyList.put(AL_GIZA,buffer);
        buffer = new ArrayList<>();
        buffer.add(BANI_SUAIF);
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(ASYOUT);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(AL_GIZA);
        adjacencyList.put(AL_MINIA,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_FAYOUM);
        buffer.add(AL_GIZA);
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(AL_MINIA);
        adjacencyList.put(BANI_SUAIF,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_BUHEIRA);
        buffer.add(AL_GHARBEYA);
        buffer.add(AL_DAKAHLIYA);
        adjacencyList.put(KAFR_EL_SHIEKH,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(QINA);
        buffer.add(AL_WADI_AL_JADID);
        adjacencyList.put(ASWAN,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(AL_MINIA);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(SUHAJ);
        adjacencyList.put(ASYOUT,buffer);
        buffer = new ArrayList<>();
        buffer.add(MATROUH);
        buffer.add(AL_GIZA);
        buffer.add(AL_MINIA);
        buffer.add(ASYOUT);
        buffer.add(SUHAJ);
        buffer.add(QINA);
        buffer.add(ASWAN);
        adjacencyList.put(AL_WADI_AL_JADID,buffer);
        buffer = new ArrayList<>();
        buffer.add(SUHAJ);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(ASWAN);
        buffer.add(AL_BAHR_AL_AHMAR);
        adjacencyList.put(QINA,buffer);
        buffer = new ArrayList<>();
        buffer.add(ASYOUT);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(QINA);
        buffer.add(AL_BAHR_AL_AHMAR);
        adjacencyList.put(SUHAJ,buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_SUAIS);
        buffer.add(AL_GIZA);
        buffer.add(BANI_SUAIF);
        buffer.add(AL_MINIA);
        buffer.add(ASYOUT);
        buffer.add(SUHAJ);
        buffer.add(QINA);
        buffer.add(ASWAN);
        adjacencyList.put(AL_BAHR_AL_AHMAR,buffer);
        buffer = new ArrayList<>();
        buffer.add(SHMAL_SINAA);
        buffer.add(AL_SUAIS);
        adjacencyList.put(JANUB_SINAA,buffer);
        buffer = new ArrayList<>();
        buffer.add(JANUB_SINAA);
        buffer.add(AL_ISMAELIA);
        buffer.add(AL_SUAIS);
        buffer.add(PORT_SAID);
        adjacencyList.put(SHMAL_SINAA,buffer);
    }


    public static void loadColourList()
    {
        citiesColourList[AL_GHARBEYA] = Color.valueOf("#41ae76");
        citiesColourList[AL_ISMAELIA] = Color.valueOf("#238b45");
        citiesColourList[AL_MONOFIYA] = Color.valueOf("#006d2c");
        citiesColourList[AL_QAHERA] = Color.valueOf("#00441b");
        citiesColourList[AL_QALUOBIYA] = Color.valueOf("#8c6bb1");
        citiesColourList[AL_SHARQIYA] = Color.valueOf("#88419d");
        citiesColourList[AL_SUAIS] = Color.valueOf("#810f7c");
        citiesColourList[AL_DAKAHLIYA] = Color.valueOf("#4d004b");
        citiesColourList[PORT_SAID] = Color.valueOf("#4eb3d3");
        citiesColourList[DUMYAT] = Color.valueOf("#2b8cbe");
        citiesColourList[MATROUH] = Color.valueOf("#0868ac");
        citiesColourList[AL_BUHEIRA] = Color.valueOf("#084081");
        citiesColourList[AL_FAYOUM] = Color.valueOf("#ef6548");
        citiesColourList[AL_ISKINDERIA] = Color.valueOf("#b30000");
        citiesColourList[AL_GIZA] = Color.valueOf("#7f0000");
        citiesColourList[AL_MINIA] = Color.valueOf("#3690c0");
        citiesColourList[BANI_SUAIF] = Color.valueOf("#0570b0");
        citiesColourList[KAFR_EL_SHIEKH] = Color.valueOf("#045a8d");
        citiesColourList[ASWAN] = Color.valueOf("#023858");
        citiesColourList[ASYOUT] = Color.valueOf("#41ab5d");
        citiesColourList[AL_WADI_AL_JADID] = Color.valueOf("#238443");
        citiesColourList[QINA] = Color.valueOf("#006837");
        citiesColourList[SUHAJ] = Color.valueOf("#004529");
        citiesColourList[AL_BAHR_AL_AHMAR] = Color.valueOf("#fc4e2a");
        citiesColourList[SHMAL_SINAA] = Color.valueOf("#d7301f");
        citiesColourList[JANUB_SINAA] = Color.valueOf("#e31a1c");
        // citiesColourList[LUXOR] = Color.valueOf("#bd0026");
    }

    public static void loadCitiesList()
    {
        citiesList[AL_GHARBEYA] = "AL_GHARBEYA";
        citiesList[AL_ISMAELIA] = "AL_ISMAELIA";
        citiesList[AL_MONOFIYA] = "AL_MONOFIYA";
        citiesList[AL_QAHERA] = "AL_QAHERA";
        citiesList[AL_QALUOBIYA] = "AL_QALUOBIYA";
        citiesList[AL_SHARQIYA] = "AL_SHARQIYA";
        citiesList[AL_SUAIS] = "AL_SUAIS";
        citiesList[AL_DAKAHLIYA] = "AL_DAKAHLIYA";
        citiesList[PORT_SAID] = "PORT_SAID";
        citiesList[DUMYAT] = "DUMYAT";
        citiesList[MATROUH] = "MATROUH";
        citiesList[AL_BUHEIRA] = "AL_BUHEIRA";
        citiesList[AL_FAYOUM] = "AL_FAYOUM";
        citiesList[AL_ISKINDERIA] = "AL_ISKINDERIA";
        citiesList[AL_GIZA] = "AL_GIZA";
        citiesList[AL_MINIA] = "AL_MINIA";
        citiesList[BANI_SUAIF] = "BANI_SUAIF";
        citiesList[KAFR_EL_SHIEKH] = "KAFR_EL_SHIEKH";
        citiesList[ASWAN] = "ASWAN";
        citiesList[ASYOUT] = "ASYOUT";
        citiesList[AL_WADI_AL_JADID] = "AL_WADI_AL_JADID";
        citiesList[QINA] = "QINA";
        citiesList[SUHAJ] = "SUHAJ";
        citiesList[AL_BAHR_AL_AHMAR] = "AL_BAHR_AL_AHMAR";
        citiesList[SHMAL_SINAA] = "SHMAL_SINAA";
        citiesList[JANUB_SINAA] = "JANUB_SINAA";
        //citiesList[LUXOR] = "LUXOR";
    }

    public static String getCityName(Color color)
    {
        for (int i = 0;i <  26;i++) {
            if (citiesColourList[i].equals(color))
                return citiesList[i];
        }
        return null;
    }

    public static int getCity(Color color)
    {
        for (int i = 0;i <  26;i++) {
            if (citiesColourList[i].equals(color))
                return i;
        }
        return Integer.MAX_VALUE;
    }





}
