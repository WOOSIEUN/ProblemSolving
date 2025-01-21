import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double R = Double.parseDouble(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(Math.PI * R * R).append("\n").append(2 * R * R);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
