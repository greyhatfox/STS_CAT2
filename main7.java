//max sub prod ----alright----

import java.util.*;

class main7 {

    static int maxSubarrayProduct(int arr[], int n) {

        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {

            int temp = Math.max(arr[i], Math.max(arr[i] * maxEndingHere, arr[i] * minEndingHere));

            minEndingHere = Math.min(arr[i], Math.min(arr[i] * maxEndingHere, arr[i] * minEndingHere));

            maxEndingHere = temp;

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {

        int[] arr = {1, -2, -3, 0, 7, -8, -2};

        int n = arr.length;

        System.out.println(maxSubarrayProduct(arr, n));
    }
}