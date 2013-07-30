package com.nacorpio.ssl.math;

public class TwoDimensionalRect {

	private double height;
	private double width;
	
	public TwoDimensionalRect(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getVolume() {
		return height * width;
	}
	
}
