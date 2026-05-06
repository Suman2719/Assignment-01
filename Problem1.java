import java.util.*;

public class Problem1 {

    public static int maxCyclicSubstringSum(String s) {
        int n = s.length();
        String doubled = s + s;

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxSum = 0;
        int currentSum = 0;

        for (int right = 0; right < doubled.length(); right++) {
            char ch = doubled.charAt(right);

            while (set.contains(ch)) {
                char leftChar = doubled.charAt(left);
                currentSum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            set.add(ch);
            currentSum += (ch - 'a' + 1);

          
            while (right - left + 1 > n) {
                char leftChar = doubled.charAt(left);
                currentSum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(maxCyclicSubstringSum(s));
    }
}
