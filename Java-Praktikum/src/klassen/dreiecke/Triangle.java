package klassen.dreiecke;

import java.awt.Point;



public class Triangle {

	private final Point a;
	private final Point b;
	private final Point c;

	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double perimeter(){
		
		return a.distance(c)+b.distance(c)+a.distance(b);
	}
	
	private double getArea(){		
		final double side_a = b.distance(c);
		final double side_b = a.distance(c);
		final double side_c = a.distance(b);
		
		final double s = (side_a+side_b+side_c)/2;
		
		return Math.sqrt(s*(s-side_a)*(s-side_b)*(s-side_c));
	}
	
	public Point getC() {
		return c;
	}

	public static void main(String[] args) {

		Triangle t1 = new Triangle(new Point(-1,0),new Point(1,0), new Point(0,1));
		System.out.println(t1.perimeter());
		System.out.println(t1.getArea());
	}
}
