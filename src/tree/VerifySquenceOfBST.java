package tree;

/**
 * 二叉查找树的后序遍历序列是否合法
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年6月6日
 */
public class VerifySquenceOfBST {

	/**
	 * 递归解法
	 * @date 2017年6月6日
	 */
	public boolean verifySquenceOfBST1(int[] sequence) {
		if (sequence == null || sequence.length == 0)
			return false;
		return verify(sequence, 0, sequence.length - 1);
	}

	private boolean verify(int[] seq, int start, int end) {
		if (start >= end) // 递归终止条件
			return true;

		int rootVal = seq[end]; // 根节点的值

		int leftEnd = 0;        // 左子树序列结束索引
		int rightStart = 0;     // 右子树序列开始索引

		// 检查左右子树序列是否合法
		int count = 0;
		for (int i = start; i < end - 1; i++) {
			if (seq[i] < rootVal && seq[i + 1] > rootVal) {
				leftEnd = i;
				rightStart = i + 1;
				count++;
				if (count > 1)
					return false;
			} else if (seq[i] > rootVal && seq[i + 1] < rootVal) {
				return false;
			}
		}
		boolean leftRes = verify(seq, start, leftEnd);
		boolean rightRes = verify(seq, rightStart, end - 1);
		
		if (leftRes && rightRes)
			return true;
		else
			return false;
	}
	
	/**
	 * 非递归解法
	 * @date 2017年6月6日
	 */
	public boolean verifySquenceOfBST2(int[] sequence) {
		if (sequence == null || sequence.length == 0)
			return false;
		
		int size = sequence.length;
		int rootVal = sequence[size-1];
		while (size-- > 0) {
			int count = 0;
			for (int i = 0; i < size - 1; i++) {
				if (sequence[i] < rootVal && sequence[i+1] > rootVal)
					count++;
				else if (sequence[i] > rootVal && sequence[i+1] < rootVal)
					return false;
				if (count > 1)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		VerifySquenceOfBST obj = new VerifySquenceOfBST();
		boolean res = obj.verifySquenceOfBST2(new int[] { 7, 4, 6, 5 });
		System.out.println(res);

	}
}
