package filme.sammlung.sheetreed;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {

	// Student attributes
	private static final String ID = FileReaderCentral.MOVIE_ID;
	private static final String NAME = FileReaderCentral.MOVIE_NAME;
	private static final String MEDIUM = FileReaderCentral.MOVIE_MEDIUM;
	private static final String LICENSE = FileReaderCentral.MOVIE_LICENSE;

	private static final String[] FILE_HEADER_MAPPING = { ID, NAME, MEDIUM, LICENSE };

	public static List<Movie> readCsvFile(final String fileName) {

		FileReader fileReader = null;

		CSVParser csvFileParser = null;

		// Create the CSVFormat object with the header mapping
		final CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING).withDelimiter(';');

		final List<Movie> movies = new ArrayList<>();
		try {

			// Create a new list of student to be filled by CSV file data

			// initialize FileReader object
			fileReader = new FileReader(fileName);

			// initialize CSVParser object
			csvFileParser = new CSVParser(fileReader, csvFileFormat);

			// Get a list of CSV file records
			final List<CSVRecord> csvRecords = csvFileParser.getRecords();

			// Read the CSV file records starting from the second record to skip
			// the header
			String idPrefix = "";
			for (final CSVRecord record : csvRecords) {
				// Create a new student object and fill his data
				if (record.getRecordNumber() == 1) {
					idPrefix = record.get(0);
					continue;
				}
				final Movie movie = new Movie(record.get(NAME), idPrefix + record.get(ID), record.get(MEDIUM),
						record.get(LICENSE));
				movies.add(movie);
			}

			// Print the new student list
			for (final Movie movie : movies) {
				System.out.println(movie.getName());
			}
		} catch (final Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (final IOException e) {
				System.out.println("Error while closing fileReader/csvFileParser !!!");
				e.printStackTrace();
			}
		}
		return movies;

	}

}
