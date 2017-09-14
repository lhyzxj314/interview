package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author xshrimp
 * 2017年9月14日
 */
public class IsSymmetrical {
  
    public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      TreeNode n1   = new TreeNode(5);
      TreeNode n2   = new TreeNode(5);
      TreeNode n3   = new TreeNode(5);
      TreeNode n4   = new TreeNode(5);
      TreeNode n5   = new TreeNode(5);
      TreeNode n6   = new TreeNode(5);
      
      root.left = n1;
      n1.left = n2;
      n2.left = n3;
      root.right = n4;
      n4.right = n5;
      n5.left = n6;
      
      boolean res = new IsSymmetrical().isSymmetrical(root);
      System.out.println(res);
    }
    
    boolean isSymmetrical(TreeNode root)
    {
        if (root == null)
            return true;
        
        TreeNode newTree = getMirror(root);
        List<TreeNode> order = new ArrayList<TreeNode>();
        List<TreeNode> orderSym = new ArrayList<TreeNode>();
        preOrder(root, order);
        preOrder(newTree, orderSym);
        
        if (order.size() != orderSym.size())
            return false;
        else {
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).val != orderSym.get(i).val ||
                   (order.get(i).left == null && orderSym.get(i).left != null) ||
                   (order.get(i).left != null && orderSym.get(i).left == null) ||
                   (order.get(i).right != null && orderSym.get(i).right == null) ||
                   (order.get(i).right == null && orderSym.get(i).right != null))
                  
                    return false;
            }
        }
        
        order = new ArrayList<TreeNode>();
        orderSym = new ArrayList<TreeNode>();
        midOrder(root, order);
        midOrder(newTree, orderSym);
        if (order.size() != orderSym.size())
            return false;
        else {
            for (int i = 0; i < order.size(); i++) {
              if (order.get(i).val != orderSym.get(i).val ||
                  (order.get(i).left == null && orderSym.get(i).left != null) ||
                  (order.get(i).left != null && orderSym.get(i).left == null) ||
                  (order.get(i).right != null && orderSym.get(i).right == null) ||
                  (order.get(i).right == null && orderSym.get(i).right != null))
                    return false;
            }
        }
        
        return true;
    }
    
    private void midOrder(TreeNode root, List<TreeNode> midOrder) {
        if (root == null) return;
        
        midOrder(root.left, midOrder);
        midOrder.add(root);
        midOrder(root.right, midOrder);
    }
    
     /*private void midOrderSym(TreeNode root, List<TreeNode> midOrder) {
        if (root == null) return;
        
        midOrderSym(root.right, midOrder);
        midOrder.add(root);
        midOrderSym(root.left, midOrder);
    }*/
    
     private void preOrder(TreeNode root, List<TreeNode> preOrder) {
        if (root == null) return;
        
        preOrder.add(root);
        preOrder(root.left, preOrder);
        preOrder(root.right, preOrder);
     }
    
     /*private void preOrderSym(TreeNode root, List<TreeNode> preOrder) {
        if (root == null) return;
        
        preOrder.add(root);
        preOrderSym(root.right, preOrder);
        preOrderSym(root.left, preOrder);
     }*/
    
    private TreeNode getMirror(TreeNode root) {
        if (root == null)
            return null;
        
        TreeNode newRoot = new TreeNode(root.val);
        
        newRoot.right = getMirror(root.left);
        newRoot.left  = getMirror(root.right);
        
        return newRoot;
    }
}