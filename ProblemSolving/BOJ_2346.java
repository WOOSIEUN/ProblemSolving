import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346 {
    static class Balloon {
        int idx, cmd;

        public Balloon(int idx, int cmd) {
            this.idx = idx;
            this.cmd = cmd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> balloons = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            balloons.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        Balloon cur = balloons.poll();
        sb.append(cur.idx).append(" ");
        while (!balloons.isEmpty()) {
            if (cur.cmd > 0) {
                for (int i = 0; i < cur.cmd - 1; i++) {
                    balloons.add(balloons.poll());
                }
                cur = balloons.poll();
            } else {
                for (int i = 0; i < Math.abs(cur.cmd) - 1; i++) {
                    balloons.addFirst(balloons.pollLast());
                }
                cur = balloons.pollLast();
            }
            sb.append(cur.idx).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
