import javax.swing.JOptionPane;


public class App {

	public static void main(String[] args) {

		String input;
		input = JOptionPane.showInputDialog("Gib eine Zahl ein: ");
		
		Integer i = new Integer(input);
		
		if(i<18){
			JOptionPane.showMessageDialog(null, "minderj�hrig");
		}else{
			JOptionPane.showMessageDialog(null, "vollj�hrig");
			
		}
	}

}