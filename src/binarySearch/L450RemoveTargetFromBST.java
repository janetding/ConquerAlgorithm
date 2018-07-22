package binarySearch;

/**
 * Created by janet1 on 7/22/18.
 */
 


   // L450 Remove target from BST（重要）
//先找到和target值相等所在的node。如果是大于／小于target的话，采用recursion的方式，往左子树／右子树方向找。如果是等于target的话，表示已经locate到了需要delete的那个node。此时还有三种情况：a）左子树和右子树都不为空，b）左子树为空，c）右子树为空
   public class L450RemoveTargetFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val < key){
            root.right = deleteNode(root.right, key);//需要删出的node在右边，所以只要recursion call下去，右边传上来的就是删除好的版本
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);//和右边的情况一样
        }else{
            if(root.left != null && root.right != null){//两边子树都不为空的情况
                root.val = findSmallestInRight(root.right).val;//也可以从左边找最大的
                root.right = deleteNode(root.right, root.val);
            }else{
                root = root.left == null ? root.right : root.left;//
            }
        }
        return root;
    }
    private TreeNode findSmallestInRight(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
