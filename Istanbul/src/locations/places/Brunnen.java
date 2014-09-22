package locations.places;

import locations.Location;

public class Brunnen extends Location {

	private static final String name = "brunnen";
	private int row;
	private int column;

	public String getName(){
		return name;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}


//	private static Brunnen instance;
//	public static synchronized Brunnen getInstance() {
//		if (Brunnen.instance == null) {
//			Brunnen.instance = new Brunnen(name, row, column);
//		}
//		return Brunnen.instance;
//	}

}