package binarySearch;



/**
 * Created by janet1 on 5/11/18.
 * */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
    public class closestBinarySearchTreeValeLC270 {
    public int closetBinarySearchTreeValue(TreeNode root, double target){
        if (root == null) return 0; ;
      TreeNode child = root.val < target ? root.right : root.left;
      if(child == null)  return root.val;
      int val = closetBinarySearchTreeValue(child, target);
      return Math.abs(root.val - target) < Math.abs(val - target) ? root.val : val;
        }
    }
}