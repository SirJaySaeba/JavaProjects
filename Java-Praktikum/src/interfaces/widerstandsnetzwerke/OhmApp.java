package interfaces.widerstandsnetzwerke;

public class OhmApp {

	public static void main(String[] args) {

		Circuit c1 = new Resistor(100);
		Circuit c2 = new Resistor(200);
		Circuit c3 = new Resistor(300);
		Circuit c4 = new Resistor(400);
		Potenziometer c5 = new Potenziometer(300);
		Circuit c6 = new Resistor(600);
		
		Circuit c13 = new Parallel(c1,c3);
		Circuit c123 = new Serial(c13,c2);
		Circuit c45 = new Serial(c4,c5);
		Circuit c12345 = new Parallel(c123,c45);
		Circuit c = new Parallel(c12345,c6);
		
		for(int ohm = 0; ohm<=500; ohm+=100){
			c5.setOhm(ohm);
			System.out.println(c.getOhm());
		}
		
	}

}
