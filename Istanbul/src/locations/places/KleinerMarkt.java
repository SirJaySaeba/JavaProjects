package locations.places;

import locations.Location;

public class KleinerMarkt extends Location {

	private static final String name = "kleinerMarkt";
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
