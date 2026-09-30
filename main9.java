//Find max eq sum  ----easy weird----

import java.util.*;

class Main {

    static int findMaxSum(int[] arr, int n) {

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }

        int leftSum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int rightSum = total - leftSum - arr[i];

            if (leftSum == rightSum) {
                ans = Math.max(ans, leftSum);
            }

            leftSum += arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {-2, 5, 3, 3, 2, 6, -4, 2};

        int n = arr.length;

        System.out.println(findMaxSum(arr, n));
    }
}
