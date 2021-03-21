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
		int dimension = Integer.valueOf(args[0]);
		
		System.out.println("Coordinates for a " + dimension + " dimensionsal manifold:");
		
		List<double[]> coordinates = getCoordinates(dimension);
		
		printCoordinates(coordinates);
	}
	
	public static List<double[]> getCoordinates(int dimension){
		List<double[]> coordinates = new ArrayList<double[]>();
		
		for(int i=0;i<=dimension;i++) {
			
			if( i==0 ) {
				coordinates.add(new double[dimension>0?dimension:1]);
			}else {
				double[] lastCoordinate = coordinates.get(coordinates.size()-1);
				double[] newCoordinate = normalizeCenterOfGravity(lastCoordinate, i);
				newCoordinate[i-1] = nthDimensionalProjection(i);
				coordinates.add(newCoordinate);
			}
			
		}
		
		return coordinates;
	}
	
	public static double nthDimensionalProjection(int dimension){
		
		/*
		 * For a given nth dimensional manifold, the n+1 equi-distant object will always be
		 * sqrt( (n+1) / (2*n) ) distant away from the n-1th dimensional manifold.
		 * This finding was rather peculiar and yet beautiful at the same time.
		 * This suggests that as n-> infinity, such distance approaches 1/sqrt(2)
		 * What does this mean?
		 * 
		 * Remember that we are using a normalized manifold, thus sqrt(2)/2 is the
		 * ratio of the height and the length of one of the sides of the manifold.
		 * Thus we are looking at the cosine of the angle formed between the height
		 * and the its adjacent side. 
		 * Therefore the asymptotic angle formed between the projection of the new 
		 * coordinate and its side is pi/4 (or 45 degrees). 
		 * 
		 * Still what is so special about pi/4?
		 * 
		 * Well, since one of the adjacent side is pi/4 radians away from the projection,
		 * this means that each adjacent sides are pi/2 radians away from each other. 
		 * In other words, they are orthogonal. 
		 * But this cannot be since this would suggest that each side is now linearly independent of one another.
		 * 
		 * Funny things happen when you approach infinity... 
		 * 
		 */
		return Math.sqrt((dimension+1.0) / (dimension*2.0));
	}
	
	
	public static double[] normalizeCenterOfGravity(double[] coordinate, int dimension) {
		double[] centerOfGravity = cloneCoordinate(coordinate);

		/*
		 * Center of gravity is used to determine n+1 th coordinates.
		 * A 0 dimensional manifold does not have a center of gravity other than itself which is 0. 
		 */
		if(dimension>1) {
			centerOfGravity[dimension-2] = centerOfGravity[dimension-2]/dimension; 
		}
		
		return centerOfGravity;
	}
}