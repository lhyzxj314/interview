package point_offer.binarytree;

import java.util.*;

/**
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 */
public class PrintTree {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 通过队列实现层序遍历，将偶数层的打印结果反转
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
            return res;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int level = 1;   // 记录当前遍历层数
        while ( ! queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.removeFirst();
                temp.add(node.val);
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }

            if (level % 2 == 1) {
                res.add(temp);
            } else {         // 将偶数层的打印结果反转
                ArrayList<Integer> reverseList = new ArrayList<Integer>();
                for (int i = temp.size() - 1; i >= 0; i--) {
                    reverseList.add(temp.get(i));
                }
                res.add(reverseList);
            }
            level++;
        }

        return res;
    }
}
