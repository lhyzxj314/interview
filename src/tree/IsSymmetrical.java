package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author xshrimp
 * 2017年9月14日
 */
public class IsSymmetrical {
  
    public static void main(String[] args) {
      TreeNode root = new TreeNode(8);
      TreeNode n1   = new TreeNode(6);
      TreeNode n2   = new TreeNode(6);
      TreeNode n3   = new TreeNode(5);
      TreeNode n4   = new TreeNode(7);
      TreeNode n5   = new TreeNode(7);
      TreeNode n6   = new TreeNode(5);
      
      root.left = n1;
      root.right = n2;
      n1.left = n3;
      n1.right = n4;
      n2.left = n5;
      n2.right = n6;
      
      boolean res = new IsSymmetrical().isSymmetrical(root);
      System.out.println(res);
    }
    
    /**
     * 解法三：
     * 非递归解法
     * @param root
     * @return
     */
    boolean isSymmetrical(TreeNode root)
    {
        if (root == null)
            return true;
        
        LinkedList<TreeNode> leftStack = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rightStack = new LinkedList<TreeNode>();
        TreeNode leftNode = root;
        TreeNode rightNode = root;
        
        while (leftNode != null || !leftStack.isEmpty()) {
          while (leftNode != null) {
            
            if (rightNode == null) 
              return false;
            
            if (leftNode.val == rightNode.val) {
              leftStack.addLast(leftNode);
              leftNode = leftNode.left;
              
              rightStack.addLast(rightNode);
              rightNode = rightNode.right;
            } else {
              return false;
            }
          }
          leftNode = leftStack.pollLast().right;
          rightNode = rightStack.pollLast().left;
        }
        return true;
    }
    
    /**
     * 解法二：
     * 复制一颗新树，同步遍历的同时进行判断
     * @param root
     * @return
     */
    boolean isSymmetrical2(TreeNode root)
    {
        if (root == null)
            return true;
        
        TreeNode newTree = getMirror(root);
        boolean res = preOrderAndCompare(root, newTree);
        
        return res;
    }
    
    /**
     * 解法一:
     * 通过前序遍历、中序遍历结果判断两棵树是否对称
     * ！存在问题：所有节点的值相等的情况判断不了
     * @param root
     * @return
     */
    boolean isSymmetrical1(TreeNode root)
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
    
     private void preOrder(TreeNode root, List<TreeNode> preOrder) {
        if (root == null) return;
        
        preOrder.add(root);
        preOrder(root.left, preOrder);
        preOrder(root.right, preOrder);
     }
     
     private boolean preOrderAndCompare(TreeNode root, TreeNode newRoot) {
       if (root == null && newRoot == null) return true;
       
       if ((root.left == null && newRoot.left != null) ||
           (root.left != null && newRoot.left == null) ||
           (root.right != null && newRoot.right == null) ||
           (root.right == null && newRoot.right != null) ||
           root.val != newRoot.val)
         return false;
       
       boolean flag1 = preOrderAndCompare(root.left, newRoot.left);
       boolean flag2 = preOrderAndCompare(root.right, newRoot.right);
       return flag1 && flag2;
    }
    
    private TreeNode getMirror(TreeNode root) {
        if (root == null)
            return null;
        
        TreeNode newRoot = new TreeNode(root.val);
        
        newRoot.right = getMirror(root.left);
        newRoot.left  = getMirror(root.right);
        
        return newRoot;
    }
}