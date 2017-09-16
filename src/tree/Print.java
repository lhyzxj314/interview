package tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 按之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @author xshrimp
 * 2017年9月15日
 */
public class Print {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(8);
    TreeNode n1   = new TreeNode(4);
    TreeNode n2   = new TreeNode(6);
    TreeNode n3   = new TreeNode(3);
    TreeNode n4   = new TreeNode(7);
    TreeNode n5   = new TreeNode(9);
    TreeNode n6   = new TreeNode(5);
    
    root.left = n1;
    root.right = n2;
    n1.left = n3;
    n1.right = n4;
    n2.left = n5;
    n2.right = n6;
    
    ArrayList<ArrayList<Integer>> res = new Print().print(root);
    for (ArrayList<Integer> array : res) {
      for (Integer i : array)
        System.out.print(i + " ");
      
      System.out.println();
    }
  }
  
  public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (pRoot == null)
      return result;
    
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(pRoot);
    
    boolean left2right = false;
    while (!stack.isEmpty()) {
      ArrayList<Integer> tmpArray = new ArrayList<Integer>();
      for (int i = 0; i < stack.size(); i++) {
        tmpArray.add(stack.get(i).val);
      }
      result.add(tmpArray);
      
      if (left2right) {
        LinkedList<TreeNode> tempStack = new LinkedList<TreeNode>();
        while (!stack.isEmpty()) {
          TreeNode node = stack.pop();
          if (node.left != null)
            tempStack.push(node.left);
          if (node.right != null)
            tempStack.push(node.right);
        }
        
        stack = tempStack;
        left2right = !left2right;
        
      } else {
        LinkedList<TreeNode> tempStack = new LinkedList<TreeNode>();
        while (!stack.isEmpty()) {
          TreeNode node = stack.pop();
          if (node.right != null)
            tempStack.push(node.right);
          if (node.left != null)
            tempStack.push(node.left);
        }
        
        stack = tempStack;
        left2right = !left2right;
      }
    }
    return result;
  }
}
