package filme.sammlung.sheetreed;

import org.jopendocument.model.OpenDocument;
import org.jopendocument.model.table.TableTable;

public class ODFCentral {

	public static void main(final String[] args) {
		// Load the spreadsheet.
		final OpenDocument doc = new OpenDocument();
		doc.loadFrom("C:/Users/Sir Jay/Documents/Filmsammlung.ods");

		for (final TableTable table : doc.getBody().getOfficeSpreadsheets().get(0).getTables()) {
			System.out.println(table.getTableName());

			System.out.println(table.getColumn(0));
			System.out.println(table.getColumnAtPosition(0));

		}
	}

}
