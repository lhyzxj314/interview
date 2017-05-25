package temp;

public class Main1 {
  public int JumpFloor(int target) {
    int i = target;
    int j = 0;
    int count = 0;
    while (i >= 0) {
      int sum = i + j;
      count += comb(sum, j);
      i = i - 2;
      j++;
    }
    return count;
  }
  
  int comb(int m, int n) {
    int i = m;
    int j = 0;
    int sum = 1;
    for (; j < n; j++, i--)
      sum = sum * i / (j + 1);
    return sum;
  }

  public static void main(String[] args) {
    Main1 t = new Main1();
    //int res = t.comb(15,14);
    int res = t.JumpFloor(30);
    System.out.println(res);
  }
}
