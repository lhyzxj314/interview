package netease;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int k = Integer.parseInt(firstLine.split(" ")[1]);
        
        int[] elems = new int[n];
        String[] elemsStr = secondLine.split(" ");
        for (int i = 0; i < elemsStr.length; i++) {
            elems[i] = Integer.parseInt(elemsStr[i]);
        }
        
        for (int i = 0; i < k; i++) {
            int firstElem = elems[0];
            for (int j = 0; j < n; j++) {
                if (j != n -1)
                  elems[j] = (elems[j] + elems[j+1]) % 100;
                else
                  elems[j] = (elems[j] + firstElem) % 100; 
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i == n - 1)
                System.out.print(elems[i]);
            else
              System.out.print(elems[i] + " ");
        }
    }
}