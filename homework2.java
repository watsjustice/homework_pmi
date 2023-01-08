//2 задания сo *

import java.util.Arrays;

public class Main {
   public static void main(String[] args) throws Exception {
      
      //5
      int[] MaxArr = {1, 4, 3, 7, 4, 8, 10, 23, 5, 8, 19};
            int max = 0;
            int min = Integer.MAX_VALUE;
     
            for (int element : MaxArr) {
                if (element > max) max = element;
                if (element < min) min = element;
            }
            System.out.println(max);
            System.out.println(min);
     
     //6
     public static boolean checkBalance(int [] array){
       
        int center = (array.length % 2 == 0) ? array.length / 2 - 1 : array.length / 2;
        int leftside = 0;
        int rightside = 0;

        for (int i = 0; i < array.length; i++) {
            if (i <= center) leftside += array[i];
            if (i > center) rightside += array[i];
        }

        return leftside == rightside;
    }
