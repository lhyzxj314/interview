package array;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1], 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class ProductOfArray {

  public int[] multiply(int[] A) {
    if (A == null)
      return null;

    int len = A.length;
    int[] forward = new int[len];
    int[] backward = new int[len];
    forward[0] = 1;
    backward[len - 1] = 1;

    for (int i = 1; i < len; i++) {
      forward[i] = forward[i - 1] * A[i - 1];
      backward[len - 1 - i] = backward[len - i] * A[len - i];
    }

    for (int i = 0; i < len; i++)
      forward[i] = forward[i] * backward[i];

    return forward;
  }
}