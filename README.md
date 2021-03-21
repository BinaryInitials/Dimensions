# Dimensions
Tool that calculates Euclidian coordinates of a n-equidistant system in a n-1 dimensional manifold.


Examples: 

For n=1:
<br>`java -jar runnable.jar 1`
<br>yields the following output:
```
Coordinates for a 1 dimensionsal manifold:
A=	(0.0)
B=	(1.0)
```
This essentially means that in a 1 dimensional universe normalized with a radius of 1, the coordinates of the 2-point system are (0), and (1). Or in other words: 2 points in a line.

For n=2:
<br>`java -jar runnable.jar 2`
<br>yields the following output:
```
Coordinates for a 2 dimensionsal manifold:
A=	(0.0,0.0)
B=	(1.0,0.0)
C=	(0.5,0.8660254037844386)
```
This essentially means that in a 2 dimensional universe normalized with a radius of 1, the coordinates of the 3-point system are `(0,0)`, `(1,0)`, and `(1/2, sqrt(3)/2)`. Or in other words: 3 points in an equilateral triangle.

For n=3:
<br>`java -jar runnable.jar 3`
<br>yields the following output:
```
Coordinates for a 3 dimensionsal manifold:
A=	(0.0,0.0,0.0)
B=	(1.0,0.0,0.0)
C=	(1.0,0.8660254037844386,0.0)
D=	(1.0,0.28867513459481287,0.816496580927726)
```
This essentially means that in a 3 dimensional universe normalized with a radius of 1, the coordinates of the 4-point system are `(0,0,0)`, `(1,0,0)`, `(1/2, sqrt(3)/2,0)`, and `(1/2, sqrt(3)/6, 2/sqrt(6))`. Or in otherwords: 4 points in a tetrahedron. Fun fact, 4 is the maximum number that we can position objects equidistant from one another. In order to position 5 or more equidistant objects, one would need additional dimensions. 

In order to calculate the coordinates of such dimensions, I created this tool. 

The process is iterative and as follows:
1. Use the previous coordinates, 
2. calculate the center of gravity, and finally 
3. calculate the projection in the new dimension. 
4. Ba-dam-bim Ba-da-boom
