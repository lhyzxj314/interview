package tree;

import java.util.*;

/**
 * 层序遍历二叉树
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年6月6日
 */
public class PrintFromTopToBottom {
	
	// 借助队列实现
	public ArrayList<Integer> printFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (queue.size() != 0) {
            TreeNode node = queue.removeFirst();
            res.add(node.val);
            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);
        }
        return res;
    }
}
