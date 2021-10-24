package q5;

import java.awt.Color; 

interface Shape extends Cloneable {
	public void draw(Color c);
	public Object clone();
}
