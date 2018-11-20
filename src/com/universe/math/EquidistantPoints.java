package com.universe.math;

import java.util.ArrayList;
import java.util.List;
import static com.universe.math.Util.*;


/*
 * This class calculates the coordinates of an n-equidistant-point system in a n-1 dimensional manifold
 */
public class EquidistantPoints {
	
	public static final double SIDE = 1.0;
	public static final double EPSILON_TOLERANCE = 0.000000000000001;
	public static void main(String[] args) {
		
		int dimensions = args != null && args.length > 0 ? -1+Integer.valueOf(args[0]) : 3; 
		
		System.out.println("The coordinates of a " + (dimensions+1) + " point system, requiring a " + dimensions + " dimensional manifold, is:");
		System.out.println();
		
		List<double[]> points = new ArrayList<double[]>();
		
		//Creating the first point located at the origin.
		double[] pointA = new double[dimensions];
		points.add(pointA);

		//Creating the second point, falling on the x-axis.
		double[] pointB = new double[dimensions];
		pointB[0] = SIDE;
		points.add(pointB);
		
		//Creating a center object
		double[] center = copyArray(pointB);
		center[0] = SIDE/2.0;
		
		//Generating the rest of the points in an nth dimensional universe and its center object...
		for(int i=1;i<dimensions;i++) {
			double[] newPoint = calculateNewPoint(points, center, i);
			points.add(newPoint);
			center = findCenter(points, i+1);
		}
		//Printing results
		System.out.print("Point\t");
		for(int i=0;i<dimensions;i++) 
			System.out.print("x"+i+"\t");
		System.out.println();
		for(int i=0;i<=dimensions;i++) {
			System.out.print((char)(65+i) + "\t");
			for(double coord : points.get(i)) 
				System.out.print(coord + "\t");
			System.out.println();
		}
		
	}
	
	public static double[] findCenter(List<double[]> points, int index) {
		double[] center = copyArray(points.get(index));
		
		double UPPER = center[index-1];
		double LOWER = 0.0;
		center[index-1] = UPPER/2.0;
		
		double[] centerUpper = copyArray(center);
		double[] centerLower = copyArray(center);

		while(Math.abs(UPPER-LOWER) > EPSILON_TOLERANCE) {
			centerUpper[index-1] = UPPER;
			centerLower[index-1] = LOWER;
			
			List<Double> upperDistances = new ArrayList<Double>(); 
			List<Double> lowerDistances = new ArrayList<Double>(); 
			for(int i=0;i<=index;i++) {
				upperDistances.add(calculateDistance(points.get(i), centerUpper));
				lowerDistances.add(calculateDistance(points.get(i), centerLower));
			}
			
			double sumUpper = 0;
			double sumLower = 0;
			
			for(int i=0;i<index;i++) {
				sumUpper += Math.abs(upperDistances.get(i)-upperDistances.get(i+1));
				sumLower += Math.abs(lowerDistances.get(i)-lowerDistances.get(i+1));
			}
			
			if(sumLower > sumUpper)
				LOWER = center[index-1]; 
			else if(sumUpper > sumLower)
				UPPER = center[index-1];
			center[index-1] = (UPPER+LOWER)/2.0;
		}
		
		return center;
	}
	
	public static double[] calculateNewPoint(List<double[]> points, double[] center, int pointIndex) {
		double UPPER = SIDE;
		double LOWER = 0.0;
		
		double[] newPoint = copyArray(center);
		newPoint[pointIndex] = (UPPER-LOWER)/2.0;
		double distance = calculateDistance(points.get(0),newPoint);
		while(Math.abs(distance - SIDE) > EPSILON_TOLERANCE) {
			if(distance > SIDE) 
				UPPER = newPoint[pointIndex];
			else if(distance < SIDE)
				LOWER = newPoint[pointIndex];
			newPoint[pointIndex] = (UPPER  + LOWER)/2.0;
			distance=calculateDistance(points.get(0),newPoint);
		}
		return newPoint;
	}
	
	public static double calculateDistance(double[] a, double[] b) {
		double sum = 0.0;
		for(int i=0;i<Math.min(a.length, b.length);i++)
			sum+=(a[i]-b[i])*(a[i]-b[i]);
		return sum; 
	}
}
