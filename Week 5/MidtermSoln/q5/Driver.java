package q5;

/**
 * (d) Write a fragment of Java code — using the classes Circle, Rectangle and 
 * ComplexShape — to create a complex shape object named “myShape” that contains:
 * - A circle of radius 4 with center at (0,0)
 * - A circle of radius 6 with center at (0,0)
 * - A square of side 10 with lower left corner at (0,0)
 * 
 * @author ohsh
 */
public class Driver {
	public static void main(String [] args) {
		ComplexShape myShape = new ComplexShape();
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		Rectangle r = new Rectangle();
		c1.setRadius(4);
		c2.setRadius(6);
		r.setXY(10, 10);		
		myShape.addShape(c1);
		myShape.addShape(c2);
		myShape.addShape(r);
	}
	
}
