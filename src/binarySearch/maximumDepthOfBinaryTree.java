package binarySearch;
import ADT.TreeNode;


/**
 * Created by janet1 on 5/31/18.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class maximumDepthOfBinaryTree {
    TreeNode root;
    public int maxDepth(TreeNode root){
    if(root == null) return 0;
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
//    int bigger = Math.max(leftDepth, rightDepth);
//    return bigger + 1;

        if (leftDepth > rightDepth) return leftDepth+1;
        else return rightDepth+1;

    }

    public static void main(String[] args) {
       maximumDepthOfBinaryTree tree = new maximumDepthOfBinaryTree();
       tree.root = new TreeNode(3);
       tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);

        System.out.println("Maximum Depth of BST is : " +
                tree.maxDepth(tree.root));
    }
}