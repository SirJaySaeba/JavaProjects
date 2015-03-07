package kontrollstrukturen.newton;

import javax.swing.JOptionPane;

public class NewtonVerfahren {

	public static void main(String[] args) {
		double n = Double.parseDouble(JOptionPane.showInputDialog("Gib eine Zahl ein: "));

		final double epsilon = n*1e-8;
		double q = 1;
		int steps = 0;
		
		
		while(Math.abs(n-q*q*q) > epsilon){
			q = (2*q + n/(q*q))/3;
			steps++;
		}
		System.out.println(q);
		System.out.println(steps);
	}

}
