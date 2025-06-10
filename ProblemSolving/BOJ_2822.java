import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2822 {
    static class Problem implements Comparable<Problem> {
        int idx, score;

        public Problem(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Problem o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = 8;
        Problem[] problems = new Problem[N];
        for (int i = 0; i < N; i++) {
            problems[i] = new Problem(i + 1, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(problems);

        int sum = 0;
        int[] indexes = new int[5];
        for (int i = 0; i < indexes.length; i++) {
            sum += problems[i].score;
            indexes[i] = problems[i].idx;
        }

        Arrays.sort(indexes);

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");
        for (int i = 0; i < indexes.length; i++) {
            sb.append(indexes[i]).append(" ");
        }

        bw.write(sb.toString().trim());
        br.close();
        bw.close();
    }
}
