package Practise;

/**
 * Created by janet1 on 8/24/18.
 */


import org.junit.Test;
import java.util.Comparator;
import java.util.PriorityQueue;

class Restaurant {
    Position position;
    double rate;

    public Restaurant(Position p, int rate) {
        this.position = p;
        this.rate = rate;
    }

    public Restaurant(int x, int y, int rate) {
        this.position = new Position(x,y);
        this.rate = rate;
    }

}

class Position{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double getDistance(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    double getDistance(Position p2){
        return Math.sqrt(Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2));
    }
}

public class RestaurantsRecommendation {

    @Test
    public void Test1() {

        Position target = new Position(10, 10);
        PriorityQueue<Restaurant> heap = new PriorityQueue<>(new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                double dif = r1.position.getDistance(target) - r2.position.getDistance(target);

                if (r1.rate == r2.rate){
                    if (dif >= 0) return 1;
                    else return -1;
                }else if (dif == 0){
                    if (r1.rate >= r2.rate) return 1;
                    else return -1;
                }else if (r1.rate > r2.rate){
                    if (dif >= 5){ //If the distance between r1 and target is more than 5 miles than r2, recommend r2.
                        return -1;
                    }else {
                        return 1;
                    }
                }else if (dif < 5){
                    if (r1.rate >= r2.rate) return 1;
                    else return -1;
                }


                return 1;
            }
        });
    }
}
