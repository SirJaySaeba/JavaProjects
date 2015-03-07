package kontrollstrukturen.newton;

public class Series {

	static double exp(double x){
		int n = 0;
		double result = 0;
		while( n<15){
			result += Math.pow(x, n)/Series.fac(n);

			n++;
		}
		return result;
	}
	
	public static void main(String[] args) {


		System.out.println(Series.exp(2));
		System.out.println(Math.exp(2));

	}
	
	static int fac(int n){
		
		int i=1;
		int fac = 1;
		while(i<=n){
			fac = fac*i;
			i++;
		}
		
		return fac;
	}

}
