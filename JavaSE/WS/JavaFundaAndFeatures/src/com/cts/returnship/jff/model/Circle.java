package com.cts.returnship.jff.model;

public class Circle implements Shape {

	private int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI*Math.pow(radius, 2);
	}

	@Override
	public double perimeter() {
		return 2*Math.PI*radius;
	}

}
