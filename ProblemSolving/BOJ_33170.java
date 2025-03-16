import java.io.*;
import java.util.StringTokenizer;

public class BOJ_33170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()) <= 21 ? "1" : "0");
        br.close();
        bw.close();
    }
}