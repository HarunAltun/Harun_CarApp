package com.example.admin.nzsep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

import static com.example.admin.nzsep.R.id.parent;



public class RoutingActivity extends Activity {

    Car car=new Car();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routing);

        StrictMode.ThreadPolicy policy = new StrictMode. ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        JSON json=new JSON();


         json.GetJason();
        //ListAdapter JSAdapter= new ArrayAdapter<POI>(this,android.R.layout.simple_list_item_1,json.POI_liste);

        ListAdapter JSAdapter= new Adapter(this,json.POI_liste);     //Eigener Adapter

        ListView listView=(ListView) findViewById(R.id.listview_ID);

        listView.setAdapter(JSAdapter);
///////hier weitermachen


        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                       POI auswahl = (POI)(parent.getItemAtPosition(position)); //casten
String leer="\n";

                        car.setZiel(auswahl.getName()+leer+auswahl.getAdress()); //setze ZielAdresse

                          Toast.makeText(RoutingActivity.this,"->>> "+car.getZiel()+" <<<-",Toast.LENGTH_LONG).show();






                    }
                }


        );



        if (getIntent().hasExtra("change") == true) {




            listView.setOnItemClickListener(

                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                            POI auswahl = (POI)(parent.getItemAtPosition(position)); //casten
                            String leer="\n";

                            car.setZiel(auswahl.getName()+leer+auswahl.getAdress()); //setze ZielAdresse


                            Toast.makeText(RoutingActivity.this,"=== Route festgelegt ===",Toast.LENGTH_LONG).show();

                        Intent intent=new Intent(getApplicationContext(),DriveActivity.class);
                        startActivity(intent);



                        }
                    }


            );






        }

Speichern();

///////////
    }



    //Save Data
    public void Speichern(){

        SharedPreferences sharedPref=getSharedPreferences("Car_info", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putBoolean("Tür_Fahrer",car.getZustand_Tür_Fahrer());
        editor.putBoolean("Tür_Beifahrer",car.getZustand_Tür_Beifahrer());
        editor.putBoolean("Tür_hintenlinks",car.getZustand_Tür_LinksHinten());
        editor.putBoolean("Tür_hintenrechts",car.getZustand_Tür_RechtsHinten());
        editor.putBoolean("Tür_Kofferraum",car.getZustand_Kofferraum());
        editor.putFloat("Tank",car.getTank());
        editor.putFloat("Klima",car.getKlima());
        editor.putString("Ziel",car.getZiel());
        editor.apply();

    }
    //Save Data



}
