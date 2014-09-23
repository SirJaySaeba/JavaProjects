package locations.places;

import locations.Location;

public class Brunnen extends Location {

	private static final String name = "brunnen";

	public String getName(){
		return name;
	}
	

//	private static Brunnen instance;
//	public static synchronized Brunnen getInstance() {
//		if (Brunnen.instance == null) {
//			Brunnen.instance = new Brunnen(name, row, column);
//		}
//		return Brunnen.instance;
//	}

}