package com.example.admin.nzsep;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Car car=new Car();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Laden();

        Button Türverriegeln=(Button)findViewById(R.id.tuer_button);
        Button Tankanzeige=(Button)findViewById(R.id.tank_button);
        Button Klimaanlage=(Button)findViewById(R.id.klima_button);
        Button RouteEinstellung=(Button)findViewById(R.id.standort_button);
        Button Fahrzeugstart=(Button)findViewById(R.id.fahrstart_button);



        if (getIntent().hasExtra("bekommeTank") == true) {

            Float bekommeTank=getIntent().getExtras().getFloat("bekommeTank");

                car.setTank(bekommeTank);

        }


        if (getIntent().hasExtra("bekommeKlima") == true) {

            Float bekommeKlima=getIntent().getExtras().getFloat("bekommeKlima");

            car.setKlima(bekommeKlima);

        }



        if (getIntent().hasExtra("bekommeZiel") == true) {

            String bekommeZiel=getIntent().getExtras().getString("bekommeZiel");

            car.setZiel(bekommeZiel);

        }


        //setonclick
        Türverriegeln.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TuerActivity.class);
                startActivity(intent);


            }
        });

        //setonclick
        Tankanzeige.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TankActivity.class);
                startActivity(intent);


            }
        });


        //setonclick
        Klimaanlage.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), KlimaActivity.class);
                startActivity(intent);


            }
        });



        //setonclick
        RouteEinstellung.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RoutingActivity.class);
                startActivity(intent);


            }
        });



        //setonclick
        Fahrzeugstart.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),StartActivity.class);
                startActivity(intent);


            }
        });





Speichern();
    }


    //Load Data

    public void Laden() {



        SharedPreferences sharedPref = getSharedPreferences("Car_info", Context.MODE_PRIVATE);

        car.setZustand_Tür_Fahrer(sharedPref.getBoolean("Tür_Fahrer",car.getZustand_Tür_Fahrer()));
        car.setZustand_Tür_Beifahrer(sharedPref.getBoolean("Tür_Beifahrer",car.getZustand_Tür_Beifahrer()));
        car.setZustand_Tür_LinksHinten(sharedPref.getBoolean("Tür_hintenlinks",car.getZustand_Tür_LinksHinten()));
        car.setZustand_Tür_RechtsHinten(sharedPref.getBoolean("Tür_hintenrechts",car.getZustand_Tür_RechtsHinten()));
        car.setZustand_Kofferraum(sharedPref.getBoolean("Tür_Kofferraum",car.getZustand_Kofferraum()));
        car.setTank(sharedPref.getFloat("Tank",car.getTank()));
        car.setKlima(sharedPref.getFloat("Klima",car.getKlima()));
        car.setZiel(sharedPref.getString("Ziel",car.getZiel()));

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
