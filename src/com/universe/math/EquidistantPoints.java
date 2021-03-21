package com.universe.math;

import static com.universe.math.Util.printCoordinates;
import static com.universe.math.Util.cloneCoordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Calculates coordinates of n+1 equi-distant points in a
 * n dimensional manifold.
 * 
 * @author binary.initials
 *
 */

public class EquidistantPoints {
	
	public static void main(String[] args) {
		
		if(args == null || args.length == 0 || !args[0].matches("^[0-9]+$")) {
			System.out.println("Usage: [n dimensional manifold (positive integer)]");
			System.exit(0);
		}
		
		int dimension = 2;
		System.out.println("Coordinates for a " + dimension + " dimensionsal manifold:");
		
		List<double[]> coordinates = getCoordinates(dimension);
		
		printCoordinates(coordinates);
	}
	
	public static List<double[]> getCoordinates(int dimension){
		List<double[]> coordinates = new ArrayList<double[]>();
		
		for(int i=0;i<=dimension;i++) {
			
			if( i==0 ) {
				coordinates.add(new double[dimension]);
			}else {
				double[] lastCoordinate = coordinates.get(coordinates.size()-1);
				double[] newCoordinate = normalizeCenterOfGravity(lastCoordinate);
				newCoordinate[i-1] = nthDimensionalProjection(i);
				coordinates.add(newCoordinate);
			}
			
		}
		
		return coordinates;
	}
	
	public static double nthDimensionalProjection(int dimension){
		return Math.sqrt((dimension+1.0) / (dimension*2.0));
	}
	
	
	public static double[] normalizeCenterOfGravity(double[] coordinate) {
		double[] centerOfGravity = cloneCoordinate(coordinate);
		if(coordinate.length>1) {
			centerOfGravity[coordinate.length-2] = centerOfGravity[coordinate.length-2]/coordinate.length; 
		}
		return centerOfGravity;
	}
}