package handystuff.httprequests;

public class Spritverbrauch {

	public static void main(String[] args) {
		
		final double SPRITVERBRAUCH = 7.7;
		
		final double SPRITPREIS = 1.45;
	
		double km = 340;
		
		double preis = 0;
		double liter;
		
		preis = (SPRITPREIS*SPRITVERBRAUCH)*km/100;
		
		System.out.println((int)preis+" Euro");


	}

}
