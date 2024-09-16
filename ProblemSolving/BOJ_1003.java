import java.io.*;

public class BOJ_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] fibo = new int[2][41];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        for (int i = 2; i < fibo[0].length; i++){
            fibo[0][i] = fibo[0][i - 1] + fibo[0][i - 2];
            fibo[1][i] = fibo[1][i - 1] + fibo[1][i - 2];
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(fibo[0][N]).append(" ").append(fibo[1][N]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
