package logic.locations.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import locations.Location;
import logic.locations.LocationFactory;

public class DefaultLocationFactory implements LocationFactory {
	
	public Location buildLocation(final String name,
			final Class<? extends Location> type) {

		Constructor<? extends Location> constructor = null;
		try {
			constructor = type.getConstructor(String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			return buildLocation(type);
		}

		try {
			return constructor.newInstance(name);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Location buildLocation(final Class<? extends Location> type) {
		Constructor<? extends Location> constructor = null;
		try {
			constructor = type.getConstructor();
			return constructor.newInstance();
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
