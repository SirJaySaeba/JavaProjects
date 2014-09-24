package logic.locations;

import locations.Location;

public interface LocationFactory {

	public Location buildLocation(final String name,
			final Class<? extends Location> type);

	public Location buildLocation(final Class<? extends Location> type);

}
