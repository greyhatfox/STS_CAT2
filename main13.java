//nat sort, ----DO LATER----

import java.util.*;
import java.util.regex.*;

public class main13 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> list = new ArrayList<>();

        System.out.println("Enter the strings:");

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        Collections.sort(list, new NaturalOrderComparator());

        System.out.println("Natural Sorted Order:");

        for (String s : list) {
            System.out.println(s);
        }
    }
}

class NaturalOrderComparator implements Comparator<String> {

    private static final Pattern pattern =
            Pattern.compile("(\\D*)(\\d*)");

    public int compare(String s1, String s2) {

        Matcher m1 = pattern.matcher(s1);
        Matcher m2 = pattern.matcher(s2);

        while (m1.find() && m2.find()) {

            int textCompare =
                    m1.group(1).compareTo(m2.group(1));

            if (textCompare != 0)
                return textCompare;

            String num1 = m1.group(2);
            String num2 = m2.group(2);

            if (num1.isEmpty() && num2.isEmpty())
                continue;

            int n1 = num1.isEmpty() ? 0 : Integer.parseInt(num1);
            int n2 = num2.isEmpty() ? 0 : Integer.parseInt(num2);

            if (n1 != n2)
                return n1 - n2;
        }

        return s1.compareTo(s2);
    }
}