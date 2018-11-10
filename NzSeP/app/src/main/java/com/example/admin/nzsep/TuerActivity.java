package com.example.admin.nzsep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;
/**
 * Created by admin on 27.04.17.
 */

public class TuerActivity extends Activity {
    Car car= new Car();                //Objekt von Klasse Car



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuer_layout);
        final CheckBox alldoors=(CheckBox)findViewById(R.id.AllDoors);
       final CheckBox co_driver=(CheckBox)findViewById(R.id.Co_Driver_door);
       final   CheckBox left_behind=(CheckBox)findViewById(R.id.Left_behindD);
       final CheckBox right_behind=(CheckBox)findViewById(R.id.Right_behindD);
       final CheckBox driverdoor=(CheckBox)findViewById(R.id.DriverDoor);
        final CheckBox Kofferraum=(CheckBox)findViewById(R.id.Kofferaum_ID);

///einzelne Checkboxen beim Start




        if(car.getZustand_Tür_Beifahrer()==true){                  //Co Driver

            co_driver.setChecked(true);
        }
        else{
            co_driver.setChecked(false);
        }



      if(car.getZustand_Tür_LinksHinten()==true){                 //Left Behind
          left_behind.setChecked(true);
      }
      else{

          left_behind.setChecked(false);
      }


        if(car.getZustand_Tür_RechtsHinten()==true){                 //Right Behind
            right_behind.setChecked(true);
        }
        else{

            right_behind.setChecked(false);
        }


        if(car.getZustand_Tür_Fahrer()==true){                 //Driver Door
            driverdoor.setChecked(true);
        }
        else{

            driverdoor.setChecked(false);
        }

        if(car.getZustand_Kofferraum()==true){                 //Kofferraum
            Kofferraum.setChecked(true);
        }
        else{

            Kofferraum.setChecked(false);
        }

/////////////////////////////////////////////////////////////////////////////// einzelne Checkboxen  beim Click
        co_driver.setOnClickListener(new View.OnClickListener() {  //Co driver
            @Override
            public void onClick(View v) {


                if(co_driver.isChecked()){

                    co_driver.setChecked(true);

                    car.setZustand_Tür_Beifahrer(true);
                }
                else{
                    co_driver.setChecked(false);

                    car.setZustand_Tür_Beifahrer(false);
                    alldoors.setChecked(false);
                }






                if((car.getZustand_Tür_Beifahrer()==true)&&(car.getZustand_Tür_LinksHinten()==true)&&
                        (car.getZustand_Tür_RechtsHinten()==true)&&(car.getZustand_Tür_Fahrer()==true)
                        &&(car.getZustand_Kofferraum()==true)){

                    alldoors.setChecked(true);


                    Intent intent= new Intent(getApplicationContext(),StartActivity.class);
                    intent.putExtra("data",alldoors.isChecked());
                    startActivity(intent);


                }



            }
        });

        /////////////testejetz



        Kofferraum.setOnClickListener(new View.OnClickListener() {  //Co driver
            @Override
            public void onClick(View v) {


                if(Kofferraum.isChecked()){

                    Kofferraum.setChecked(true);

                    car.setZustand_Kofferraum(true);
                }
                else{
                    Kofferraum.setChecked(false);

                    car.setZustand_Kofferraum(false);
                    alldoors.setChecked(false);
                }






                if((car.getZustand_Tür_Beifahrer()==true)&&(car.getZustand_Tür_LinksHinten()==true)&&
                        (car.getZustand_Tür_RechtsHinten()==true)&&(car.getZustand_Tür_Fahrer()==true)
                        &&(car.getZustand_Kofferraum()==true)){

                    alldoors.setChecked(true);


                    Intent intent= new Intent(getApplicationContext(),StartActivity.class);
                    intent.putExtra("data",alldoors.isChecked());
                    startActivity(intent);


                }



            }
        });



        ////////////testejetz



//2/


        left_behind.setOnClickListener(new View.OnClickListener() {  //Left Behind
            @Override
            public void onClick(View v) {


                if(left_behind.isChecked()){

                    left_behind.setChecked(true);
                    car.setZustand_Tür_LinksHinten(true);

                }
                else{
                    left_behind.setChecked(false);
                    car.setZustand_Tür_LinksHinten(false);
                    alldoors.setChecked(false);

                }


                if((car.getZustand_Tür_Beifahrer()==true)&&(car.getZustand_Tür_LinksHinten()==true)&&
                        (car.getZustand_Tür_RechtsHinten()==true)&&(car.getZustand_Tür_Fahrer()==true)&&
                        (car.getZustand_Kofferraum()==true)){

                    alldoors.setChecked(true);

                    Intent intent= new Intent(getApplicationContext(),StartActivity.class);
                    intent.putExtra("data",alldoors.isChecked());
                    startActivity(intent);

                }


            }
        });

//3/



        right_behind.setOnClickListener(new View.OnClickListener() {  //Right Behind
            @Override
            public void onClick(View v) {


                if(right_behind.isChecked()){

                    right_behind.setChecked(true);

                    car.setZustand_Tür_RechtsHinten(true);
                }
                else{
                    right_behind.setChecked(false);
                    car.setZustand_Tür_RechtsHinten(false);
                    alldoors.setChecked(false);

                }


                if((car.getZustand_Tür_Beifahrer()==true)&&(car.getZustand_Tür_LinksHinten()==true)&&
                        (car.getZustand_Tür_RechtsHinten()==true)&&(car.getZustand_Tür_Fahrer()==true)
                        &&(car.getZustand_Kofferraum()==true)){

                    alldoors.setChecked(true);


                    Intent intent= new Intent(getApplicationContext(),StartActivity.class);
                    intent.putExtra("data",alldoors.isChecked());
                    startActivity(intent);

                }


            }
        });


//4/


        driverdoor.setOnClickListener(new View.OnClickListener() {  //Driver Door
            @Override
            public void onClick(View v) {


                if(driverdoor.isChecked()){

                    driverdoor.setChecked(true);

                    car.setZustand_Tür_Fahrer(true);
                }
                else{
                    driverdoor.setChecked(false);

                    car.setZustand_Tür_Fahrer(false);
                    alldoors.setChecked(false);
                }



                if((car.getZustand_Tür_Beifahrer()==true)&&(car.getZustand_Tür_LinksHinten()==true)&&
                        (car.getZustand_Tür_RechtsHinten()==true)&&(car.getZustand_Tür_Fahrer()==true)
                        &&(car.getZustand_Kofferraum()==true)){

                    alldoors.setChecked(true);

                    Intent intent= new Intent(getApplicationContext(),StartActivity.class);
                    intent.putExtra("data",alldoors.isChecked());
                    startActivity(intent);


                }



            }
        });





///////////////// einzelne Checkboxen bis hier

        if((car.getZustand_Tür_Beifahrer()==true)&&(car.getZustand_Tür_LinksHinten()==true)&&
                (car.getZustand_Tür_RechtsHinten()==true)&&(car.getZustand_Tür_Fahrer()==true)&&
                (car.getZustand_Kofferraum()==true)){

            alldoors.setChecked(true);
            co_driver.setChecked(true);
            left_behind.setChecked(true);
            right_behind.setChecked(true);
            driverdoor.setChecked(true);
            Kofferraum.setChecked(true);


            Intent intent= new Intent(getApplicationContext(),StartActivity.class);
            intent.putExtra("data",alldoors.isChecked());
            startActivity(intent);


        }





        alldoors.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){


                if((co_driver.isChecked())&&(left_behind.isChecked())&&(right_behind.isChecked())
                        &&(driverdoor.isChecked())&&(Kofferraum.isChecked())){


                    co_driver.setChecked(false);
                    left_behind.setChecked(false);
                    right_behind.setChecked(false);
                    driverdoor.setChecked(false);
                    Kofferraum.setChecked(false);

                    car.setZustand_Tür_Beifahrer(false);
                    car.setZustand_Tür_LinksHinten(false);
                    car.setZustand_Tür_RechtsHinten(false);
                    car.setZustand_Tür_Fahrer(false);
                    car.setZustand_Kofferraum(false);

//



                }
                else {

                    co_driver.setChecked(true);
                    left_behind.setChecked(true);
                    right_behind.setChecked(true);
                    driverdoor.setChecked(true);
                    Kofferraum.setChecked(true);


                    car.setZustand_Tür_Beifahrer(true);
                    car.setZustand_Tür_LinksHinten(true);
                    car.setZustand_Tür_RechtsHinten(true);
                    car.setZustand_Tür_Fahrer(true);
                    car.setZustand_Kofferraum(true);
//



                  Intent intent= new Intent(getApplicationContext(),StartActivity.class);
                    intent.putExtra("data",alldoors.isChecked());
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