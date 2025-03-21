import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(br.readLine().length() >= br.readLine().length() ? "go" : "no");
        br.close();
        bw.close();
    }
}