package tree;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author xshrimp
 * 2017年7月25日
 */
public class HasSubtreeSolution {
  
  public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    if (root1 == null || root2 == null)
      return false;
    
    if (root1.val == root2.val && isSame(root1, root2))
      return true;
      
    boolean leftFlag = HasSubtree(root1.left, root2);
    if (leftFlag)
      return true;
    else
      return HasSubtree(root1.right, root2);
  }
  
  private boolean isSame(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 != null)
      return false;
    else if (root2 == null)
      return true;
    else if (root1.val != root2.val)
      return false;
    
    boolean leftFlag = isSame(root1.left, root2.left);
    boolean rightFlag = isSame(root1.right, root2.right);
    return leftFlag && rightFlag;
  }
  
  public static void main(String[] args) {
   /* TreeNode root1 = new TreeNode(8);
    TreeNode n1    = new TreeNode(8);
    TreeNode n2    = new TreeNode(7);
    TreeNode n3    = new TreeNode(9);
    TreeNode n4    = new TreeNode(2);
    TreeNode n5    = new TreeNode(4);
    TreeNode n6    = new TreeNode(7);
    root1.left = n1;
    root1.right = n2;
    n1.left = n3;
    n1.right = n4;
    n4.left = n5;
    n4.right = n6;
    
    TreeNode root2 = new TreeNode(8);
    TreeNode nn1   = new TreeNode(9);
    TreeNode nn2   = new TreeNode(2);
    root2.left = nn1;
    root2.right = nn2;*/
    
    TreeNode root1 = new TreeNode(8);
    TreeNode n1    = new TreeNode(8);
    TreeNode n2    = new TreeNode(9);
    TreeNode n3    = new TreeNode(2);
    TreeNode n4    = new TreeNode(5);
    root1.left = n1;
    n1.left = n2;
    n2.left = n3;
    n3.left = n4;
    
    TreeNode root2 = new TreeNode(8);
    TreeNode nn1   = new TreeNode(9);
    TreeNode nn2   = new TreeNode(3);
    root2.left = nn1;
    nn1.left = nn2;
    
    HasSubtreeSolution obj = new HasSubtreeSolution();
    boolean res = obj.HasSubtree(root1, root2);
    System.out.println(res);
  }
}
