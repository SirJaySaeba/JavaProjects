package interfaces.zahlenfolgen;

import java.util.NoSuchElementException;


public class Range extends Sequence{

	private int start;
	private final int afterEnd;
	
	public Range(int start, int afterEnd) {
		this.start = start;
		this.afterEnd = afterEnd;
	}
	
	public boolean hasNext() throws IllegalStateException{
		return start<afterEnd;
	}

	public Integer next(){
		if(!hasNext()){
			throw new NoSuchElementException("no more Elements!");
		}
		return start++;
	}
	
}
