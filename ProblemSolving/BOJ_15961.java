import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15961 {
	static int N, d, k, c, total, max, idx;
	static int[] sushi;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		visited = new int[d + 1];
		for (int i = 0; i < N; i++)	
			sushi[i] = Integer.parseInt(br.readLine());
		bw.write("" + slidingWindow());
		br.close();
		bw.close();
	}

	private static int slidingWindow() {
		for (int i = 0; i < k; i++) {
			if(visited[sushi[i]] == 0) total++;
			visited[sushi[i]]++;
		}
		if(visited[c] == 0) total++;
		visited[c]++;
		max = total;
		for (int i = 1; i < N; i++) {
			if(visited[sushi[i - 1]] == 1) total--;
			visited[sushi[i - 1]]--;
			idx = (i + k - 1) % N;
			if(visited[sushi[idx]] == 0) total++;
			visited[sushi[idx]]++;
			max = Math.max(max, total);
		}
		return max;
	}

}