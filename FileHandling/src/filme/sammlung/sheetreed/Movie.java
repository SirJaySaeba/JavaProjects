package filme.sammlung.sheetreed;

public class Movie {

	private final String name;
	private final String id;
	private final String medium;
	private final String license;

	public Movie(final String name, final String id, final String medium, final String license) {
		super();
		this.name = name;
		this.id = id;
		this.medium = medium;
		this.license = license;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getMedium() {
		return medium;
	}

	public String getLicense() {
		return license;
	}

}
