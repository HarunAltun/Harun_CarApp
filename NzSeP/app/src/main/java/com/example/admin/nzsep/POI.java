package com.example.admin.nzsep;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by admin on 08.05.17.
 */

public class POI {  //Beginn of Class
        private int capacity;
        private Drawable d;
        private String type;
        private String name;
        private String adress;
        private double lat;
        private double lon;
        private String icon;


    public int getCapacity(){return capacity;}
    public void setCapacity(int capacity){this.capacity=capacity;}

    public Drawable getDrawable(){return d;}
    public void setDrawable(Drawable d){this.d=d; }

public String getType(){             //Type
    return type;
}

public void setType(String type){
    this.type=type;
}

 public String getName(){           //Name
        return name;
    }

 public void setName(String name){
        this.name=name;
    }

    public String getAdress(){    //Adress
        return adress;
    }

    public void setAdress(String adress){
        this.adress=adress;
    }

    public void setIcon(String icon){this.icon=icon;}
    public String getIcon(){return icon;}

    public double getLat(){      //Lat

        return lat;

    }


    public void setLat( double lat){

        this.lat=lat;

    }


    public double getLon(){       //Lon
        return lon;
    }

public void setLon(double lon){
    this.lon=lon;
}




//@Override       //überschreiben um zu überprüfen ob eingelesen wurde
//    public String toString() {
//    String leer ="\n";
//    return name+leer+adress;
//}







}   //End of Class




