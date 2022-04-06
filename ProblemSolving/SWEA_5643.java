import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5643 {
	static int result, sum, N, M;
	static int[] cnt;
	static boolean[] visited;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adjList = new ArrayList[N + 1];
			cnt = new int[N + 1];
			result = 0;
			for (int i = 1; i <= N; i++)
				adjList[i]=new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				sum = 0;
				dfs(i);
				cnt[i] += sum;
			}
			for (int i = 1; i <= N; i++)
				if(cnt[i] == N) result++;
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	private static void dfs(int cur) {
		sum++;
		int size = adjList[cur].size();
		for (int i = 0; i < size; i++) {
			int next = adjList[cur].get(i);
			if(!visited[next]) {
				visited[next] = true;
				cnt[next]++;
				dfs(next);
			}
		}
	}
}
