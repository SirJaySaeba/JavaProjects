package ziegenproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameShow2 {

	public static void main(String[] args) {

		Price auto = new Auto();
		Random rand = new Random();
		int hitCounter = 0;

		for (int i = 0; i < 10000; i++) {
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

			int anotherGate;
			do {
				anotherGate = rand.nextInt(3);
			} while (anotherGate == chosenGateNumber);

			Tor oneOfClosedGates = gates.get(anotherGate);
			if (oneOfClosedGates.getPrice().getName().equals("Mitsubishi")) {
				continue;
			}
			int newGateNumber;
			do {
				newGateNumber = rand.nextInt(3);
			} while (newGateNumber == chosenGateNumber
					|| newGateNumber == anotherGate);
			Tor chosenGate = gates.get(newGateNumber);

			if (chosenGate == gateWithPresent) {
				hitCounter++;
			}
		}
		System.out
				.println("your hitrate: " + (hitCounter / 10000f) * 100 + "%");

	}

}
