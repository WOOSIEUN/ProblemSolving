import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15235 {
    static class Student {
        int idx, requiredPizza;

        public Student(int idx, int requiredPizza) {
            this.idx = idx;
            this.requiredPizza = requiredPizza;
        }

        public int eatPizza() {
            return --this.requiredPizza;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Student> pizzaQueue = new LinkedList<>();
        int[] times = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pizzaQueue.add(new Student(i, Integer.parseInt(st.nextToken())));
        }

        for (int time = 1; !pizzaQueue.isEmpty(); time++) {
            Student cur = pizzaQueue.poll();
            if (cur.eatPizza() == 0) {
                times[cur.idx] = time;
            } else {
                pizzaQueue.add(cur);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int time : times) {
            sb.append(time).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
