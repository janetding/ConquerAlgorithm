package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class paretoOptimalNum {
    public List<Point> paretoPoints(Point[] points) {
        List<Point> result = new ArrayList<>();

        if (points == null || points.length == 0) return result;
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.equals(p2)) {
                    return 0;
                }
                if (p1.getX() == p2.getX()) {
                    if (p1.getY() == p2.getY()) {
                        return 0;
                    } else if (p1.getX() > p2.getX())

                        return p1.getY() < p2.getY() ? 1 : -1;
                    } else {
                        return p1.getX() < p2.getX() ? 1 : -1;
                    }

                return 0;
            }
        });


        int maxHeight = Integer.MIN_VALUE;

        for (Point p : points) {
            if (result.size() == 0 || p.getY() > maxHeight) {
                result.add(p);
                maxHeight = p.getY();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Point[] input = new Point[5];
        input[0] = new Point(1, 0);
        input[1] = new Point(-1, 2);
        input[2] = new Point(0, 1);
        input[3] = new Point(2, -1);
        input[4] = new Point(1, 1);
        paretoOptimalNum pareto = new paretoOptimalNum();
        System.out.println("Pareto optimal nums: ");
        System.out.println(pareto.paretoPoints(input));

    }
}





