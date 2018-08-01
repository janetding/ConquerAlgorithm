package ADT;

import java.util.ArrayList;

/**
 * Created by janet1 on 8/1/18.
 */
public class GraphNode {
    int value;
    ArrayList<GraphNode> neighbors; //hashmap

    boolean visited;

    GraphNode(int x){
            value = x;
            neighbors = new ArrayList<GraphNode>();
    }
}
