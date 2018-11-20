package com.universe.math;

public class Util {
	
	public static void printPoint(double[] point) {
		for(double coord : point) 
			System.out.print(coord + "\t");
		System.out.println();
	}
	
	public static double[] copyArray(double[] array) {
		double[] copy = new double[array.length];
		for(int i=0;i<array.length;i++)
			copy[i] = array[i];
		return copy;
	}

}
