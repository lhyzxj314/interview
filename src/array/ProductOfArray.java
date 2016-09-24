package array;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * */
public class ProductOfArray {
  
      public int[] multiply(int[] A) {
          if (A == null) return null;
          
          int len = A.length;
          int[] arr1 = new int[len];
          int[] arr2 = new int[len];
          
          int temp = 1;
          for (int i = 0; i < len; i++) {
              arr1[i] = temp;
              temp = temp * A[i];
          }
          
          temp = 1;
          for (int i = len - 1; i >= 0; i--) {
              arr2[i] = temp;
              temp = A[i] * temp;
          }
          
          for (int i = 0; i < len; i++) {
              arr1[i] = arr1[i] * arr2[i];
          }
          
          return arr1;
       }
}
