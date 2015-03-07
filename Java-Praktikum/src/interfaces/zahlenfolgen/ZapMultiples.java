package interfaces.zahlenfolgen;

public class ZapMultiples extends Filter{

	private final int multi;
	
	public ZapMultiples(Sequence sequence, int multi) {
		super(sequence);
		this.multi = multi;
	}

	@Override
	boolean pass(int number) {
		return !(number%multi==0);
	}

}
