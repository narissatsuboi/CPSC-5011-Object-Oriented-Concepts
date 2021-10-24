package ambrosem_syee_ICL5;

public class NegativeInteger {
	private int v;
	
	  public NegativeInteger() { 
		  this.v = -1;
	  }
	  
	  public boolean equals (Object that) { 
		  return true; //compareTo(that);
		  
	  }
	  
	  public void set(int v) throws IllegalArgumentException {
		  if(v >= 0)
			  throw new IllegalArgumentException();
		  else {
			  this.v = v;
		  }
	  }
	  
	  public int get() {
		return v;
	  }
	}

