import java.io.*;
import java.util.StringTokenizer;

public class BOJ_24084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            if (input[i + 1] == 'J') {
                sb.append(input[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
