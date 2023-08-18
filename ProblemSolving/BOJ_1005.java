import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {
	
	static ArrayList<Integer>[] constructions;
	static int[] requiredTime, inDegree;
	static int N, W;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());		
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			constructions = new ArrayList [N + 1];
			requiredTime = new int [N + 1];
			inDegree = new int [N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				constructions[i] = new ArrayList<>();
				requiredTime[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				constructions[to].add(from);
				inDegree[from]++;
			}
			W = Integer.parseInt(br.readLine());
			
			sb.append(getMinTime()).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	// topologicalSort
	private static int getMinTime() {
		int[] totalRequiredTime = new int [N + 1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			totalRequiredTime[i] = requiredTime[i];
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : constructions[cur]) {
				totalRequiredTime[next] = Math.max(totalRequiredTime[next], totalRequiredTime[cur] + requiredTime[next]);
				if (--inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		return totalRequiredTime[W];
	}
}
