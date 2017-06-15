package tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年6月15日
 */
public class FindPath {
	private ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> stack = new ArrayList<Integer>();
	
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		if (root == null)
			return paths;

		target -= root.val;
		stack.add(root.val);;
		
		if (target == 0 && root.left == null && root.right == null)
			paths.add(new ArrayList<Integer>(stack));
		
		findPath(root.left, target);
		findPath(root.right, target);
		
		stack.remove(stack.size() - 1);
		return paths;
	}
	
	
	
	/*public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return paths;

		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		int sum = 0;
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			stack.push(node);
			sum += node.val;
			if (sum == target)
				System.out.println(Arrays.toString(stack.toArray()));

			if (node.left != null) {
				node = node.left;
			} else if (node.right != null) {
				node = root.right;
			} else {
				while (!stack.isEmpty() && stack.peek().right == null) {
					node = stack.pop();
					sum -= node.val;
				}
				node = stack.isEmpty() ? null : stack.peek().right;
			}
		}
		return paths;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n6;
		n3.left = n5;
		n3.right = n7;

		FindPath obj = new FindPath();
		ArrayList<ArrayList<Integer>> res = obj.findPath(n1, 12);
		for (ArrayList<Integer> r : res)
			System.out.println(Arrays.toString(r.toArray()));
	}
}
