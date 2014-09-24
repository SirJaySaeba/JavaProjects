package logic;

import java.util.ArrayList;
import java.util.List;

import locations.Location;
import locations.places.Brunnen;
import locations.places.Edelsteinhaendler;
import locations.places.Gewuerzlager;
import locations.places.GrosseMoschee;
import locations.places.GrosserMarkt;
import locations.places.Karawanserei;
import locations.places.KleineMoschee;
import locations.places.KleinerMarkt;
import locations.places.Obstlager;
import locations.places.Polizeiwache;
import locations.places.Postamt;
import locations.places.Schwarzmarkt;
import locations.places.Sultanspalast;
import locations.places.Teestube;
import locations.places.Tuchlager;
import locations.places.Wagnerei;
import logic.locations.impl.LocationService;
import logic.services.ServiceFactory;

public class GameLogic {

	private LocationService locationService;

	// 0 = bottom, size = top
	private List<Location> locations = new ArrayList<Location>();
	private List<String> takenSpot = new ArrayList<String>();

	public GameLogic() {

		this.locations.add(getLocationService().buildLocation(Brunnen.class));
		this.locations.add(getLocationService().buildLocation(Teestube.class));
		this.locations.add(getLocationService().buildLocation(Schwarzmarkt.class));
		this.locations.add(getLocationService().buildLocation(KleinerMarkt.class));
		this.locations.add(getLocationService().buildLocation(GrosserMarkt.class));
		this.locations.add(getLocationService().buildLocation(KleineMoschee.class));
		this.locations.add(getLocationService().buildLocation(GrosseMoschee.class));
		this.locations.add(getLocationService().buildLocation(Wagnerei.class));
		this.locations.add(getLocationService().buildLocation(Obstlager.class));
		this.locations.add(getLocationService().buildLocation(Gewuerzlager.class));
		this.locations.add(getLocationService().buildLocation(Tuchlager.class));
		this.locations.add(getLocationService().buildLocation(Postamt.class));
		this.locations.add(getLocationService().buildLocation(Polizeiwache.class));
		this.locations.add(getLocationService().buildLocation(Sultanspalast.class));
		this.locations.add(getLocationService().buildLocation(Edelsteinhaendler.class));
		this.locations.add(getLocationService().buildLocation(Karawanserei.class));

		int i = 0;
		do {
			int randColumn = (int) (Math.random() * 4);
			int randRow = (int) (Math.random() * 4);
			if (!takenSpot.contains(Location.getLocationCoordinates(randRow,
					randColumn))) {
				takenSpot.add(Location.getLocationCoordinates(randRow,
						randColumn));
				System.out.println(Location.getLocationCoordinates(randRow,
						randColumn));
				locations.get(i).setColumn(randColumn);
				locations.get(i).setRow(randRow);
				i++;
			} else {
				continue;
			}

		} while (i < locations.size());

	}

	public List<Location> getLocations() {
		return this.locations;
	}
	
	public LocationService getLocationService() {
		if (locationService == null) {
			locationService = ServiceFactory.getService(LocationService.class);
		}

		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

}
