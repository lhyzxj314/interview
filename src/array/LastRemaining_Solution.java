package array;

/**
 * 圆圈中最后剩下的数
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年7月6日
 */
public class LastRemaining_Solution {
	
	public int lastRemaining_solution(int n, int m) {
		if (n == 1)
			return 0;
		if (m == 1) {
			return 0;
		}
		if (n == 0 || m == 0)
			return -1;
		
		// 构建环
		KidCircle first = new KidCircle(0);
		KidCircle preKid = first;
		for (int i = 1; i < n; i++) {
			KidCircle kid = new KidCircle(i);
			preKid.next = kid;
			preKid = kid;
			if (i == n - 1)
				kid.next = first;
		}
		// 开始游戏
		KidCircle kid = first;
		while (kid.next != kid) {
			// 找到需要唱歌的小盆友的前一个小盆友
			for (int i = 0; i < m - 2; i++)
				kid  = kid.next;
			// 出列
			KidCircle temp = kid.next.next;
			kid.next = temp;
			kid = temp;
		}
		return kid.id;
	}
	
	private static class KidCircle {
		int id;
		KidCircle next;
		public KidCircle(int id) {
			this.id = id;
		}
		
		@Override
		public String toString() {
			return id + "";
		}
	}
	
	public static void main(String[] args) {
		LastRemaining_Solution obj = new LastRemaining_Solution();
		int res = obj.lastRemaining_solution(5, 2);
		System.out.println(res);
	}
}

