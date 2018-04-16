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
    System.out.println("A program generál egy egész számot 0 és "+limit+" között, ezt kell kitalálni!");
    System.out.println("Tippelj, és kapsz információt a tippedrõl!");
  }

  
  public int randomNumber() {
    Random rand = new Random();
    
    return rand.nextInt(limit + 1);
  }
 
  
  public boolean check(String s) {
    boolean out = true;
    
    if (s.length()==0) {
      System.out.println("Nem írtál be adatot!");
      out = false;
    }
    
    if (out) {
      try {
        int x = Integer.valueOf(s);
      } catch (NumberFormatException nfe) {
          System.out.println("Hibás a beírt adat formátuma!");
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
      mS="Eltaláltad!\nTippek száma: "+db; 
      ok = true;
    }
    
    if (rndNum < tipp) {
      mS="A szám kisebb a tippedtõl!";
      if (tipp <= max) max = tipp;
    }
    
    if (rndNum > tipp) {
      mS="A szám nagyobb a tippedtõl!";
      if (tipp >= min) min = tipp;
    }
    
    if (tipp > max) mS="A tippelt szám nagyobb, mint a már ismerhetõ legnagyobb érték!";
    if (tipp < min) mS="A tippelt szám kisebb, mint a már ismerhetõ legkisebb érték!";
    if (tipp < 0) mS="A tippelt szám kisebb, mint az alsó határ!";
    if (tipp > limit) mS="A tippelt szám nagyobb, mint a felsõ határ!";
    
    System.out.println(mS);
    
    return mS;
  }
}