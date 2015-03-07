package interfaces.physik;

public class PhysikMain {

	public static void main(String[] args) {

		Quantity<Zeit> t1 = new Quantity<>(1, Zeit.s);
		Quantity<Zeit> t2 = new Quantity<>(1, Zeit.s);
		Quantity<Length> ln = new Quantity<>(1, Length.m);
		
		Quantity<Length> d = new Quantity<>(2, Length.cm);
		System.out.println(d.by(d));
	}

}
