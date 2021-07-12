package com.cts.returnship.jff.model;

public interface Shape {

	double area();
	double perimeter();
	
	public default double estimatePaintingCost(double paintingRate) {
		return area()*paintingRate;
	}
	
	public static Shape greaterOf(Shape s1,Shape s2) {
		return s1.area()>s2.area()?s1:s2;
	}
}