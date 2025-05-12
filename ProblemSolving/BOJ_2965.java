import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(Math.max(B - A - 1, C - B - 1)));
        br.close();
        bw.close();
    }
}
