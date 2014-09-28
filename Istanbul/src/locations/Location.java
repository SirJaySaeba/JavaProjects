package locations;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import gui.IstanbulGui;

public class Location {

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

	private int x;
	private int y;
	private String name;
	private Image img;
	
	public Location(){
		this.name = getName();
		this.img = getImageForLocation(getName());
	}
	
	public Image getImage() {
		return img;
	}
	
	public void setImage() {
		this.img = getImageForLocation(getName());
	}

	protected Image getImageForLocation(String type) {
		
		String filename = type+".png";
		
		URL urlPieceImg = getClass().getResource("/img/" + filename);
		return new ImageIcon(urlPieceImg).getImage();
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
	
	public void resetLocationPosition() {
		this.x = IstanbulGui.convertColumnToX(this.getColumn());
		this.y = IstanbulGui.convertRowToY(this.getRow());
	}
}
