import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] investment = new int[N + 1][M + 1];
        for (int company = 1; company <= N; company++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int amount = 1; amount <= M; amount++) {
                investment[company][amount] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][M + 1];
        int[][] path = new int[N + 1][M + 1];
        for (int company = 1; company <= M; company++) {
            for (int prevInvestment = 0; prevInvestment <= N; prevInvestment++) {
                for (int curInvestment = 0; curInvestment <= N - prevInvestment; curInvestment++) {
                    if (dp[prevInvestment + curInvestment][company] < dp[prevInvestment][company - 1] + investment[curInvestment][company]) {
                        dp[prevInvestment + curInvestment][company] = dp[prevInvestment][company - 1] + investment[curInvestment][company];
                        path[prevInvestment + curInvestment][company] = curInvestment;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N][M]).append("\n");

        Stack<Integer> stack = new Stack<>();
        int amount = N, company = M;
        while (company != 0) {
            stack.push(path[amount][company]);
            amount -= path[amount][company];
            company--;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}