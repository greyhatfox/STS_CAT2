//longest sequence of ones by flipping zeros ----alright----

import java.util.*;
public class main4 {
    private static int findMax(int[] a, int k){
        int max1s=Integer.MIN_VALUE;
        int numRep=0;
        int windowStart=0;

        for(int windowEnd=0; windowEnd<a.length;windowEnd++){
            if (a[windowEnd] == 0) {
                numRep++;
            }
            while(numRep>k){
                if(a[windowStart]==0){
                    numRep--;
                }
                windowStart++;
            }

            max1s=Math.max(max1s, windowEnd-windowStart+1);
        }
        return max1s;
    }

    public static void main(String[] args){
        int[] a = new int[]{1,1,1,1,0,0,0,1,1,1,1,1,0};
        int k = 1;//noOfFlips
        int result = findMax(a,k);
        System.out.print(result);
    }
}
