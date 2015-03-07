package interfaces.zahlenfolgen;

import java.util.NoSuchElementException;

public abstract class Filter extends Sequence {

	private final Sequence source;
	private enum NextState {Unknown, Found, None};
	private NextState state = NextState.Unknown;
	private int next;
	
	public Filter(Sequence source) {
		this.source = source;
	}

	abstract boolean pass(int number);
	
	private NextState lookahead(){
		while(state == NextState.Unknown){
			if(source.hasNext()){
				next = source.next();
				if(pass(next)){
					state = NextState.Found;
				}
			}else{
				state = NextState.None;
			}
		}
		return state;
	}
	
	@Override
	public boolean hasNext(){
		return lookahead() == NextState.Found;
	}
	
	@Override
	public Integer next(){
		if(lookahead() == NextState.None){
			throw new NoSuchElementException("no more elements!");
		}
		state = NextState.Unknown;
		return next;
	}
}
