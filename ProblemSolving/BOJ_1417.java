import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int mine = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        for (; !pq.isEmpty() && mine <= pq.peek(); ans++) {
            pq.add(pq.poll() - 1);
            mine++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
