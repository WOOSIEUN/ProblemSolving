import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekLast()[1] > num) {
                deque.pollLast();
            }
            deque.addLast(new int[] {i, num});

            if (deque.peek()[0] < i - L + 1) {
                deque.poll();
            }

            bw.write(deque.peek()[1] + " ");
        }

        bw.flush();
        bw.close();
    }
}
