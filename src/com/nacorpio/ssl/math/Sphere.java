package com.nacorpio.ssl.math;

public class Sphere {

	private double radius;
	
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Returns the radius of the sphere.
	 * @return the radius of the sphere.
	 */
	public final double getRadius() {
		return this.radius;
	}
	
	/**
	 * Returns the calculated volume of the sphere.
	 * @return the calculated volume of the sphere.
	 */
	public final double getVolume() {
		return 4 / 3 * Math.PI * (radius * radius * radius);
	}
	
	public final double getSurfaceArea() {
		return 4 * Math.PI * (radius * radius);
	}
	
}
