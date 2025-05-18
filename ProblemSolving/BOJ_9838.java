import java.io.*;

public class BOJ_9838 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] receiverIdx = new int[N];

        for (int i = 1; i <= N; i++) {
            receiverIdx[Integer.parseInt(br.readLine()) - 1] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(receiverIdx[i]).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
