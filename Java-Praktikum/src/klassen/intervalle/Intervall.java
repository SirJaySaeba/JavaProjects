package klassen.intervalle;

import java.util.HashSet;
import java.util.Set;

public class Intervall {

	int a;
	int b;
	
	
	public int lowerBound() {
		return a;
	}


	public int upperBound() {
		return b;
	}

	public Intervall(){
		
	}
	
	public Intervall(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	private boolean isEmpty(){
		return a>b || a==0 || b == 0;
	}

	public String toString(){
		if(isEmpty()){
			return "Intervall: []";
		}
		return "Intervall: ["+a+","+b+"]";
	}
	
	public boolean equals(Intervall x){
		return x.lowerBound()==a && x.upperBound()==b;
	}
	
	public boolean contains(int i){
		return i>=a && i<=b;
	}
	
	public boolean contains(Intervall i){
		
		if(i.isEmpty()){
			return true;
		}
		
		return i.lowerBound()>=a && i.upperBound()<=b;
	}
	
	public Intervall gethull(Intervall i){
		
		if(i.isEmpty()){
			return this;
		}else if(this.isEmpty()){
			return i;
		}
		
		Intervall hull = new Intervall(Math.min(i.lowerBound(), a),Math.max(i.upperBound(), b));
		
		return hull;
	}
	
	public static void main(String[] args) {
		Intervall ini = new Intervall(2,7);
		Intervall ini2 = new Intervall(3,6);
		System.out.println(ini.gethull(ini2).toString());
	}

}
