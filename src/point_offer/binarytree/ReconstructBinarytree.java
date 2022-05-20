package point_offer.binarytree;

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


    /**
     * 参考答案
     * */
    /**
     * 利用map便于直接根据先序遍历的值定位到中序遍历的索引
     */
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * @Author rex
     * @Date 2018/6/12 下午9:21
     * @Description 构建树
     * @param pre 先序遍历序列
     * @param in 后序遍历序列
     */
    public  TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;

    }

    /**
     * @Author rex
     * @Date 2018/6/12 下午9:20
     * @Description 递归建立树
     * @param pre 先序遍历序列
     * @param startPreIndex   子 先序遍历序列开始索引
     * @param endPreIndex  子 先序遍历序列结束索引
     * @param pre 后序遍历序列
     * @param startPreIndex   子 后序遍历序列开始索引
     * @param endPreIndex  子 后序遍历序列结束索引
     */
    private TreeNode reConstructBinaryTree(int[] pre, int startPreIndex, int endPreIndex,
                                                  int[] in, int startInIndex, int endInIndex) {
        if (startPreIndex > endPreIndex) {
            return null;
        }
        int rootValue = pre[startPreIndex];
        TreeNode root = new TreeNode(rootValue);
        int rootValueIndex = map.get(rootValue);
        // 需要多验证几步确定参数(用相对个数来确定索引，先序遍历序列不要直接去使用中序遍历的索引)
        root.left = reConstructBinaryTree(pre, startPreIndex + 1, rootValueIndex - startInIndex + startPreIndex, in, startInIndex, rootValueIndex - 1);
        root.right = reConstructBinaryTree(pre, rootValueIndex - startInIndex + startPreIndex + 1, endPreIndex, in, rootValueIndex + 1, endInIndex);
        return root;
    }
}
