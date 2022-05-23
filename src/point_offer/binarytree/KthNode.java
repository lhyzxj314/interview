package point_offer.binarytree;

/**
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第k小的TreeNode结点值。
 * 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
 * 3.保证n个节点的值不一样
 *
 * 示例：如输入{5,3,7,2,4,6,8},3时，该二叉树所有节点按结点值升序排列后可得[2,3,4,5,6,7,8]，
 * 所以第3个结点的结点值为4，故返回对应结点值为4的结点即可
 */
public class KthNode {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 自己的解法：统计左子树的节点个数，和K进行大小比较，若比K小则在左子树中搜素目标值，否则在右子树中进行搜素
     * 时间复杂度：当树退化，变成左倾树（单链表），出现最坏情况O(n^2)。
     *           可用辅助map来保存计算中间结果，实现O(n)，待实现
     * 空间复杂度： O(1)
     * @param proot
     * @param k
     * @return
     */
    public int KthNode (TreeNode proot, int k) {
        if (proot == null || k == 0)
            return -1;

        int left_count = count(proot.left);

        if (left_count == k - 1)
            return proot.val;
        else if (left_count + 1 > k) {
            int val = KthNode(proot.left, k);
            return val;
        } else if (left_count + 1 < k) {
            int right_count = count(proot.right);
            if (k > left_count + right_count + 1) {
                return -1;
            } else {
                int val = KthNode(proot.right, k - (left_count + 1));
                return val;
            }
        }

        return -1;
    }

    private int count(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left_count = 0;
        int right_count = 0;
        if (root.left != null)
            left_count = count(root.left);
        if (root.right != null)
            right_count = count(root.right);
        int sum = left_count + right_count + 1;
        return sum;
    }


    /**
     * 解法二：利用二叉搜索树 的中序遍历顺序即为升序排列这一特性
     */
    private int k;

    public int KthNode1(TreeNode proot, int k) {
        if (proot == null || k == 0)
            return -1;

        this.k = k;

        int target = searchByMidOrderIterate(proot);
        return target;
    }


    private int searchByMidOrderIterate(TreeNode root) {
        int target = -1;
        if (root.left != null) {
            target = searchByMidOrderIterate(root.left);
        }

        if (target == -1) {
            if (k == 1) {
                target = root.val;
            }
            k--;     // 一个节点遍历结束，k计数器减1
        }

        if (target == -1 && root.right != null) {
            target = searchByMidOrderIterate(root.right);
        }
        return target;
    }
}
