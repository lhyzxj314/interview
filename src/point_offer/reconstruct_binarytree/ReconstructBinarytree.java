package point_offer.reconstruct_binarytree;

import java.util.*;
/**
 * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 * 例如：输入：
 * [1,2,4,7,3,5,6,8],[4,7,2,1,5,3,8,6]
 * 返回值：
 * {1,2,3,4,#,5,6,#,7,#,#,8}
 * */
public class ReconstructBinarytree {

    /**
     * 二叉树的定义类
     * */
    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if (pre == null || vin ==null || pre.length != vin.length) {
            return null;
        }

        if (pre.length == 1) {
            TreeNode headOfSubtree = new TreeNode(vin[0]);
            return headOfSubtree;
        }
        if (pre.length >= 2) {
            TreeNode head = new TreeNode(pre[0]);
            int i = 0;
            while (vin[i] != pre[0]) {
                i++;
            }
            TreeNode leftSubtree = null;
            if (i-1 >= 0) {
                int[] vinOfLeftSubTree = Arrays.copyOfRange(vin, 0, i);
                int[] preOfLeftSubTree = Arrays.copyOfRange(pre, 1, vinOfLeftSubTree.length+1);
                leftSubtree = reConstructBinaryTree(preOfLeftSubTree, vinOfLeftSubTree);
            }
            TreeNode rightSubtree = null;
            if (i+1 <= vin.length - 1) {
                int[] vinOfRigthSubTree = Arrays.copyOfRange(vin, i+1, vin.length);
                int[] preOfRigthSubTree = Arrays.copyOfRange(pre, pre.length - vinOfRigthSubTree.length, pre.length);
                rightSubtree = reConstructBinaryTree(preOfRigthSubTree, vinOfRigthSubTree);
            }
            head.left = leftSubtree;
            head.right = rightSubtree;
            return head;
        }
        return null;
    }
}
