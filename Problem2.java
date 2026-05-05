import java.util.*;

public class Problem2 {

    public static int minOperations(int[] arr, int k) {
        int n = arr.length;

        // Handle K = 0 case
        if (k == 0) {
            for (int num : arr) {
                if (num != arr[0]) {
                    return -1;
                }
            }
            return 0;
        }

        // Check if transformation is possible
        int mod = arr[0] % k;
        for (int num : arr) {
            if (num % k != mod) {
                return -1;
            }
        }

        // Sort array
        Arrays.sort(arr);

        // Choose median
        int median = arr[n / 2];

        int operations = 0;

        // Count operations
        for (int num : arr) {
            operations += Math.abs(num - median) / k;
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minOperations(arr, k));
    }
}
