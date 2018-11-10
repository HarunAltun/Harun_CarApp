package com.example.admin.nzsep;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by admin on 01.06.17.
 */

public class Adapter extends ArrayAdapter<POI>{

    private final Context context;
  private final ArrayList<POI>adr;

    public Adapter(@NonNull Context context, ArrayList<POI>A_List) {
                                                              //Konstruktor
           super(context, R.layout.list_layout,A_List);
           this.adr=A_List;
           this.context=context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
String leer="\n";

        LayoutInflater turkinflater =LayoutInflater.from(getContext());
       View customview = turkinflater.inflate(R.layout.list_layout,parent,false);

        TextView textview=(TextView)customview.findViewById(R.id.POI_textView);

        textview.setText(leer+(adr.get(position).getType())+leer+(adr.get(position).getName())+leer+
                         (adr.get(position).getAdress())+leer+
                          (adr.get(position).getLat())+leer+
                           (adr.get(position).getLon())+leer+(adr.get(position).getCapacity()));



        ImageView iv = (ImageView) customview.findViewById(R.id.POI_imageView);

         iv.setImageDrawable(adr.get(position).getDrawable());



return customview;
   }











    @Override
    public int getCount() {

        return adr.size();
   }



}
