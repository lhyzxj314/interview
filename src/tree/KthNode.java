package tree;

/**
 * 二叉搜索树的第k个节点
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * @author xshrimp
 * 2017年9月20日
 */
public class KthNode {
  private int n = 0;
  private TreeNode result;
  
  TreeNode kthNode(TreeNode pRoot, int k)
  {
    if (pRoot == null)
      return null;
    
    midTraverse(pRoot, k);
    return result;
  }
  
  private void midTraverse(TreeNode root, int k) {
    if (root == null)
      return;
    
    midTraverse(root.left, k);
    n++;
    if (n == k && root != null) {
      result = root;
      return;
    }
    midTraverse(root.right, k);
  }
  
  public static void main(String[] args) {
    Serialization s = new Serialization();
    String str = "8,6,10,5,7,9,11";
    TreeNode pRoot = s.Deserialize(str);
    
    TreeNode node = new KthNode().kthNode(pRoot, 1);
    System.out.println(node.val);
  }
}
