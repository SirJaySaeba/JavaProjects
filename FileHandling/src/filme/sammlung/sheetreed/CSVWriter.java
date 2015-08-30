package filme.sammlung.sheetreed;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CSVWriter {
	// Delimiter used in CSV file
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String ID = FileReaderCentral.MOVIE_ID;
	private static final String NAME = FileReaderCentral.MOVIE_NAME;
	private static final String MEDIUM = FileReaderCentral.MOVIE_MEDIUM;
	private static final String LICENSE = FileReaderCentral.MOVIE_LICENSE;
	// CSV file header
	private static final String[] FILE_HEADER = { ID, NAME, MEDIUM, LICENSE };

	public static void writeCsvFile(final List<Movie> movies) {

		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;

		// Create the CSVFormat object with "\n" as a record delimiter
		final CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR).withDelimiter(';');

		try {

			// initialize FileWriter object
			fileWriter = new FileWriter(System.getProperty("user.home") + "/Documents/movie.csv");

			// initialize CSVPrinter object
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

			// Create CSV file header
			csvFilePrinter.printRecord(FILE_HEADER);

			// Write a new movie object list to the CSV file
			for (final Movie movie : movies) {
				final List<String> movieDataRecord = new ArrayList<>();
				movieDataRecord.add(movie.getId());
				movieDataRecord.add(movie.getName());
				movieDataRecord.add(movie.getMedium());
				movieDataRecord.add(movie.getLicense());
				csvFilePrinter.printRecord(movieDataRecord);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (final Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (final IOException e) {
				System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
				e.printStackTrace();
			}
		}
	}
}
