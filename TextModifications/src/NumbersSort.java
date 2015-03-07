import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersSort {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();
		List<Integer> sortedNumbers = new ArrayList<>();
int i = 0;
		numbers.add(2);
		numbers.add(5);
		numbers.add(1);
		numbers.add(3);
		numbers.add(4);

		while (!numbers.isEmpty()) {
			int rank = 0;
			for (int d : numbers) {
				if (d >= rank) {
					rank = d;
				}

			}
			sortedNumbers.add(rank);

			numbers.remove(numbers.indexOf(rank));
			i++;

		}
		for (int d : sortedNumbers) {
			System.out.println(d);
		}

	}

}
