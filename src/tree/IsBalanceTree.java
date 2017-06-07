package tree;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author xshrimp
 * 2017年6月7日
 */
public class IsBalanceTree {
  // 解法一
  public boolean IsBalanced_Solution1(TreeNode root) {
    if (root == null)
      return true;

    boolean left  = IsBalanced_Solution1(root.left);
    boolean right = IsBalanced_Solution1(root.right);
    if (left && right) {
      int leftDepth  = getDepth1(root.left);
      int rightDepth = getDepth1(root.right);
      int diff = Math.abs(leftDepth - rightDepth);
      return diff <= 1 ? true : false;
    }
    return false;
  }

  public int getDepth1(TreeNode root) {
    if (root == null)
      return 0;

    int leftDepth  = getDepth1(root.left);
    int rightDepth = getDepth1(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
  }
  
  // 解法二
  boolean res = true;
  public boolean IsBalanced_Solution2(TreeNode root) {
    if (root == null)
      return true;
    
    verify(root);
    return res;
  }

  private int verify(TreeNode root) {
    if (root == null)
      return 0;

    int leftDepth  = verify(root.left);
    int rightDepth = verify(root.right);
    
    if (Math.abs(leftDepth - rightDepth) > 1)
      res = false;
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
