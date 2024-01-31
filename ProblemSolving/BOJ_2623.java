import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623 {
	
	static int[] indegree;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		indegree = new int [N + 1];
		graph = new ArrayList [N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int numOfArtists = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken()), to;
			for (int j = 1; j < numOfArtists; j++) {
				to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				indegree[to]++;
				
				from = to;
			}
		}
		
		bw.write(getInLine());
		br.close();
		bw.close();
	}

	private static String getInLine() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append("\n");
			
			for (int next : graph[cur]) {
				if(--indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		return areAllSingersInLine() ? sb.toString() : "0";
	}

	private static boolean areAllSingersInLine() {
		boolean allSingersInLine = true;
		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] != 0) {
				allSingersInLine = false;
				break;
			}
		}
		return allSingersInLine;
	}
}
