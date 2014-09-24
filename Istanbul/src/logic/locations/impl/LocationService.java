package logic.locations.impl;

import locations.Location;
import locations.LocationGui;
import logic.locations.LocationConverter;
import logic.locations.LocationFactory;
import logic.services.Implementation;

public class LocationService implements LocationFactory,
		LocationConverter {

	@Implementation(DefaultLocationFactory.class)
	private LocationFactory factory;

	@Implementation(DefaultLocationConverter.class)
	private LocationConverter converter;

	public LocationFactory getFactory() {
		return factory;
	}

	public LocationConverter getConverter() {
		return converter;
	}

	@Override
	public LocationGui convert(Location location) {
		return getConverter().convert(location);
	}

	@Override
	public Location buildLocation(String name, Class<? extends Location> type) {
		return getFactory().buildLocation(name, type);
	}

	@Override
	public Location buildLocation(Class<? extends Location> type) {
		return getFactory().buildLocation(type);
	}

}
