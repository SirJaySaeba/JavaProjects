package arithmetik.dreiecksflaeche;

import java.awt.Point;
import java.util.Scanner;

public class TriangleArea {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		double ax = scan.nextDouble();
		double ay = scan.nextDouble();
		double bx = scan.nextDouble();
		double by = scan.nextDouble();
		double cx = scan.nextDouble();
		double cy = scan.nextDouble();
		scan.close();
		Point point_a = new Point();
		Point point_b = new Point();
		Point point_c = new Point();
		
		point_a.setLocation(ax, ay);
		point_b.setLocation(bx, by);
		point_c.setLocation(cx, cy);
		
		final double side_a = point_a.distance(point_b);
		final double side_b = point_b.distance(point_c);
		final double side_c = point_c.distance(point_a);
		
		System.out.println(side_a+"----------"+Math.hypot(ax-bx,ay-by));		
		System.out.println(getArea(side_a,side_b,side_c));
		
	}
	
	private static double getArea(double a, double b, double c){		
		
		final double s = (a+b+c)/2;
		
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	
}
