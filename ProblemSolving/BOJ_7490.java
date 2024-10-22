import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7490 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            combi(1, 1, "1", N);
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static int calculate(String str) {
        str = str.replaceAll(" ", "");
        StringTokenizer st = new StringTokenizer(str, "[+,-]");

        int result = Integer.parseInt(st.nextToken());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                result += Integer.parseInt(st.nextToken());;
            } else if (str.charAt(i) == '-') {
                result -= Integer.parseInt(st.nextToken());;
            }
        }
        return result;
    }

    static void combi(int num, int len, String str, int N) {
        if (len == N) {
            if (calculate(str) == 0) {
                sb.append(str).append("\n");
            }
            return;
        }

        combi(num + 1, len + 1, str + ' ' + (num + 1), N);
        combi(num + 1, len + 1, str + '+' + (num + 1), N);
        combi(num + 1, len + 1, str + '-' + (num + 1), N);

    }
}
