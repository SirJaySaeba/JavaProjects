package interfaces.zahlenfolgen;

public class Evens extends Filter {

	@Override
	boolean pass(int number) {
		return number%2==0;
	}

	public Evens(Sequence sequence){
		super(sequence);
	}

}
