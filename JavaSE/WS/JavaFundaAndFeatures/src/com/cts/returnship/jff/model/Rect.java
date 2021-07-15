package com.cts.returnship.jff.model;

public class Rect implements Shape{

	private int l;
	private int b;
	
	public Rect(int l, int b) {
		super();
		this.l = l;
		this.b = b;
	}

	@Override
	public double area() {
		return l*b;
	}

	@Override
	public double perimeter() {
		return 2*(l+b);
	}

}
