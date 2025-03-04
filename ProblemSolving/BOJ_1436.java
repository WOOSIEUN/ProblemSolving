import java.io.*;

public class BOJ_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int num = 666;
        for (int count = 1; count != N; ) {
            if (String.valueOf(++num).contains("666")) {
                count++;
            }
        }

        bw.write(String.valueOf(num));
        br.close();
        bw.close();
    }
}
