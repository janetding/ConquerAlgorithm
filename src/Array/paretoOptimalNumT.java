package Array;

import java.util.*;

/**
 * Created by janet1 on 6/18/18.
 */
public class paretoOptimalNumT {
    public List<Point> paretoPoints(Point[] points)  {
        if (points == null || points.length <= 1){
            throw new UnsupportedOperationException("Not implemented");
        }

    //if duplicate points exist, exist in given set, throw exception
        HashSet<Point> set  = new HashSet<>();
        for (Point p : points){
            if(!set.contains(p)) set.add(p);
            else
                throw new UnsupportedOperationException("Duplicate elements exists");
        }
        System.out.println("Before sorting : ");
        //override toString method in Point class to display a point's X and Y value respectively
        System.out.println(Arrays.toString(points));

        System.out.println("After sorting: ");
        List<Point> pointList = new ArrayList<>();
        pointList = Arrays.asList(points);

        /** sort the points by point's X value in descending order, if two's x value equal; then sort
         * them by their Y value in descending order
         */


  Collections.sort(pointList, new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                if(o1.getX() == o2.getX()){
                    //descending order
                    return -Integer.compare(o1.getY(),o2.getY());
                }else{
                return -Integer.compare(o1.getX(), o2.getX());
            }
            }
        });
        System.out.println(pointList);

        List<Point> paretoPoint = new ArrayList<>();
        Point firstParetPoint = pointList.get(0);
        paretoPoint.add(firstParetPoint) ;
        int curHighestValue = firstParetPoint.getY();

        for (int i = 1; i < pointList.size(); i++) {
            Point temp = pointList.get(i);
            Point tempPre = pointList.get(i-1);
            if(temp.equals(tempPre)) continue;
            else if (temp.getY() > curHighestValue){
                paretoPoint.add(temp);
                curHighestValue = temp.getY();
            }
        }
        System.out.println("The pareto points are: ");
        return paretoPoint;
    }

    public static void main(String[] args)  {
        Point[] input = new Point[5];
        input[0] = new Point(1, 0);
        input[1] = new Point(-1, 2);
        input[2] = new Point(0, 1);
        input[3] = new Point(2, -1);
        input[4] = new Point(1, 1);
        paretoOptimalNumT pareto = new paretoOptimalNumT();
        System.out.println(pareto.paretoPoints(input));
    }
}