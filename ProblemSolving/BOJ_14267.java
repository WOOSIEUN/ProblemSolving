import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14267 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] dp = new int [N + 1];
		ArrayList<Integer>[] tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		for (int i = 2; i <= N; i++) {
			int node = Integer.parseInt(st.nextToken());
	        tree[node].add(i);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
	        dp[node] += weight;
		}
		
		dfs(1, tree, dp);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(dp[i]).append(" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void dfs(int node, ArrayList<Integer>[] tree, int[] dp) {
	    for (int next : tree[node]) {
	        dp[next] += dp[node];
	        dfs(next, tree, dp);
	    }
	}
}
