package q5;

import java.awt.Color; 
import java.util.ArrayList;

/**
 * The ComplexShape class.
 * (b) ComplexShape is used to represent aggregate shapes, which are made up from
 * other shapes. To achieve this, ComplexShape uses an ArrayList called shapes.  
 * Write correct implementations of the equals and clone methods in ComplexShape.
 * (c) Write correct implementations of the addShape and draw methods in ComplexShape.
 * (f) Write an implementation of the hashCode method for the ComplexShape class.
 * @author ohsh
 */
class ComplexShape implements Shape {
	
	public void addShape(Shape s) { 
		shapes.add(s);
	}
	
	@Override
	public void draw(Color c) { 
		for (Shape s : shapes)
			s.draw(c);
	}
	
	@Override
	public Object clone() { 
		try {
			ComplexShape result = (ComplexShape) super.clone();
			result.shapes = new ArrayList<>();
			for (int i = 0; i < shapes.size(); i++)
				result.shapes.add(i, (Shape)shapes.get(i).clone());
 			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
	@Override
	public boolean equals(Object o) { 
		if (this == o) return true;
		if (!(o instanceof ComplexShape)) return false;
		ComplexShape cs = (ComplexShape) o;	
		return cs.shapes.equals(this.shapes); 
	}
	
	@Override
	public int hashCode() {
		//int result = 17;
		//result = 31 * result + shapes.hashCode();
		//return result;
		return shapes.hashCode();
	}
	
	private ArrayList<Shape> shapes = new ArrayList<>();
	
}
