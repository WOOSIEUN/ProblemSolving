import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[N + 1];
        
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        int[][] dp = new int[graph.length][2];
        boolean[] visited = new boolean[graph.length];
        findEarlyAdopter(1, graph, dp, visited);
        
        bw.write(String.valueOf(Math.min(dp[1][0], dp[1][1])));
        br.close();
        bw.close();
    }

    private static void findEarlyAdopter(int cur, List<Integer>[] graph, int[][] dp, boolean[] visited) {
        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for (int next : graph[cur]) {
            if (visited[next]) {
                continue;
            }

            findEarlyAdopter(next, graph, dp, visited);
            dp[cur][0] += dp[next][1];
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}
