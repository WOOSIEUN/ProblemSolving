import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> cards = new PriorityQueue();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long cardA = cards.poll();
            long cardB = cards.poll();
            cards.offer(cardA + cardB);
            cards.offer(cardA + cardB);
        }

        long sum = cards.stream().mapToLong(l -> l).sum();

        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }
}
