package temp;

import java.util.LinkedList;

public class Test {

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(5);
    TreeNode n2 = new TreeNode(3);
    TreeNode n3 = new TreeNode(9);
    TreeNode n4 = new TreeNode(2);
    TreeNode n5 = new TreeNode(7);
    TreeNode n6 = new TreeNode(4);
    TreeNode n7 = new TreeNode(10);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n6;
    n3.left = n5;
    n3.right = n7;
    midTraverse(n1);
  }

  private static void midTraverse(TreeNode p) {
    if (p == null)
      return;

    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    while (p != null) {
      while (p != null) {
        if (p.right != null)
          stack.push(p.right); // 当前节点右子入栈
        stack.push(p);         // 当前节点入栈
        p = p.left;
      }
      p = stack.pop();
      while (!stack.isEmpty() && p.right == null) {
        System.out.println(p.val);
        p = stack.pop();
      }
      System.out.println(p.val);
      if (!stack.isEmpty())
        p = stack.pop();
      else
        p = null;
    }
  }
}

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;

  public TreeNode(int val) {
    this.val = val;

  }

}