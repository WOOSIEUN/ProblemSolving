import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf((int) Math.sqrt(Integer.parseInt(br.readLine()))));
        br.close();
        bw.close();
    }
}