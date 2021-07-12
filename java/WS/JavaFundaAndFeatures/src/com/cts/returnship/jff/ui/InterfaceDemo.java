package com.cts.returnship.jff.ui;

import com.cts.returnship.jff.model.Circle;
import com.cts.returnship.jff.model.Rect;
import com.cts.returnship.jff.model.Shape;

public class InterfaceDemo {

	public static void main(String[] args) {

		Shape s1 = new Rect(10,10);
		Shape s2 = new Circle(10);
		
		System.out.println(Shape.greaterOf(s1, s2));
		System.out.println(s1.estimatePaintingCost(12.0));
		System.out.println(s2.estimatePaintingCost(12.0));
	}

}
