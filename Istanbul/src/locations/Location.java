package locations;

import java.awt.Image;


public class Location {

	private String name;
	
	private int row;
	public static final int ROW_1 = 0;
	public static final int ROW_2 = 1;
	public static final int ROW_3 = 2;
	public static final int ROW_4 = 3;

	private int column;
	public static final int COLUMN_A = 0;
	public static final int COLUMN_B = 1;
	public static final int COLUMN_C = 2;
	public static final int COLUMN_D = 3;

	private boolean isCaptured = false;
	private Image image;

	public Image getImage() {
		return image;
	}

	public Location(String name) {
		super();
		this.name = name;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getName() {
		return this.name;
	}
	
	public static String getRowString(int row){
		String strRow = "unknown";
		switch (row) {
			case ROW_1: strRow = "1";break;
			case ROW_2: strRow = "2";break;
			case ROW_3: strRow = "3";break;
			case ROW_4: strRow = "4";break;
		}
		return strRow;
	}
	
	public static String getColumnString(int column){
		String strColumn = "unknown";
		switch (column) {
			case COLUMN_A: strColumn = "A";break;
			case COLUMN_B: strColumn = "B";break;
			case COLUMN_C: strColumn = "C";break;
			case COLUMN_D: strColumn = "D";break;
		}
		return strColumn;
	}

	public static String getLocationCoordinates(int row, int column){
		return getRowString(row)+"/"+getColumnString(column);
	}

}
