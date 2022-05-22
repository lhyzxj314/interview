package point_offer.search;


/**
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，
 * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 问，给定这样一个旋转数组，求数组中的最小值。
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {

        if (array == null || array.length == 0)
            return 0;

        int i = 0;
        int j = array.length - 1;

        if (array[i] < array[j]) {   // 没有进行旋转的数组,第一个元素即是最小值
            return array[i];
        }

        while (j - i > 1) {
            int mid = (j - i) / 2 + i;
            if (array[mid] < array[i])
                j = mid;
            else if (array[mid] > array[i])
                i = mid;
            else if (array[mid] == array[i]) {
                if (array[mid] > array[j])
                    i = mid;
                else if (array[mid] == array[j]) {    // array[i]、array[j]、array[mid]相等，只能从头至尾逐个查找
                    int min = array[i];
                    for (int index = i; index < j; index++) {
                        if (array[index] < min) {
                            min = array[index];
                        }
                    }
                    return min;
                }
            }
        }

        return array[j];
    }
    
}
