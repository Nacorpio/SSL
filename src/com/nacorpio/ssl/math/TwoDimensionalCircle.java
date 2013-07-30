package com.nacorpio.ssl.math;

public class TwoDimensionalCircle {
	
//	area = PI * (radius) * (radius) or
//	area = PI * (diameter / 2) * (diameter / 2)
//	radius = (diameter / 2) or
//	radius = sqrt(area / PI)
//	diameter = 2 * radius or
//	diameter = circumference / PI
//	circumference = PI * diameter or
//	circumference = PI * (radius * 2)
//	sphere surface area = 4 * PI * (radius * radius)
//	sphere volume = 4/3 * PI * (radius * radius * radius)

	
	private double radius;
	
	public TwoDimensionalCircle(double radius) {
		this.radius = radius;
	}
	
	public double getDiameter() {
		return radius * 2;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double getCircumference() {
		return Math.PI * (radius * 2);
	}
	
	public double getSphereSurfaceArea() {
		return 4 * Math.PI * (radius * radius);
	}
	
	public double getSphereVolume() {
		return 4 / 3 * Math.PI * (radius * radius * radius);
	}
	
}
