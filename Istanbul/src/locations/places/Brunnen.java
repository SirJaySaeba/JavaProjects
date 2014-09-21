package locations.places;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import locations.Location;

public class Brunnen extends Location {

	private static final String name = "brunnen";
	private Image image;
	private int row;
	private int column;

	
	
	public Image getImage(String filename) {
		filename = filename+".png";
		URL urlPieceImg = getClass().getResource("/img/" + filename);
		return new ImageIcon(urlPieceImg).getImage();
	}

	public void setImg(Image img) {
		this.image = img;
	}

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

	public Brunnen(int row, int column) {
		this.row = row;
		this.column = column;
		// TODO Auto-generated constructor stub
	}

//	private static Brunnen instance;
//	public static synchronized Brunnen getInstance() {
//		if (Brunnen.instance == null) {
//			Brunnen.instance = new Brunnen(name, row, column);
//		}
//		return Brunnen.instance;
//	}

}