package com.example.admin.nzsep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by admin on 27.04.17.
 */

public class StartActivity extends Activity {
    Car car= new Car();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);

        Button start_button=(Button)findViewById(R.id.Startbutton_ID);
        final CheckBox Tür_status = (CheckBox) findViewById(R.id.Tuer_ID);
        final CheckBox Tanken_status = (CheckBox) findViewById(R.id.Tank_Id);
        final CheckBox Route_status=(CheckBox)findViewById(R.id.Route_ID);

        final String R_text=Route_status.getText().toString();


        //setonclick
        Tür_status.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               if (Tür_status.isChecked()==true){

                   Tür_status.setChecked(false);
               }

                else{Tür_status.setChecked(true);}
            }
        });

//setonclick
        Tanken_status.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (Tanken_status.isChecked()==true){

                    Tanken_status.setChecked(false);
                }

                else{Tanken_status.setChecked(true);}
            }
        });


        //setonclick
        Route_status.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (Route_status.isChecked()==true){

                    Route_status.setChecked(false);
                }

                else{Route_status.setChecked(true);}
            }
        });

////////fehleingaben abfangen



        //Türen Bereit
        if((car.getZustand_Tür_Beifahrer()==true)&&(car.getZustand_Tür_LinksHinten()==true)&&
                (car.getZustand_Tür_RechtsHinten()==true)&&(car.getZustand_Tür_Fahrer()==true)
                &&(car.getZustand_Kofferraum()==true)){
            Tür_status.setChecked(true);

        }


        if (getIntent().hasExtra("data") == true){

           Boolean   check1 = getIntent().getExtras().getBoolean("data");



        if (check1 == true) {
            Tür_status.setChecked(true);

            car.setZustand_Tür_Fahrer(true);
            car.setZustand_Tür_Beifahrer(true);
            car.setZustand_Tür_RechtsHinten(true);
            car.setZustand_Tür_LinksHinten(true);
            car.setZustand_Kofferraum(true);


        }


      }

                                                                       //Tanken bereit



         if(car.getTank()>=10){                 //Minimum 10 % Muss da sein, um zu starten
             Tanken_status.setChecked(true);

        }

//        if (car.getTank()==100){
//
//            Tanken_status.setChecked(true);
//        }


        if (getIntent().hasExtra("key") == true){

                Tanken_status.setChecked(true);
                 car.setTank(100);


        }
//hier neue checkbox (Route)


      if(car.getZiel()!=""){
          Route_status.setChecked(true);
      }


        if (getIntent().hasExtra("Route") == true) {


        }
 ////

        final TextView control_active =(TextView)findViewById(R.id.Aktiv_ID);

        if (Tür_status.isChecked()==true&&Tanken_status.isChecked()==true&&Route_status.isChecked()==true){
            if(R_text.equals("Route Bereit")) {
                control_active.setText("AKTIV");
                //
            }
            else{ control_active.setText("ACTIVE"); }

        }

       else if(R_text.equals("Route Bereit")) {
            control_active.setText("INAKTIV");
            //
        }
        else{ control_active.setText("INACTIVE"); }



if((control_active.getText()=="AKTIV")||(control_active.getText()=="ACTIVE")){

    //setonclick
start_button.setOnClickListener( new View.OnClickListener() {

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), DriveActivity.class);
        intent.putExtra("drive",control_active.getText());
        startActivity(intent);

        //hier
    }
});





}


Speichern();


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