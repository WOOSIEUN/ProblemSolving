import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        int minute = C % 60;
        A += (B + minute) / 60;
        B = (B + minute) % 60;
        A = (A + C / 60) % 24;

        StringBuilder sb = new StringBuilder();
        sb.append(A).append(" ").append(B);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
