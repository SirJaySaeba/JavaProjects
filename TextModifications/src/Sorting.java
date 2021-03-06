import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Calendar;

public class Sorting {

	private int bla;
	
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();
		List<Integer> sorted = new ArrayList<>();
		Calendar date = new GregorianCalendar();
		date.set(2015, 3, 1);
		numbers.add(8);
		numbers.add(7);
		numbers.add(7);
		numbers.add(8);
		numbers.add(1);
		numbers.add(6);
		numbers.add(2);
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(4);
		numbers.add(3);
		numbers.add(8);
		
	
		
		do{
			int smallest = getSmallest(numbers);
			int indexSmallest = numbers.indexOf(smallest);
			
			sorted.add(smallest);
			numbers.remove(indexSmallest);
		}while(numbers.size()>0);
			
		
		System.out.println(sorted);
		
		
	}
	
	private static int getSmallest(List<Integer> numbers){

		int currentlySmallest = numbers.get(0);
		
		for(int i = 0; i<numbers.size(); i++){
			if(numbers.get(i) < currentlySmallest){
				currentlySmallest = numbers.get(i);
			}
		}
		return currentlySmallest;
	}
	

}
