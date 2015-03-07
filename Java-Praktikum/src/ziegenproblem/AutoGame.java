package ziegenproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoGame {

	public static void main(String[] args) {
		
		
		Price auto = new Auto();
		Random rand = new Random();
		
		int hitCounter = 0;
		
		
		for(int i=0; i<10000; i++){
			
			Tor tor1 = new Tor(0);
			Tor tor2 = new Tor(1);
			Tor tor3 = new Tor(2);
			List<Tor> gates = new ArrayList<>();
			gates.add(tor1);
			gates.add(tor2);
			gates.add(tor3);
			
			int surprise = rand.nextInt(3);
			Tor gateWithPresent = gates.get(surprise);
			gateWithPresent.setPrice(auto);
			
			int chosenGateNumber = rand.nextInt(3);

			Tor chosenGate = gates.get(chosenGateNumber);
			chosenGate.openGate();
			
			if(chosenGate == gateWithPresent){
				hitCounter++;
			}
		}

		System.out.println("your hitrate: "+(hitCounter/10000f)*100+"%");
		
		
		
	}

}
