import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int ans = -1;
        if (C > B) {
            ans = A / (C - B) + 1;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
