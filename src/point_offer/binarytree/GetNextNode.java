package point_offer.binarytree;

/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 *
 * 示例:
 * 输入:{8,6,10,5,7,9,11},8
 * 返回:9
 *
 * */
public class GetNextNode {

    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 通过对下一个节点的情况分析，主要有以下两种情况：
     *
     * 1、如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点。
     * 2、如果一个节点的右子树为空，那么需要沿着父节点的指针一直向上遍历，直到找到一个节点，它是它的父节点的左子节点。
     *    如果这样的节点存在，那么这个节点的父节点就是我们要找的下一个节点
     * */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeLinkNode res = null;

        if (pNode.right != null) {    // 如果该节点存在右子树,其下一个节点为右子树的最左节点
            TreeLinkNode tmpNode = pNode.right;
            while (tmpNode.left != null) {
                tmpNode = tmpNode.left;
            }
            res = tmpNode;
            return res;
        } else {                      // 如果该节点右子树为空
            TreeLinkNode tmpNode = pNode;
            while (tmpNode.next != null) {
                if (tmpNode.next.left == tmpNode) {
                    res = tmpNode.next;
                    return res;
                }
                tmpNode = tmpNode.next;
            }
        }

        return res;
    }
}
