package com.example.admin.nzsep;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;



public class DriveActivity extends AppCompatActivity {

    Car car=new Car();

    public static int counter_value=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);


        Button Route_aendern=(Button)findViewById(R.id.Route_change);
        final TextView Zustand=(TextView)findViewById(R.id.Zustand_ID);
        TextView Ziel_ausgabe=(TextView)findViewById(R.id.Ziel_ID);
         Button Hauptmenue=(Button)findViewById(R.id.hauptmenue);
         final TextView Tankstatus=(TextView)findViewById(R.id.Tanken_ID);
        final RadioButton radio_start=(RadioButton)findViewById(R.id.radioButton1);
        final RadioButton radio_stop=(RadioButton)findViewById(R.id.radioButton2);
        Button plus=(Button)findViewById(R.id.buttonPLUS);
        Button minus=(Button)findViewById(R.id.buttonMINUS);
        final TextView klima_ausgabe=(TextView)findViewById(R.id.Ausgabe_klima);
        final TextView counter=(TextView)findViewById(R.id.counter_ID);
        final TextView Info=(TextView)findViewById(R.id.Infotext_ID);

//____________________________________________________________
///neu
        final String h_text=Hauptmenue.getText().toString();



        String gebeText=Hauptmenue.getText().toString();  //ueberprufe ob enlisch unten
//// neu
        Ziel_ausgabe.setText(car.getZiel());

         radio_stop.setChecked(true);                     //Default Stopp zu Beginn

        if(h_text.equals("HauptMenü")) {
            Zustand.setText("Auto steht");                   //
        }
        else{Zustand.setText("Car stands");}

        String tank=Float.toString(car.getTank());     //Tankstand zu Beginn
          Tankstatus.setText(tank+" %");                   //


       

        String klima=Float.toString(car.getKlima());        //Default Wert zu Beginn

        klima_ausgabe.setText(klima+" °C");

       // Button mybutton_plus=(Button)findViewById(R.id.button_plus);
        plus.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){






                car.setKlima(car.getKlima()+0.5F);        //F steht für float sonst double

                if (car.getKlima()<28.5){


                    Float ergebnis = car.getKlima();
                    klima_ausgabe.setText(String.valueOf(ergebnis)+" °C");
                }
                else{

                    car.setKlima(28);

                }
                Speichern();

            }

        });
/////////////////////


        ////Minus button

        minus.setOnClickListener(new View.OnClickListener(){

            public void onClick(View x) {





                car.setKlima(car.getKlima()-0.5F);     //F steht für float sonst double

                if (car.getKlima()>17.5) {


                    Float ergebnis = car.getKlima();
                    klima_ausgabe.setText(String.valueOf(ergebnis)+" °C");
                }
                else{

                    car.setKlima(18);
                }
                Speichern();
            }

        });






        /////////////////klima



        if (radio_start.isChecked()==true){
            radio_stop.setChecked(false);

        }

        if (radio_stop.isChecked()==true){
           radio_start.setChecked(false);
        }


        ////////////////
        //setonclick Werte zurückgeben
        Hauptmenue.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("bekommeTank",car.getTank());
                intent.putExtra("bekommeKlima",car.getKlima());
                intent.putExtra("bekommeZiel",car.getZiel());
                startActivity(intent);
                Speichern();

            }
        });



        //setonclick
        radio_start.setOnClickListener( new View.OnClickListener() {

           @Override
            public void onClick(View v) {

               if(h_text.equals("HauptMenü")) {
                   Zustand.setText("Auto fährt");                   //
               }
               else{Zustand.setText("Car drives");}
           radio_stop.setChecked(false);
Speichern();
               //timer
        new CountDownTimer(100000000,100){

            public void onTick(long millisecondsuntilFinished){
                 counter.setText(String.valueOf(counter_value));
                if(radio_stop.isChecked()==true){
                    onFinish();
                }
                else{

               ///////tr

                    car.setTank(car.getTank()-0.5F);


                 /////////tr


                    if(car.getTank()<0){


                        if(h_text.equals("HauptMenü")) {
                            Info.setText("Bitte Tanken !");                   //
                        }
                        else{Info.setText("Please fuel the Tank !");}

                        onFinish();
                        radio_start.setChecked(false);
                        radio_stop.setChecked(true);
                        if(h_text.equals("HauptMenü")) {
                            Zustand.setText("Auto steht");                   //
                        }
                        else{Zustand.setText("Car stands");}
                        car.setTank(0);

                    }





                    if(car.getTank()==0){
                        if(h_text.equals("HauptMenü")) {
                            Info.setText("Bitte Tanken !");                   //
                        }
                        else{Info.setText("Please fuel the Tank !");}
                        onFinish();
                        radio_start.setChecked(false);
                        radio_stop.setChecked(true);

                        if(h_text.equals("HauptMenü")) {
                            Zustand.setText("Auto steht");                   //
                        }
                        else{Zustand.setText("Car stands");}
                    }

                    String tanks=Float.toString(car.getTank());
                    Tankstatus.setText(tanks+" %");


                   if(car.getTank()!=0) {

                       counter_value++;
                   }

                }
           Speichern(); }

            public void onFinish(){

            }

}.start();



               //timer


            }
       });


        //setonclick
        radio_stop.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(h_text.equals("HauptMenü")) {
                    Zustand.setText("Auto steht");                   //
                }
                else{Zustand.setText("Car stands");}
               radio_start.setChecked(false);
                Speichern();

            }
        });





        //setonclick
        Route_aendern.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(),RoutingActivity.class);
                intent.putExtra("change","");
                startActivity(intent);

Speichern();
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
