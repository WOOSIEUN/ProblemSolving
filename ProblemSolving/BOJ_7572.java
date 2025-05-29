import java.io.*;

public class BOJ_7572 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int a = (N + 8) % 12;
        int b = (N + 6) % 10;

        bw.write(String.format("%c%d", 'A' + a, b));
        br.close();
        bw.close();
    }
}
