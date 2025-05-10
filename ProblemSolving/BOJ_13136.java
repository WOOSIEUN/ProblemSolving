import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double R = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf((long) Math.ceil(R / N) * (long) Math.ceil(C / N)));
        br.close();
        bw.close();
    }
}
