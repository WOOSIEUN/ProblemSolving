import java.io.*;

public class BOJ_14623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long A = Long.parseLong(br.readLine(), 2);
        long B = Long.parseLong(br.readLine(), 2);

        bw.write(Long.toBinaryString(A * B));
        br.close();
        bw.close();
    }
}
