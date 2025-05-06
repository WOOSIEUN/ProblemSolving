import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bread = Integer.parseInt(st.nextToken());
        int patty = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(Math.min(bread / 2, patty)));
        br.close();
        bw.close();
    }
}
