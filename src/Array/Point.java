package Array;

/**
 * Created by janet1 on 6/18/18.
 */

public class Point {
    private int x; // x coordinate
    private int y; // y coordinate

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other == this)
            return true;
        if (!(other instanceof Point))
            return false;
        Point o = (Point) other;
        return x == o.getX() && y == o.getY();
    }

    //help to display a point's X and Y value
    //W/O, it will display all address, instead of correct format


    @Override
    public String toString() {
        return "[" + this.getX() + "," + this.getY() + "]" ;
    }
}
