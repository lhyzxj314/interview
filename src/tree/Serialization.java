package tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 树的序列化
 * @author xshrimp
 * 2017年9月20日
 */
public class Serialization {
  String Serialize(TreeNode root) {
    if (root == null)
      return null;

    StringBuilder sb = new StringBuilder();
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        sb.append(",#");
      } else {
        sb.append("," + node.val);
        if (node.left == null && node.right == null) {
          continue;
        } else {
          queue.offer(node.left);
          queue.offer(node.right);
        }
      }
    }

    sb.deleteCharAt(0);
    return sb.toString();
  }

  TreeNode Deserialize(String str) {
    if (str == null || str.trim().isEmpty())
      return null;

    // 解析
    String[] valsStr = str.split(",");
    int len = valsStr.length;
    int[] vals = new int[len];
    for (int i = 0; i < len; i++) {
      if ("#".equals(valsStr[i]))
        vals[i] = Integer.MIN_VALUE;
      else
        vals[i] = Integer.valueOf(valsStr[i]);
    }

    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    TreeNode root = new TreeNode(vals[0]);
    queue.offer(root);
    int i = 0;
    while (!queue.isEmpty() && i < len) {
      TreeNode node = queue.poll();
      
      i++;
      if (i < len) {
        if (vals[i] == Integer.MIN_VALUE)
          node.left = null;
        else {
          TreeNode tempNode = new TreeNode(vals[i]);
          node.left = tempNode;
          queue.offer(tempNode);
        }
      }
      
      i++;
      if (i < len) {
        if (vals[i] == Integer.MIN_VALUE)
          node.right = null;
        else {
          TreeNode tempNode = new TreeNode(vals[i]);
          node.right = tempNode;
          queue.offer(tempNode);
        }
      }
    }
    return root;
  }

  public static void main(String[] args) {
    Serialization o = new Serialization();
    String str = "8,6,10,5,7,9,11";
    TreeNode root = o.Deserialize(str);
    PrintFromTopToBottom o1 = new PrintFromTopToBottom();
    ArrayList<Integer> result = o1.printFromTopToBottom1(root);
    for (Integer i : result) {
      System.out.print(i + " ");
    }

    System.out.println();

    String res = o.Serialize(root);
    System.out.println(res);
  }
}
