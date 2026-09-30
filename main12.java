//lexico bs ----alright----

import java.util.*;

public class main12 {

    public static String smallestPalindrome(String s) {

        int n = s.length();
        int[] freq = new int[26];

        // Count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check feasibility
        int oddCount = 0;
        char oddChar = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'a');
            }
        }

        if ((n % 2 == 0 && oddCount > 0) ||
                (n % 2 == 1 && oddCount > 1)) {
            return "Not Possible";
        }

        // Build first half
        StringBuilder half = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                half.append((char) (i + 'a'));
            }
        }

        // Build palindrome
        StringBuilder result = new StringBuilder();

        result.append(half);

        if (oddCount == 1) {
            result.append(oddChar);
        }

        result.append(new StringBuilder(half).reverse());

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String palindrome = smallestPalindrome(s);

        System.out.println(
                "Lexicographically smallest palindrome: " + palindrome
        );
    }
}