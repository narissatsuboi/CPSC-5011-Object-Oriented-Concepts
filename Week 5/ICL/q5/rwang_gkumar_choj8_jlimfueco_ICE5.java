

import java.awt.Color; 
import java.util.ArrayList;


interface Shape extends Cloneable {
	public void draw(Color c);
	public Object clone();
}


public class Circle implements Shape {
	  private int r;
	  
	  public void setRadius(int r) { 
		  this.r = r; 
	  }
	  
	  public int getRadius() { 
		  return r; 
	  }
	  
	  public void draw(Color c) { 
//		  BasicGLib.drawCircle(c, r); 
	  }
	  
	  //Driver
	  
	  Circle c1 = new Circle();
	  Circle c2 = (Circle) c1.clone();
	  
	  @Override
	  public Object clone() {
		  try {
			  return super.clone();
		  } catch (CloneNotSupportedException e) {
			  throw new AssertionError();    // can’t happen
		  }	
	  }
	  
//	  Circle c = new Circle();
//	  Circle c2 = c;
//	  c2.equals(c);
	  
	  public boolean equals(Object o) { 
		  if(o == this) { 
			  return true; 
		  }
		  if(!(o instanceof Circle)) { 
			  return false; 
		  }
		  Circle c = (Circle) o;
		  return c.r == this.r;
	  }
}

class Rectangle implements Shape {
	  private int x, y;
	  public void setXY(int x, int y) { this.x = x; this.y = y; }
	  public int getX() { return x; }
	  public int getY() { return y; }
	  public void draw(Color c) { 
		  //BasicGLib.drawRect(c, x, y); 
	  }
	  public Object clone() { return null; }
	  public boolean equals(Object o) { return false; }
	}

class ComplexShape implements Shape {
  private ArrayList<Shape> shapes = new ArrayList<>();
  
  public void addShape(Shape s) { 
	  
  }
  
  public void draw(Color c) { 
	  
  }
  @Override
  public Object clone() { 
	try {
		ComplexShape cloned = (ComplexShape) super.clone();
		cloned.shapes = new ArrayList<>();
		for(int i = 0; i < shapes.size(); i++) {
			cloned.shapes.add(i, (Shape) shapes.get(i).clone());
		}
		return cloned;
	} catch (CloneNotSupportedException e) {
		throw new AssertionError();
	}
  }
  public boolean equals(Object o) { 
	  return false; 
  }
}
