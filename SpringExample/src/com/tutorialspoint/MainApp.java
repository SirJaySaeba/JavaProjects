package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CalcArea shape = (CalcArea) context.getBean("calc");
		shape.setShape((Shape) context.getBean("tri"));
		shape.printArea();
		shape.setShape((Shape) context.getBean("rec"));
		shape.printArea();
		shape.setShape((Shape) context.getBean("cir"));
		shape.printArea();
	}
}