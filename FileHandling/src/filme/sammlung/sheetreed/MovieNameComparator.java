package filme.sammlung.sheetreed;

import java.util.Comparator;

public class MovieNameComparator implements Comparator<Movie> {

	@Override
	public int compare(final Movie movie1, final Movie movie2) {
		// TODO Auto-generated method stub
		return movie1.getName().compareTo(movie2.getName());
	}

}
