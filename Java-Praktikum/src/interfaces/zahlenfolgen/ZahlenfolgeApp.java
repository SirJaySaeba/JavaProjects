package interfaces.zahlenfolgen;

public class ZahlenfolgeApp {

	public static void main(String[] args) {

//		new Range(1,8).dump(9);
//		new Naturals().dump(9);

		//new Range(2,100).dump(30);
		
		Sequence primes = new Range(2,100);
		
		while(primes.hasNext()){
			int prime = primes.next();
			System.out.println(prime);
			primes = new ZapMultiples(primes, prime);
		}
		primes.dump(30);
	}

}
