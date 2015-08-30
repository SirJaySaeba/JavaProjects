package filme.sammlung.sheetreed;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCentral {
	public static final String MOVIE_ID = "id";
	public static final String MOVIE_NAME = "name";
	public static final String MOVIE_MEDIUM = "medium";
	public static final String MOVIE_LICENSE = "license";

	public static void main(final String[] args) {

		final File folder = new File("C:/Users/Sir Jay/Documents/filmsammlung");
		final File[] listOfFiles = folder.listFiles();
		final List<Movie> listOfAllMovies = new ArrayList<>();

		for (final File file : listOfFiles) {
			final List<Movie> movies = CSVReader.readCsvFile(file.getPath());
			listOfAllMovies.addAll(movies);
		}

		for (final Movie movie : listOfAllMovies) {
			System.out.println(movie.getName());
		}

		// CSVWriter.writeCsvFile(movies);
	}

}
