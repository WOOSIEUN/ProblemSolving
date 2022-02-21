import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10971 {
	static int N, start, min = Integer.MAX_VALUE;
	static int [][] adjMatrix;
	static boolean [] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int [N][N];
		isVisited = new boolean [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
		}
		for (start = 0; start < N; start++)
			dfs(start, 0, 0);
		bw.write(""+min);
		br.close();
		bw.close();
	}

	private static void dfs(int vertex, int depth, int weight) {
		isVisited[vertex] = true;
		if(depth == N-1 && adjMatrix[vertex][start]!=0) {
			min = Math.min(min, weight + adjMatrix[vertex][start]);
			isVisited[vertex] = false;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!isVisited[i] && adjMatrix[vertex][i]!=0) {
				dfs(i, depth+1, weight + adjMatrix[vertex][i]);
			}
		}
		isVisited[vertex] = false;
	}
}
