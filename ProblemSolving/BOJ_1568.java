import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int time = -1;
        for (int i = 0; N > 0; i++, time++) {
            if (N < i) {
                i = 1;
            }
            N -= i;
        }

        bw.write(String.valueOf(time));
        br.close();
        bw.close();
    }
}
