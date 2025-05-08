import java.io.*;

public class BOJ_16486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(d1 * 2 + 2 * 3.141592 * d2));
        br.close();
        bw.close();
    }
}
