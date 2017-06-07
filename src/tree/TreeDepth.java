package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度： 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * @author xshrimp 2017年6月7日
 */
public class TreeDepth {
  // 递归解法
  public int treeDepth1(TreeNode root) {
    if (root == null)
      return 0;

    int leftDepth = treeDepth1(root.left);
    int rightDepth = treeDepth1(root.right);
    int depth = Math.max(leftDepth, rightDepth) + 1;
    return depth;
  }

  // 非递归解法
  public int treeDepth2(TreeNode root) {
    if (root == null)
      return 0;

    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    q.offer(new TreeNode(Integer.MIN_VALUE)); // 设置特殊节点确定节点所在层数
    int depth = 0;
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      
      if (node.val == Integer.MIN_VALUE) {
        depth++;
        if (!q.isEmpty())
          q.offer(new TreeNode(Integer.MIN_VALUE));
        
      } else {
        if (node.left != null)  q.offer(node.left);
        if (node.right != null) q.offer(node.right);
      }
    }
    return depth;
  }

}
