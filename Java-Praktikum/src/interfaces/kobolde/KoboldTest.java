package interfaces.kobolde;

public class KoboldTest {

	public static void main(String[] args) {

		/*
		koboldTest(new Kobold("Max", new Blur(1)));
		koboldTest(new Kobold("Moritz", new Blur(2000)));
		
		koboldTest(new Kobold("Pumuckl", new Delay(2000)));
		koboldTest(new Kobold("Klabauter", new Delay(2000)));
		
		koboldTest(new Kobold("Max+Pumuckl", new Blur(1), new Delay(1)));
		*/
		Kobold max = new Kobold("Max", new Blur(1));
		Kobold pumuckl = new Kobold("Pumuckl", new Delay(2));
		
//		koboldTest(new Kobold("Freak", new Odds(new Delay(5)),
//										new Friend(max),
//										new Friend(pumuckl)));
		
		HonestKobold honi = new HonestKobold("honi", new Delay(3));
		honi.beHonestFor(5000);
		koboldTest(honi);
		
	}
	
	static void koboldTest(Kobold k){
		for(int i=0; i<10000000; i++){
			System.out.printf("%s.messUp(%d) --> %d%n", k.getName(),i, k.messUp(i));
			//System.out.println(k.getName()+": "+k.messUp(i));
		}
	}

}
