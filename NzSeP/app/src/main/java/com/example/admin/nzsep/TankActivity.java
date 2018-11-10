package com.example.admin.nzsep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by admin on 27.04.17.
 */

public class TankActivity extends Activity {


    Car car= new Car();

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tank_layout);

        final TextView Tankanzeige=(TextView)findViewById(R.id.Tank_box);


        String tank=Float.toString(car.getTank());        //Default Wert zu Beginn

        Tankanzeige.setText(tank+" %");

        ////Plus button
        ImageButton TankButton=(ImageButton) findViewById(R.id.imageButton);
        TankButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){






                TextView Tank_info = (TextView)findViewById(R.id.Tank_info);    //anzeige wenn Tank voll

                car.setTank(car.getTank()+5);
                //zahl=zahl+5;

                if(car.getTank()<101) {


                    Float ergebnis = car.getTank();
                    Tankanzeige.setText(String.valueOf(ergebnis)+" %");



                }

                else{

                    Tank_info.setText("Tank ist bereits voll");
                    car.setTank(100);

                    Intent intent=new Intent(getApplicationContext(),StartActivity.class);
                    intent.putExtra("key",Tankanzeige.getText().toString());
                    startActivity(intent);


                }
            }

        });



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