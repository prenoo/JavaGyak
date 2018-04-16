package tipper;

import java.util.Random;
import java.util.Scanner;

public class Tipper {
   private int db = 0;
   private int rndNum = 0;
   private boolean success = false;
   private int limit = 100;
   private int min = 0;
   private int max = limit;
   
   public void resetAll(){
	   min = 0;
	   limit = 100;
	   max = limit;
   }
 
   
  public int getDb() {
	  return db;
  }
  
  
  public void setDb(int dbIn) {
	  db = dbIn;
  }
  
  
  public void setRndNum(int rndIn) {
	  rndNum = rndIn;
  }
  
  
  public void inform() {
    System.out.println("A program gener�l egy eg�sz sz�mot 0 �s "+limit+" k�z�tt, ezt kell kital�lni!");
    System.out.println("Tippelj, �s kapsz inform�ci�t a tippedr�l!");
  }

  
  public int randomNumber() {
    Random rand = new Random();
    
    return rand.nextInt(limit + 1);
  }
 
  
  public boolean check(String s) {
    boolean out = true;
    
    if (s.length()==0) {
      System.out.println("Nem �rt�l be adatot!");
      out = false;
    }
    
    if (out) {
      try {
        int x = Integer.valueOf(s);
      } catch (NumberFormatException nfe) {
          System.out.println("Hib�s a be�rt adat form�tuma!");
          out = false;
      }
    }
    
    return out;
  }

  
  public int StoInt (String s) {
    int x = -1;
    
    try {
      x=Integer.valueOf(s);
    } catch (NumberFormatException nfe) {
        System.out.println("StoInt: "+nfe.getMessage());
    }
    
    return x;
  }

  
  public String evaluate(String s) {
    boolean ok = false;
    String mS = "";
    int tipp = StoInt(s);
    db++;
    
    if (rndNum == tipp) {
      mS="Eltal�ltad!\nTippek sz�ma: "+db; 
      ok = true;
    }
    
    if (rndNum < tipp) {
      mS="A sz�m kisebb a tippedt�l!";
      if (tipp <= max) max = tipp;
    }
    
    if (rndNum > tipp) {
      mS="A sz�m nagyobb a tippedt�l!";
      if (tipp >= min) min = tipp;
    }
    
    if (tipp > max) mS="A tippelt sz�m nagyobb, mint a m�r ismerhet� legnagyobb �rt�k!";
    if (tipp < min) mS="A tippelt sz�m kisebb, mint a m�r ismerhet� legkisebb �rt�k!";
    if (tipp < 0) mS="A tippelt sz�m kisebb, mint az als� hat�r!";
    if (tipp > limit) mS="A tippelt sz�m nagyobb, mint a fels� hat�r!";
    
    System.out.println(mS);
    
    return mS;
  }
}