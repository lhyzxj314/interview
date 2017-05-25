package fibonacci_seq;

import java.util.*;

/**
 * 变态青蛙跳
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author xshrimp 2017年5月25日
 */
public class SuperFrogJump {
	private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

	public int JumpFloorII(int target) {
		if (target == 1 || target == 2)
			return target;

		int res = 1;
		for (int i = 1; i < target; i++) {
			if (cache.get(i) == null) {
				int temp = JumpFloorII(i);
				res += temp;
			} else
				res += cache.get(i);
		}
		cache.put(target, res);
		return res;
	}

	public static void main(String[] args) {
		SuperFrogJump obj = new SuperFrogJump();
		int res = obj.JumpFloorII(31);
		System.out.println(res);
	}
}
