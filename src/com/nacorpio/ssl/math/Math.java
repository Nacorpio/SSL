package com.nacorpio.ssl.math;

public final class Math {

	/**
	 * Returns the PI value.
	 */
	public final static double PI = 3.1415927;
	
	public static final double getCircleCircumference(double radius) {
		return PI * (radius * 2);
	}

	public static final double getCircleDiameter(double radius) {
		return radius * 2;
	}
	
}
