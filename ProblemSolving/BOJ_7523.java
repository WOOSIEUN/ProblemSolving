import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_7523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            BigInteger N = new BigInteger(st.nextToken());
            BigInteger M = new BigInteger(st.nextToken());
            sb.append("Scenario #").append(t + 1).append(":\n");
            sb.append(sum(M).subtract(sum(N.subtract(BigInteger.ONE)))).append("\n\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static BigInteger sum(BigInteger num) {
        return num.multiply(num.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
    }
}
