package bloch;

import java.awt.Color;
import java.util.Objects;

/**
 * Adds a value component without violating the equals contract.
 * @param x
 * @param y
 * @param color
 */
public class ColorPointFix {
    private final Point point;
    private final Color color;
    
    public ColorPointFix(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }
    
    /**
     * Returns the point-view of this color point.
     * @return
     */
    public Point asPoint() {
        return point;
    }
    
    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPointFix))
            return false;
        ColorPointFix cp = (ColorPointFix) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
