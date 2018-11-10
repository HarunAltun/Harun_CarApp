package com.example.admin.nzsep;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by admin on 27.04.17.
 */

public class KlimaActivity extends Activity {


    Car car= new Car();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.klima_layout);


        final TextView Gradanzeige=(TextView)findViewById(R.id.Grad_anzeige);
                                            ////Plus button

        String klima=Float.toString(car.getKlima());        //Default Wert zu Beginn

        Gradanzeige.setText(klima+" °C");

        Button mybutton_plus=(Button)findViewById(R.id.button_plus);
        mybutton_plus.setOnClickListener(new View.OnClickListener(){

           public void onClick(View v){






                   car.setKlima(car.getKlima()+0.5F);        //F steht für float sonst double

               if (car.getKlima()<28.5){


                   Float ergebnis = car.getKlima();
                   Gradanzeige.setText(String.valueOf(ergebnis)+" °C");
               }
               else{

                   car.setKlima(28);
               }

           }

        });
/////////////////////


                                               ////Minus button

        Button mybutton_minus=(Button)findViewById(R.id.button_minus);
        mybutton_minus.setOnClickListener(new View.OnClickListener(){

            public void onClick(View x) {




                car.setKlima(car.getKlima()-0.5F);     //F steht für float sonst double

                if (car.getKlima()>17.5) {


                Float ergebnis = car.getKlima();
                Gradanzeige.setText(String.valueOf(ergebnis)+" °C");
            }
                 else{

                    car.setKlima(18);
                }
            }

        });



Speichern();

 ///////////////

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
