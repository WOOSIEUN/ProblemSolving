import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 5;
        int sum = 0;
        int[] nums = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        sb.append((int) sum / MAX).append("\n").append(nums[(int) MAX / 2]);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
