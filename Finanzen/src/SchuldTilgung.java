import java.text.DecimalFormat;

import javax.swing.JOptionPane;


public class SchuldTilgung {

	private static final double DARLEHEN = 50000;
	private static final double ZINS = 0.0155d;
	private static final double RATE = 400.42;
	private static final double SONDERTILGUNG = 2500.0;
	
	private static double getRestschuld(double restschuld, int laufzeit){
		double anteil_zins = (restschuld * ZINS)/12;
		double anteil_tilgung = RATE - anteil_zins;
		restschuld -= anteil_tilgung;
		if(laufzeit%12==0){
			restschuld-=SONDERTILGUNG;
		}
		return restschuld;
	}
	
	private static double getZinsSumme(double restschuld, double zinssumme){
		zinssumme += (restschuld * ZINS)/12;
		return zinssumme;
	}
	
	public static void main(String[] args){
		double restschuld = DARLEHEN;
		double zinssumme=0;
		int laufzeit = Integer.parseInt(JOptionPane.showInputDialog("Gib eine Laufzeit ein"));

		DecimalFormat df = new DecimalFormat("##.##");
		
		if(laufzeit > 0){
			while(laufzeit > 0){
				restschuld = getRestschuld(restschuld, laufzeit);
				zinssumme = getZinsSumme(restschuld, zinssumme);
				laufzeit--;
				System.out.println(restschuld);
			}
			System.out.println("gezahlte Zinsen: "+df.format(zinssumme)+" €");
			System.out.println("Am Ende der Laufzeit bleiben "+df.format(restschuld) +" übrig.");
		}else{
			while(restschuld > 0){
				restschuld = getRestschuld(restschuld,laufzeit);
				zinssumme = getZinsSumme(restschuld, zinssumme);
				laufzeit++;

				System.out.println(restschuld);
			}
			
			int jahre = laufzeit/12;
			int monate = laufzeit%12;
			System.out.println("gezahlte Zinsen: "+df.format(zinssumme)+" €");
			System.out.println("Die Tilgung würde "+jahre+" Jahre und "+monate+" Monate dauern");
		}
		
	}
	

	
}
