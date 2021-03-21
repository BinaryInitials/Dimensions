package com.universe.math;

import java.util.List;

public class Util {
	
	public static void printCoordinates(List<double[]> coordinates) {
		char a = 'A';
		for(double[] coordinate : coordinates) {
			System.out.println(a++ + "=\t"+  printCoordinate(coordinate));
		}
	}
	
	public static String printCoordinate(double[] coordinate) {
		String output = "(";
		for(double x : coordinate) {
			output += x + ",";
		}
		return output.replaceAll(",$", ")");
	}
	
	public static double[] cloneCoordinate(double[] coordinate) {
		double[] newCoordinate = new double[coordinate.length];
		for(int i=0;i<coordinate.length;i++) {
			newCoordinate[i] = coordinate[i];
		}
		return newCoordinate;
	}
	
}
