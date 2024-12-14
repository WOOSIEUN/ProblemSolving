import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.parseInt(br.readLine()) % 2 == 0 ? "SK" : "CY");
        br.close();
        bw.close();
    }
}
