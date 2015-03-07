package interfaces.zahlenfolgen;

import java.util.Iterator;

public abstract class Sequence implements Iterator<Integer> {

	public final void remove(){
		throw new UnsupportedOperationException("sequence is immutable");
	}
	
	public void dump(int cut){
		for(int i=0; hasNext() && i<cut; i++){
			System.out.print(next());
			if(hasNext()){		
				System.out.print(", ");				
			}
		}
		System.out.print(hasNext()?"...": ";");
		System.out.println();
	}
}
