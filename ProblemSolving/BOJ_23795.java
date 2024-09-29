import java.io.*;
import java.util.StringTokenizer;

public class BOJ_23795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0, money;
        while ((money = Integer.parseInt(br.readLine())) != -1) {
            sum += money;
        }

        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }
}
