package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janet1 on 5/11/18.
 */
//sliding window
public class ClosestBinarySearchTreeValueIILC272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k){
        List<Integer> rest = new ArrayList<>();
        if ( root == null || k < 0) return rest;
        help (root, target, k, rest);
        return rest;
    }

    private void help( TreeNode root, double target, int k, List<Integer> rest) {
        if (root == null) return;
        help(root.left, target, k, rest);
        if (rest.size() == k && Math.abs(rest.get(0) - target) >
                Math.abs(root.val - target)) rest.remove(0);
        if (rest.size() < k) rest.add(root.val);
        help(root.right, target, k, rest);
    }
}
