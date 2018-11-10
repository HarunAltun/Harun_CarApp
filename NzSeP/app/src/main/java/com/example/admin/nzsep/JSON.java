package com.example.admin.nzsep;

import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by admin on 31.05.17.
 */

public class JSON {
    static ArrayList<POI> POI_liste = new ArrayList<>();
    String JsonText="";

    static int cnt=0;

    public  void GetJason(){

        StrictMode.ThreadPolicy policy = new StrictMode. ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        try {
            URL url = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/poi.txt");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(con.getInputStream());
            BufferedReader r = new BufferedReader(in);

            StringBuilder response = new StringBuilder();
            String line;
            try {

                while ((line = r.readLine()) != null){
                    response.append(line);

                }
            }

            catch (Exception ex) {
                Log.e("SERVER COM", ex.toString());
            }

            JsonText = response.toString();
            JSONArray jsonlist= new JSONArray(JsonText);


            for (int i=0;i<jsonlist.length();i++){

                POI poi_obj=new POI();

                JSONObject jsonObject=jsonlist.getJSONObject(i);


                poi_obj.setType(jsonObject.getString("type"));
                poi_obj.setName(jsonObject.getString("name"));
                poi_obj.setAdress(jsonObject.getString("address"));
                poi_obj.setLat(jsonObject.getDouble("lat"));
                poi_obj.setLon(jsonObject.getDouble("lon"));

                 if(jsonObject.has("capacity")){
                  poi_obj.setCapacity(jsonObject.getInt("capacity"));

                }

                if(jsonObject.has("icon")) {

/////Schleife



                    switch(cnt) {

                        case 0:
                        try {
                            URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/bahnhof.jpg");
                            HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                            Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                            poi_obj.setDrawable(d);

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                            cnt++;
                        break;

                        case 1:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/h_da.jpg");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;



                        case 2:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/hoffart.jpg");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;

                        case 3:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/centralstation.jpg");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;



                        case 4:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/waldspirale.jpg");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;

                        case 5:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/mathildenhoehe.jpg");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;



                        case 6:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/westsidetheatre.jpeg");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;

                        case 7:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/jagdhofkeller.jpg");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;



                        case 8:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/halbneuntheater.jpg");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;



                        case 9:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/kikeriki.gif");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;

                        case 10:
                            try {
                                URL internet = new URL("https://www.fbi.h-da.de/fileadmin/personal/h.wiedling/daten/staatstheater.gif");
                                HttpURLConnection con2 = (HttpURLConnection) internet.openConnection();
                                Drawable d = Drawable.createFromStream(con2.getInputStream(), null);
                                poi_obj.setDrawable(d);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            cnt++;
                            break;







                    }
    ///Schleife
                }


                POI_liste.add(poi_obj);

            }




        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }







}
