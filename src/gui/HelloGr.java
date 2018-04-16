package gui;

import javax.swing.*;

public class HelloGr { 
	public static void main(String[] args) { 
      JFrame Foablak = new JFrame("Grafikus Hello"); 
      Foablak.setBounds(50,50, 260,150); 
      Foablak.getContentPane().setLayout(null); 
      
      JLabel Felirat = new JLabel("Helló világ"); 
      Felirat.setBounds(30,10, 100,20); 
      Foablak.getContentPane().add(Felirat); 

      Foablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Foablak.setVisible(true);
  } 
}