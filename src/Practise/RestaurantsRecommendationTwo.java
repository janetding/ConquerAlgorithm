package Practise;

/**
 * Created by janet1 on 8/24/18.
 */




import org.junit.Test;
import java.util.Comparator;
import java.util.PriorityQueue;

class RestaurantOne {
    Position position;
    double rate;

    public RestaurantOne(Position p, int rate) {
        this.position = p;
        this.rate = rate;
    }

    public RestaurantOne(int x, int y, int rate) {
        this.position = new Position(x,y);
        this.rate = rate;
    }


    @Override
    public String toString() {
        return "[x:" + this.position.x + ",y:" + this.position.y + ",rate:" + this.rate + "]";
    }
}

class PositionTwo{
    int x;
    int y;

    public PositionTwo(int x, int y) {
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

public class RestaurantsRecommendationTwo {

    @Test
    public void Test1() {

        Position homePosition = new Position(0, 0);
        int totalSteakHouses = 3;
        Restaurant[] steakHouses = new Restaurant[totalSteakHouses];
        steakHouses[0] = new Restaurant(1,2,0);;
        steakHouses[1] = new Restaurant(3,4,0);
        steakHouses[2] = new Restaurant(1,-1,0);

        int numSteakHouses = 2;

        Restaurant[] recommended = recommendedSteakHouses(steakHouses,numSteakHouses,homePosition);

        for (Restaurant r: recommended
                ) {
            System.out.println(r);;
        }

    }

    private Restaurant[] recommendedSteakHouses(Restaurant[] steakHouses, int numSteakHouses, Position homePosition) {

        PriorityQueue<Restaurant> heap = new PriorityQueue<>(new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                double dif = r1.position.getDistance(homePosition) - r2.position.getDistance(homePosition);

                if (r1.rate == r2.rate){
                    if (dif >= 0) return -1;
                    else return 1;
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

        for (Restaurant r: steakHouses
                ) {
            heap.offer(r);
            if (heap.size() > numSteakHouses){
                heap.poll();
            }
        }

        Restaurant[] recommended = new Restaurant[heap.size()];
        int i = recommended.length - 1;
        while (!heap.isEmpty()){
            recommended[i--] = heap.poll();
        }

        return recommended;
    }
}
