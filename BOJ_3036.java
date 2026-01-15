import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            int gcd = getGcd(first, target);
            sb.append(first / gcd).append("/").append(target / gcd).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static int getGcd(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
