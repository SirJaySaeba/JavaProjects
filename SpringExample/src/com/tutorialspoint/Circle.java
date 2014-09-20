package com.tutorialspoint;

public class Circle implements Shape{
	
	private double radius;
		
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcArea() {		
		return radius*radius*3.14;
	}
}
