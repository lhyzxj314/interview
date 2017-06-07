package tree;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author xshrimp
 * 2017年6月7日
 */
public class IsBalanceTree {
  public boolean IsBalanced_Solution(TreeNode root) {
    if (root == null)
      return true;

    boolean left  = IsBalanced_Solution(root.left);
    boolean right = IsBalanced_Solution(root.right);
    if (left && right) {
      int leftDepth  = getDepth(root.left);
      int rightDepth = getDepth(root.right);
      int diff = Math.abs(leftDepth - rightDepth);
      return diff <= 1 ? true : false;
    }
    return false;
  }

  public int getDepth(TreeNode root) {
    if (root == null)
      return 0;

    int leftDepth  = getDepth(root.left);
    int rightDepth = getDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
