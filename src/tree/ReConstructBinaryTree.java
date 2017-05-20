package tree;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author xshrimp 2017年5月20日
 */
public class ReConstructBinaryTree {
  public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    if (pre == null || in == null)
      return null;

    TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

    return root;
  }

  private TreeNode reConstructBinaryTree(int[] pre, int pStart, int pEnd, int[] in, int iStart,
      int iEnd) {
    if (pStart == pEnd)
      return new TreeNode(pre[pStart]);
    if (pStart > pEnd)
      return null;

    TreeNode root = new TreeNode(pre[pStart]); // 前序遍历首元素为根节点
    int leftNum = 0; // 左子树节点数目
    int rootIndex = 0; // 根节点在中序遍历结果中的位置
    for (int i = iStart; i <= iEnd; i++) {
      if (in[i] == root.val) {
        rootIndex = i;
        leftNum = rootIndex - iStart;
        break;
      }
    }

    root.left = reConstructBinaryTree(pre, pStart + 1, pStart + leftNum, in, iStart, rootIndex - 1);
    root.right = reConstructBinaryTree(pre, pStart + leftNum + 1, pEnd, in, rootIndex + 1, iEnd);

    return root;
  }
}

// Definition for binary tree
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}