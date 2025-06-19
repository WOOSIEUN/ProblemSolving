import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int [3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        char[] inputs = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputs.length; i++) {
            sb.append(nums[inputs[i] - 'A']).append(" ");
        }

        bw.write(sb.toString().trim());
        br.close();
        bw.close();
    }
}
