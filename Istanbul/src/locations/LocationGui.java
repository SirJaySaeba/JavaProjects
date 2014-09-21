package locations;

import gui.IstanbulGui;

import java.awt.Image;

public class LocationGui {
	
	private Image img;
	private int x;
	private int y;
	private Location location;

	public LocationGui(Image img, Location location) {
		this.img = img;
		this.location = location;
		this.resetToUnderlyingPiecePosition();
	}

	public Image getImage() {
		return img;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return img.getHeight(null);
	}

	public int getHeight() {
		return img.getHeight(null);
	}

	public void resetToUnderlyingPiecePosition() {
		this.x = IstanbulGui.convertColumnToX(location.getColumn());
		this.y = IstanbulGui.convertRowToY(location.getRow());
	}

	public Location getLocation() {
		return location;
	}

}
