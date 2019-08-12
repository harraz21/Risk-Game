package Model.MapLoading;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class USA {
    public static final int HAWAI = 0;
    public static final int ALASKA = 1;
    public static final int FLORIDA = 2;
    public static final int NEW_HAMPHSIRE = 3;
    public static final int VERMONT = 4;
    public static final int MAINE = 5;
    public static final int RHODE_ISLNAD = 6;
    public static final int NEW_YORK = 7;
    public static final int PENNSYLVANIA = 8;

    public static final int NEW_JERSEY = 9;
    public static final int DELWARE = 10;
    public static final int MARYLAND = 11;
    public static final int VIRGINIA = 12;
    public static final int OHIO = 13;
    public static final int INDIANA = 14;
    public static final int ILLINOIS = 15;
    public static final int CONNECTICUT = 16;
    public static final int NORTH_CAROLINA = 17;
    public static final int DISTRICT_OF_COLUMBIA = 18;
    public static final int MASSACHUSETTS = 19;
    public static final int TENNESSEE = 20;
    public static final int ARKANSAS= 21;
    public static final int MISSOURI= 22;
    public static final int GEORGIA = 23;
    public static final int SOUTH_CAROLINA = 24;
    public static final int KENTUCKY = 25;


    public static final int ALABAMA = 27;
    public static final int LOUISIANA = 28;
    public static final int MISSISSIPI = 29;
    public static final int LOWA = 30;
    public static final int MINNESOTA = 31;
    public static final int OKLAHOMA = 32;
    public static final int TEXAS= 33;
    public static final int NEW_MEXICO = 34;
    public static final int KANSAS = 35;
    public static final int NEBRASKA = 36;
    public static final int SOUTH_DAKOTA = 37;
    public static final int NOURTH_DAKOTA= 38;
    public static final int WYOMING= 39;
    public static final int COLORADO = 40;
    public static final int UTAH = 41;
    public static final int ARIZONA = 42;
    public static final int NEVADA = 43;

    public static final int OREGON= 44;
    public static final int WASHINGTON = 45;
    public static final int CALIFORNIA = 46;
    public static final int MICHIGAN = 47;
    public static final int LDAHO = 48;
    public static final int GUAM= 49;
    public static final int VIGIN_ISLAND = 50;
    public static final int PUERTO_RICO = 51;
    public static final int NORTHEN_MARIANA = 52;
    public static final int AMERICAN_SAMAO = 53;


    public static Color[] citiesColourList = new Color[26];
    public static String[] citiesList = new String[26];
    public static HashMap<Integer, ArrayList<Integer>> adjacencyList;

    public static HashMap<Integer, ArrayList<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public static void loadAdjacencyList() {/*
        adjacencyList = new HashMap<>();
        ArrayList<Integer> buffer = new ArrayList<>();
        buffer.add(HAWAI);
        buffer.add(ALASKA);
        buffer.add(AL_BUHEIRA);
        buffer.add(VERMONT);
        buffer.add(AL_QALUOBIYA);
        adjacencyList.put(AL_GHARBEYA, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_SHARQIYA);
        buffer.add(AL_QAHERA);
        buffer.add(AL_SUAIS);
        buffer.add(SHMAL_SINAA);
        buffer.add(PORT_SAID);
        adjacencyList.put(AL_ISMAELIA, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_GHARBEYA);
        buffer.add(AL_BUHEIRA);
        buffer.add(AL_QALUOBIYA);
        buffer.add(AL_GIZA);
        buffer.add(AL_DAKAHLIYA);
        adjacencyList.put(AL_MONOFIYA, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_GIZA);
        buffer.add(AL_SUAIS);
        buffer.add(AL_ISMAELIA);
        buffer.add(AL_SHARQIYA);
        buffer.add(AL_QALUOBIYA);
        adjacencyList.put(AL_QAHERA, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_QAHERA);
        buffer.add(AL_GIZA);
        buffer.add(AL_MONOFIYA);
        buffer.add(AL_GHARBEYA);
        buffer.add(AL_DAKAHLIYA);
        buffer.add(AL_SHARQIYA);
        adjacencyList.put(AL_QALUOBIYA, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_QAHERA);
        buffer.add(AL_QALUOBIYA);
        buffer.add(AL_DAKAHLIYA);
        buffer.add(AL_ISMAELIA);
        buffer.add(PORT_SAID);
        adjacencyList.put(AL_SHARQIYA, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(AL_GIZA);
        buffer.add(AL_QAHERA);
        buffer.add(AL_ISMAELIA);
        buffer.add(SHMAL_SINAA);
        buffer.add(JANUB_SINAA);
        adjacencyList.put(AL_SUAIS, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_SHARQIYA);
        buffer.add(AL_QALUOBIYA);
        buffer.add(AL_GHARBEYA);
        buffer.add(KAFR_EL_SHIEKH);
        buffer.add(DUMYAT);
        buffer.add(PORT_SAID);
        adjacencyList.put(AL_DAKAHLIYA, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_DAKAHLIYA);
        buffer.add(AL_SHARQIYA);
        buffer.add(AL_ISMAELIA);
        buffer.add(SHMAL_SINAA);
        adjacencyList.put(PORT_SAID, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_DAKAHLIYA);
        adjacencyList.put(DUMYAT, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_ISKINDERIA);
        buffer.add(AL_BUHEIRA);
        buffer.add(AL_GIZA);
        buffer.add(AL_WADI_AL_JADID);
        adjacencyList.put(MATROUH, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_ISKINDERIA);
        buffer.add(MATROUH);
        buffer.add(AL_GIZA);
        buffer.add(AL_MONOFIYA);
        buffer.add(AL_GHARBEYA);
        buffer.add(KAFR_EL_SHIEKH);
        adjacencyList.put(AL_BUHEIRA, buffer);
        buffer = new ArrayList<>();
        buffer.add(BANI_SUAIF);
        buffer.add(AL_GIZA);
        adjacencyList.put(AL_FAYOUM, buffer);
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
        adjacencyList.put(AL_GIZA, buffer);
        buffer = new ArrayList<>();
        buffer.add(BANI_SUAIF);
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(ASYOUT);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(AL_GIZA);
        adjacencyList.put(AL_MINIA, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_FAYOUM);
        buffer.add(AL_GIZA);
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(AL_MINIA);
        adjacencyList.put(BANI_SUAIF, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_BUHEIRA);
        buffer.add(AL_GHARBEYA);
        buffer.add(AL_DAKAHLIYA);
        adjacencyList.put(KAFR_EL_SHIEKH, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(QINA);
        buffer.add(AL_WADI_AL_JADID);
        adjacencyList.put(ASWAN, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_BAHR_AL_AHMAR);
        buffer.add(AL_MINIA);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(SUHAJ);
        adjacencyList.put(ASYOUT, buffer);
        buffer = new ArrayList<>();
        buffer.add(MATROUH);
        buffer.add(AL_GIZA);
        buffer.add(AL_MINIA);
        buffer.add(ASYOUT);
        buffer.add(SUHAJ);
        buffer.add(QINA);
        buffer.add(ASWAN);
        adjacencyList.put(AL_WADI_AL_JADID, buffer);
        buffer = new ArrayList<>();
        buffer.add(SUHAJ);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(ASWAN);
        buffer.add(AL_BAHR_AL_AHMAR);
        adjacencyList.put(QINA, buffer);
        buffer = new ArrayList<>();
        buffer.add(ASYOUT);
        buffer.add(AL_WADI_AL_JADID);
        buffer.add(QINA);
        buffer.add(AL_BAHR_AL_AHMAR);
        adjacencyList.put(SUHAJ, buffer);
        buffer = new ArrayList<>();
        buffer.add(AL_SUAIS);
        buffer.add(AL_GIZA);
        buffer.add(BANI_SUAIF);
        buffer.add(AL_MINIA);
        buffer.add(ASYOUT);
        buffer.add(SUHAJ);
        buffer.add(QINA);
        buffer.add(ASWAN);
        adjacencyList.put(AL_BAHR_AL_AHMAR, buffer);
        buffer = new ArrayList<>();
        buffer.add(SHMAL_SINAA);
        buffer.add(AL_SUAIS);
        adjacencyList.put(JANUB_SINAA, buffer);
        buffer = new ArrayList<>();
        buffer.add(JANUB_SINAA);
        buffer.add(AL_ISMAELIA);
        buffer.add(AL_SUAIS);
        buffer.add(PORT_SAID);
        adjacencyList.put(SHMAL_SINAA, buffer);*/
    }


    public static void loadColourList() {
        citiesColourList[HAWAI] = Color.valueOf("#41ae76");
        citiesColourList[ALASKA] = Color.valueOf("#238b45");
        citiesColourList[FLORIDA] = Color.valueOf("#006d2c");
        citiesColourList[NEW_HAMPHSIRE] = Color.valueOf("#00441b");
        citiesColourList[VERMONT] = Color.valueOf("#8c6bb1");
        citiesColourList[MAINE] = Color.valueOf("#88419d");
        citiesColourList[RHODE_ISLNAD] = Color.valueOf("#810f7c");
        citiesColourList[NEW_YORK] = Color.valueOf("#4d004b");
        citiesColourList[PENNSYLVANIA] = Color.valueOf("#4eb3d3");
        //NEW_JERSEY,DELWARE,MARYLAND,VIRGINIA,OHIO,INDIANA,ILLINOIS,CONNECTICUT,NORTH_CAROLINA,DISTRICT_OF_COLUMBIA,DISTRICT_OF_COLUMBIA
        //MASSACHUSETTS,TENNESSEE,ARKANSAS,MISSOURI,GEORGIA,SOUTH_CAROLINA,KENTUCKY
        citiesColourList[NEW_JERSEY] = Color.valueOf("#2b8cbe");
        citiesColourList[DELWARE] = Color.valueOf("#0868ac");
        citiesColourList[MARYLAND] = Color.valueOf("#084081");
        citiesColourList[VIRGINIA] = Color.valueOf("#ef6548");
        citiesColourList[OHIO] = Color.valueOf("#b30000");
        citiesColourList[INDIANA] = Color.valueOf("#7f0000");
        citiesColourList[ILLINOIS] = Color.valueOf("#3690c0");
        citiesColourList[CONNECTICUT] = Color.valueOf("#0570b0");
        citiesColourList[NORTH_CAROLINA] = Color.valueOf("#045a8d");
        citiesColourList[DISTRICT_OF_COLUMBIA] = Color.valueOf("#023858");
        citiesColourList[MASSACHUSETTS] = Color.valueOf("#41ab5d");
        citiesColourList[TENNESSEE] = Color.valueOf("#238443");
        citiesColourList[ARKANSAS] = Color.valueOf("#006837");
        citiesColourList[MISSOURI] = Color.valueOf("#004529");
        citiesColourList[GEORGIA] = Color.valueOf("#fc4e2a");
        citiesColourList[SOUTH_CAROLINA] = Color.valueOf("#d7301f");
        citiesColourList[KENTUCKY] = Color.valueOf("#e31a1c");

        ////ALABAMA,LOUISIANA,MISSISSIPI,LOWA,MINNESOTA,OKLAHOMA,TEXAS,NEW_MEXICO,KANSAS,NEBRASKA,SOUTH_DAKOTA,NOURTH_DAKOTA
        citiesColourList[ALABAMA] = Color.valueOf("#e31a1c");
        citiesColourList[LOUISIANA] = Color.valueOf("#e31a1c");
        citiesColourList[MISSISSIPI] = Color.valueOf("#e31a1c");
        citiesColourList[LOWA] = Color.valueOf("#e31a1c");
        citiesColourList[MINNESOTA] = Color.valueOf("#e31a1c");
        citiesColourList[OKLAHOMA] = Color.valueOf("#e31a1c");
        citiesColourList[TEXAS] = Color.valueOf("#e31a1c");
        citiesColourList[NEW_MEXICO] = Color.valueOf("#e31a1c");
        citiesColourList[KANSAS] = Color.valueOf("#e31a1c");
        citiesColourList[NEBRASKA] = Color.valueOf("#e31a1c");
        citiesColourList[SOUTH_DAKOTA] = Color.valueOf("#e31a1c");
        citiesColourList[NOURTH_DAKOTA] = Color.valueOf("#e31a1c");
        citiesColourList[WYOMING] = Color.valueOf("#e31a1c");
        //WYOMING,COLORADO,UTAH,ARIZONA,NEVADA ,OREGON,WASHINGTON,CALIFORNIA,MICHIGAN,LDAHO,GUAM,
        // //VIGIN_ISLAND,PUERTO_RICO,NORTHEN_MARIANA,AMERICAN_SAMAO
        citiesColourList[COLORADO] = Color.valueOf("#e31a1c");
        citiesColourList[UTAH] = Color.valueOf("#e31a1c");
        citiesColourList[ARIZONA] = Color.valueOf("#e31a1c");
        citiesColourList[NEVADA] = Color.valueOf("#e31a1c");
        citiesColourList[OREGON] = Color.valueOf("#e31a1c");
        citiesColourList[WASHINGTON] = Color.valueOf("#e31a1c");
        citiesColourList[CALIFORNIA] = Color.valueOf("#e31a1c");
        citiesColourList[MICHIGAN] = Color.valueOf("#e31a1c");
        citiesColourList[LDAHO] = Color.valueOf("#e31a1c");
        citiesColourList[GUAM] = Color.valueOf("#e31a1c");
        citiesColourList[VIGIN_ISLAND] = Color.valueOf("#e31a1c");
        citiesColourList[PUERTO_RICO] = Color.valueOf("#e31a1c");
        citiesColourList[NORTHEN_MARIANA] = Color.valueOf("#e31a1c");
        citiesColourList[AMERICAN_SAMAO] = Color.valueOf("#e31a1c");
        // citiesColourList[LUXOR] = Color.valueOf("#bd0026");
    }

    public static void loadCitiesList() {
        citiesList[HAWAI] = "HAWAI";
        citiesList[ALASKA] = "ALASKA";
        citiesList[FLORIDA] = "FLORIDA";
        citiesList[NEW_HAMPHSIRE] = "NEW_HAMPHSIRE";
        citiesList[VERMONT] = "VERMONT";
        citiesList[MAINE] = "MAINE";
        citiesList[RHODE_ISLNAD] = "RHODE_ISLNAD";
        citiesList[NEW_YORK] = "NEW_YORK";
        citiesList[PENNSYLVANIA] = "PENNSYLVANIA";
        citiesList[NEW_JERSEY] = "NEW_JERSEY";
        citiesList[DELWARE] = "DELWARE";
        citiesList[MARYLAND] = "MARYLAND";
        citiesList[VIRGINIA] = "VIRGINIA";
        citiesList[OHIO] = "OHIO";
        citiesList[INDIANA] = "INDIANA";
        citiesList[ILLINOIS] = "ILLINOIS";
        citiesList[CONNECTICUT] = "CONNECTICUT";
        citiesList[NORTH_CAROLINA] = "NORTH_CAROLINA";
        citiesList[DISTRICT_OF_COLUMBIA] = "DISTRICT_OF_COLUMBIA";
        citiesList[MASSACHUSETTS] = "MASSACHUSETTS";
        citiesList[TENNESSEE] = "TENNESSEE";
        citiesList[ARKANSAS] = "ARKANSAS";
        citiesList[MISSOURI] = "MISSOURI";
        citiesList[GEORGIA] = "GEORGIA";
        citiesList[SOUTH_CAROLINA] = "SOUTH_CAROLINA";
        citiesList[KENTUCKY] = "KENTUCKY";
        citiesList[LOUISIANA] = "LOUISIANA";
        citiesList[ALABAMA] = "ALABAMA";
        citiesList[MISSISSIPI] = "MISSISSIPI";
        citiesList[LOWA] = "LOWA";
        citiesList[MINNESOTA] = "MINNESOTA";
        citiesList[OKLAHOMA] = "OKLAHOMA";
        citiesList[TEXAS] = "TEXAS";
        citiesList[NEW_MEXICO] = "NEW_MEXICO";
        citiesList[KANSAS] = "KANSAS";
        citiesList[NEBRASKA] = "NEBRASKA";
        citiesList[SOUTH_DAKOTA] = "SOUTH_DAKOTA";
        citiesList[NOURTH_DAKOTA] = "NOURTH_DAKOTA";

        citiesList[WYOMING] = "WYOMING";
        citiesList[COLORADO] = "COLORADO";
        citiesList[UTAH] = "UTAH";
        citiesList[ARIZONA] = "ARIZONA";
        citiesList[NEVADA] = "NEVADA";
        citiesList[OREGON] = "OREGON";
        citiesList[WASHINGTON] = "WASHINGTON";
        citiesList[CALIFORNIA] = "CALIFORNIA";
        citiesList[MICHIGAN] = "MICHIGAN";
        citiesList[LDAHO] = "LDAHO";
        citiesList[GUAM] = "GUAM";
        citiesList[VIGIN_ISLAND] = "VIGIN_ISLAND";
        citiesList[PUERTO_RICO] = "PUERTO_RICO";
        citiesList[NORTHEN_MARIANA] = "NORTHEN_MARIANA";
        citiesList[AMERICAN_SAMAO] = "AMERICAN_SAMAO";
        //NEVADA,WASHINGTON,
//,,,,,,,
    }

    public static String getCityName(Color color) {
        for (int i = 0; i < 53; i++) {
            if (citiesColourList[i].equals(color))
                return citiesList[i];
        }
        return null;
    }

    public static int getCity(Color color) {
        for (int i = 0; i < 53; i++) {
            if (citiesColourList[i].equals(color))
                return i;
        }
        return Integer.MAX_VALUE;
    }

    public static Boolean isAcity(Color color) {
        for (Color color1 : citiesColourList) {
            if (color1.equals(color)) {
                return true;
            }
        }
        return false;
    }


}
