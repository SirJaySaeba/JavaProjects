package logic.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ServiceFactory {

	private final static Collection<Object> serviceInstances = new HashSet<>();
	
	public static <T> T getService(final Class<T> serviceClass) {
		for (final Object service : serviceInstances) {
			if (serviceClass.isAssignableFrom(service.getClass())) {
				return (T) service;
			}
		}
		return createService(serviceClass);
	}
	
	public static <T> T createService(final Class<T> serviceClass) {
		try {
			return ServiceFactory.<T> createServiceInternal(serviceClass, new ArrayList<Class<?>>());
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static <T> T createServiceInternal(final Class<T> serviceClass, final List<Class<?>> inProgress) throws InstantiationException {
		
		if (inProgress.contains(serviceClass)) {
			throw new InstantiationException(String.format("Not able to build the Service '%s', because of a circular dependency, tried to instantiate: '%s'", serviceClass.getSimpleName(), inProgress.toString()));
		}
		inProgress.add(serviceClass);
		
		try {
			final T serviceInstance = serviceClass.newInstance();
			
			final Field[] declaredFields = serviceClass.getDeclaredFields();
			
			if (declaredFields != null && declaredFields.length > 0) {
				for (Field field : declaredFields) {
					
					
					if (field.isAnnotationPresent(Implementation.class)) {
						Implementation implementation = field.getAnnotation(Implementation.class);
						final Object localService = createServiceInternal(implementation.value(), inProgress);
						
						boolean access = field.isAccessible();
						field.setAccessible(true);
						field.set(serviceInstance, localService);
						field.setAccessible(access);
					}
				}
			}

			serviceInstances.add(serviceInstance);
			
			return serviceInstance;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
