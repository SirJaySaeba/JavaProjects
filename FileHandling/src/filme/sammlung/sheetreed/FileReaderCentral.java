package filme.sammlung.sheetreed;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReaderCentral {
	public static final String MOVIE_ID = "id";
	public static final String MOVIE_NAME = "name";
	public static final String MOVIE_MEDIUM = "medium";
	public static final String MOVIE_LICENSE = "license";
	public static final String MOVIE_UNSEEN = "ungesehen";
	public static final String MOVIE_RENT = "ausgeliehen";

	public static void main(final String[] args) {

		final File folder = new File("C:/Users/Sir Jay/Documents/filmsammlung");
		final File[] listOfFiles = folder.listFiles();
		final List<Movie> listOfAllMovies = new ArrayList<>();

		for (final File file : listOfFiles) {
			final List<Movie> movies = CSVReader.readCsvFile(file.getPath());
			listOfAllMovies.addAll(movies);
		}
		Collections.sort(listOfAllMovies, new MovieNameComparator());

		// showAllRentMovies(listOfAllMovies);
		CSVWriter.writeCsvFile(listOfAllMovies);
	}

	public static void showAllRentMovies(final List<Movie> movies) {
		for (final Movie movie : movies) {
			if (!movie.getRent().isEmpty()) {
				System.out.println(movie.getId() + " - " + movie.getName());
				System.out.println("Rent to: " + movie.getRent());
				System.out.println("-----------------------------------");
			}
		}
	}

	public static void showAllRentUnseen(final List<Movie> movies) {
		for (final Movie movie : movies) {
			if (!movie.getUnseen().isEmpty()) {
				System.out.println(movie.getId() + " - " + movie.getName());
			}
		}
	}

}
