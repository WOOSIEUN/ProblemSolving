import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int numOfProblems = 0;
        int[] solvedProblem = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            solvedProblem[i] = Integer.parseInt(st.nextToken());
            numOfProblems += solvedProblem[i];
        }

        StringBuilder sb = new StringBuilder();
        int prizePerProblem = D / numOfProblems;
        for (int i = 0; i < N; i++) {
            sb.append(solvedProblem[i] * prizePerProblem).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
