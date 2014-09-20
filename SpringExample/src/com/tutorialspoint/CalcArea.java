package com.tutorialspoint;

public class CalcArea {

	Shape shape;
	
	public void setShape(Shape shape){
		this.shape = shape;
	}
	
	public void printArea(){
		System.out.println("Fläche beträgt: "+shape.calcArea());
	}
}
