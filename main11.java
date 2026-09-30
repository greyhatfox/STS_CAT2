//majority element ----easy----

import java.util.Scanner;

public class main11 {

    public static int findMajorityElement(int[] A) {

        int m = -1;
        int i = 0;

        for (int j = 0; j < A.length; j++) {

            if (i == 0) {
                m = A[j];
                i = 1;
            }
            else if (m == A[j]) {
                i++;
            }
            else {
                i--;
            }
        }

        return m;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int j = 0; j < n; j++) {
            arr[j] = sc.nextInt();
        }

        int result = findMajorityElement(arr);

        System.out.println("Majority element is: " + result);

        sc.close();
    }
}