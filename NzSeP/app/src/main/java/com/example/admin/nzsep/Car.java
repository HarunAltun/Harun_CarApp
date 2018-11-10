package com.example.admin.nzsep;

/**
 * Created by admin on 12.05.17.
 */

public class Car {

    private static Boolean Tür_Fahrer=false;                //Attribute
    private static Boolean Tür_BeiFahrer=false;
    private static Boolean Tür_RechtsHinten=false;
    private static Boolean Tür_LinksHinten=false;
    private static Boolean Kofferraum=false;
    private static float Tank=0;
    private static float Klima=18;
    private static String Ziel="";
                                                                      //getter
    public Boolean getZustand_Tür_Fahrer(){ return Tür_Fahrer;}
    public Boolean getZustand_Tür_Beifahrer(){ return Tür_BeiFahrer; }
    public Boolean getZustand_Tür_RechtsHinten(){
        return Tür_RechtsHinten;
    }
    public Boolean getZustand_Tür_LinksHinten(){  return Tür_LinksHinten;  }
    public Boolean getZustand_Kofferraum(){return Kofferraum;}
    public float  getTank(){return Tank;}
    public float getKlima(){ return Klima;}
    public String getZiel(){return Ziel;}                                                  //setter

    public void setZustand_Tür_Fahrer(Boolean Tür_Fahrer){
        this.Tür_Fahrer=Tür_Fahrer;
    }
    public void setZustand_Tür_Beifahrer(Boolean Tür_Beifahrer){ this.Tür_BeiFahrer=Tür_Beifahrer;}
    public void setZustand_Tür_RechtsHinten(Boolean Tür_RechtsHinten){this.Tür_RechtsHinten=Tür_RechtsHinten;}
    public void setZustand_Tür_LinksHinten(Boolean Tür_LinksHinten){this.Tür_LinksHinten=Tür_LinksHinten; }
    public void setZustand_Kofferraum(Boolean Kofferraum){this.Kofferraum=Kofferraum;}
    public void setTank(float Tank){this.Tank=Tank;}
    public void setKlima(float Klima){this.Klima=Klima;}
    public void setZiel(String Ziel){this.Ziel=Ziel;}

}
