import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "-");
            sb.append(isNice(st.nextToken().toCharArray(), Integer.parseInt(st.nextToken())) ? "nice\n" : "not nice\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static boolean isNice(char[] alphabets, int num) {
        int value = 0;
        for (int i = alphabets.length - 1, radix = 1; i >= 0; i--, radix *= 26) {
            value += ((alphabets[i] - 'A') * radix);
        }
        return Math.abs(value - num) <= 100;
    }
}
