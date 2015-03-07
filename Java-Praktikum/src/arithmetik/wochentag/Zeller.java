package arithmetik.wochentag;

import javax.swing.JOptionPane;

public class Zeller {

	public static void main(String[] args) {

		int i=0;
/*		
		int d = Integer.parseInt(args[i++]);
		int m = Integer.parseInt(args[i++]);
		int y = Integer.parseInt(args[i++]);
*/
		int d = Integer.parseInt(JOptionPane.showInputDialog("Tag"));
		int m = Integer.parseInt(JOptionPane.showInputDialog("Monat"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("Jahr"));	
		
		int c = (y/100);
		
		int w = (d + (26*(m+1))/10 + (5*y)/4 + c/4 + 5*c - 1 )%7;
		
		System.out.println("Wochentag "+ w);
	}

}
