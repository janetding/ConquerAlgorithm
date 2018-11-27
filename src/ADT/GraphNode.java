package ADT;

import java.util.ArrayList;

/**
 * Created by janet1 on 8/1/18.
 */
public class GraphNode {
    int value;
    ArrayList<GraphNode> neighbors; //hashmap
   // ArrayList<Pair> neighbors; //权重or not

    boolean visited;

    GraphNode(int x){
            value = x;
            neighbors = new ArrayList<GraphNode>();
    }
}
//class Pair -> { GraphNode, Weight}