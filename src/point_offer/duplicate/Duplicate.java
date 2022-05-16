package point_offer.duplicate;

import java.util.HashSet;

/**
 * 题目描述：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 * 数据范围：0≤n≤10000 0≤n≤10000
 * 进阶：时间复杂度O(n) O(n) ，空间复杂度O(n) O(n)
 *
 * 示例：
 * 输入：[2,3,1,0,2,5,3]
 * 返回值：2
 * 说明：2或3都是对的
 * */
public class Duplicate {

    /**
     * 解法1: 使用Hashset
     * 时间复杂度： O(n)  空间复杂度： O(n)
      */
    public static int solution1(int[] numbers) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            Integer n = numbers[i];
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return n;
            }
        }
        return -1;
    }

    /**
     * 解法2: 因数组内的数字都在0到n-1的范围内，每个数字具有能和数组下标一一对应的特性
     * 时间复杂度： O(n)  空间复杂度： O(1)
     */
    public static int solution2(int[] numbers) {

        // 非法输入校验
        if (numbers == null ||  numbers.length == 0)
            return -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers.length - 1 || numbers[i] < 0)
                return -1;
        }

        /*
         * 开始寻找重复值
         * position-0 : (2,3,1,0,2,5) // 2 <-> 1
         *              (1,3,2,0,2,5) // 1 <-> 3
         *              (3,1,2,0,2,5) // 3 <-> 0
         *              (0,1,2,3,2,5) // already in position
         * position-1 : (0,1,2,3,2,5) // already in position
         * position-2 : (0,1,2,3,2,5) // already in position
         * position-3 : (0,1,2,3,2,5) // already in position
         * position-4 : (0,1,2,3,2,5) // nums[i] == nums[nums[i]], exit
         * */
        for (int i = 0; i < numbers.length;) {
            if (numbers[i] == i) {
                i++;
                continue;
            } else if (numbers[i] == numbers[numbers[i]]) {
                return numbers[i];
            } else if (numbers[i] != numbers[numbers[i]]) {
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return -1;

    }

}
