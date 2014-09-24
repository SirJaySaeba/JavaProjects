package logic.locations.impl;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import locations.Location;
import locations.LocationGui;
import logic.locations.LocationConverter;

public class DefaultLocationConverter implements LocationConverter {
	
	public LocationGui convert(final Location location) {
		Image img = getImageForLocation(location);
		return new LocationGui(img, location);
	}

	private Image getImageForLocation(final Location location) {
		final String filename = location.getName() + ".png";
		final URL urlPieceImg = getClass().getResource("/img/" + filename);
		return new ImageIcon(urlPieceImg).getImage();
	}
	
}
