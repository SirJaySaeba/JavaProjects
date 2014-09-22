package locations.places;

import locations.Location;

public class Polizeiwache extends Location {

	private static final String name = "polizeiwache";
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

}
