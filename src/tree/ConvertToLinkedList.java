package tree;

import java.util.LinkedList;

public class ConvertToLinkedList {

  // 递归解法
  public TreeNode Convert(TreeNode node) {
    if (node == null)
      return null;

    TreeNode h1 = Convert(node.left); // 转换左子树

    if (h1 != null) {
      TreeNode leftLastNode = h1;
      while (leftLastNode.right != null)
        leftLastNode = leftLastNode.right;
      leftLastNode.right = node;
      node.left = leftLastNode;
    }

    TreeNode h2 = Convert(node.right); // 转换右子树
    if (h2 != null) {
      node.right = h2;
      h2.left = node;
    }

    return h1 != null ? h1 : node;
  }

  // 非递归解法
  public TreeNode Convert1(TreeNode node) {
    if (node == null)
      return null;

    boolean isHead = true;
    TreeNode head = null;
    TreeNode pre = null;

    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();
      if (isHead) {
        head = node;
        isHead = false;
        pre = node;
      } else {
        pre.right = node;
        node.left = pre;
        pre = node;
      }
      node = node.right;
    }
    return head;
  }

  public static void main(String[] args) {
    ConvertToLinkedList obj = new ConvertToLinkedList();

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

    /*
     * TreeNode n1 = new TreeNode(1); TreeNode n2 = new TreeNode(2); TreeNode n3 = new TreeNode(3);
     * TreeNode n4 = new TreeNode(4); TreeNode n5 = new TreeNode(5); n1.right = n2; n2.right = n3;
     * n3.right = n4; n4.right = n5;
     */
    TreeNode list = obj.Convert1(n1);
    while (list != null) {
      System.out.println(list.val);
      list = list.right;
    }

  }
}
