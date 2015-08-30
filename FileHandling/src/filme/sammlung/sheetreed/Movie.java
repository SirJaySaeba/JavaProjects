package filme.sammlung.sheetreed;

public class Movie {

	private final String name;
	private final String id;
	private final String medium;
	private final String license;
	private final String unseen;
	private final String rent;

	public Movie(final String name, final String id, final String medium, final String license, final String unseen,
			final String rent) {
		super();
		this.name = name;
		this.id = id;
		this.medium = medium;
		this.license = license;
		this.unseen = unseen;
		this.rent = rent;
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

	public String getUnseen() {
		return unseen;
	}

	public String getRent() {
		return rent;
	}

}
