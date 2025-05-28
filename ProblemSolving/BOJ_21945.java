import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            String num = st.nextToken();
            if (isPalindrome(num.toCharArray())) {
                sum += Integer.parseInt(num);
            }
        }

        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }

    private static boolean isPalindrome(char[] target) {
        boolean palindrome = true;
        for (int left = 0, right = target.length - 1; left < right; left++, right--) {
            if (target[left] != target[right]) {
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }
}
