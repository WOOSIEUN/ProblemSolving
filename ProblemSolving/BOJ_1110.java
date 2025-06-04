import java.io.*;

public class BOJ_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1, num = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);

        while (num != N) {
            num = ((num % 10) * 10) + (((num / 10) + (num % 10)) % 10);
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        br.close();
        bw.close();
    }
}
