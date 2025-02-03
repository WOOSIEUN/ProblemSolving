import java.io.*;
import java.math.BigInteger;

public class BOJ_21567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        BigInteger result = BigInteger.valueOf(A).multiply(BigInteger.valueOf(B)).multiply(BigInteger.valueOf(C));
        char[] nums = String.valueOf(result).toCharArray();

        int[] cntNums = new int[10];
        for (char el : nums) {
            cntNums[el - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : cntNums) {
            sb.append(num).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
