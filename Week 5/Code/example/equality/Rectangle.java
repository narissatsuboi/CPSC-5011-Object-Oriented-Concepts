package example.equality;

import java.util.Objects;

public class Rectangle {
    
    public Rectangle(int l, int w) {
        length = l;
        width = w;
    }    
        
    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rectangle)) 
            return false;        
        Rectangle other = (Rectangle) obj;
        return length == other.length && width == other.width;
    }

    @Override public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rectangle [length=");
        builder.append(length);
        builder.append(", width=");
        builder.append(width);
        builder.append("]");
        return builder.toString();
    }

    private int length;
    private int width;
    
}
