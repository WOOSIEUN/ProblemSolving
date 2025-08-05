import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {
    static class Element {
        int idx, num;

        public Element(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Element> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekLast().num > num) {
                deque.removeLast();
            }
            deque.addLast(new Element(i, num));

            if (deque.peekFirst().idx < i - L + 1) {
                deque.removeFirst();
            }

            sb.append(deque.peekFirst().num).append(" ");
        }

        bw.write(sb.toString().trim());
        br.close();
        bw.close();
    }
}
