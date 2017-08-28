package tree;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author xshrimp
 * 2017年8月28日
 */
public class Mirror {
  public void mirror(TreeNode root) {
    if (root == null)
      return;
    
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    mirror(root.left);
    mirror(root.right);
  }
  
}
