package ziegenproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameShow {

	public static void main(String[] args) {

		Random rand = new Random();
		Tor tor1 = new Tor(0);
		Tor tor2 = new Tor(1);
		Tor tor3 = new Tor(2);
		List<Tor> gates = new ArrayList<>();
		gates.add(tor1);
		gates.add(tor2);
		gates.add(tor3);

		int surprise = rand.nextInt(3);
		Tor gateWithPresent = gates.get(surprise);
		gateWithPresent.setPrice(new Auto());

		for(int i=0; i<gates.size();i++){
			if(i==surprise){
				continue;
			}
			gates.get(i).setPrice(new Zonk());
		}
		gates.get(1).openGate();
		System.out.println(gates.get(1).getPrice().revealed());
		
		if(gates.get(1).getPrice() instanceof Auto){
			System.out.println("its a car");
		}else{
			System.out.println("zonk!");
		}
		
	}

}
