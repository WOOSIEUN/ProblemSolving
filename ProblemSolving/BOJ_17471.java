import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {
	static int N, tmp, min = Integer.MAX_VALUE;
	static int[] district;
	static boolean[] isSelected;
	static ArrayList<Integer>[] adjList;	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		district = new int [N + 1];
		isSelected = new boolean [N + 1];
		adjList = new ArrayList [N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			district[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<Integer>();
			for (int j = 0; j < tmp; j++)
				adjList[i].add(Integer.parseInt(st.nextToken()));
		}
		divide(1, 0);
		
		if (min == Integer.MAX_VALUE) min = -1;
		bw.write(min+"");
		br.close();
		bw.close();
	}

	private static void divide(int idx, int cnt) {
		if (cnt > N / 2) return;
		if (idx == N + 1) {
			if(cnt != 0 && isConnected()) connectedMin(cnt);
			return;
		}
		isSelected[idx] = true;
		divide(idx + 1, cnt + 1);
		isSelected[idx] = false;
		divide(idx + 1, cnt);
	}

	private static boolean isConnected() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		int rootA = -1, rootB = -1;
		
		for (int i = 1; i <= N; i++)
            if (isSelected[i]) {
            	rootA = i;
                break;
            }
		queue.add(rootA);
		visited[rootA] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int size = adjList[cur].size();
            for (int i = 0; i < size; i++) {
            	int next = adjList[cur].get(i);
                if (!visited[next] && isSelected[next]) {
                	visited[next] = true;
                	queue.add(next);
                }
            }
        }
		
		for (int i = 1; i <= N; i++)
            if (!isSelected[i]) {
            	rootB = i;
                break;
            }
		queue.add(rootB);
		visited[rootB] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int size = adjList[cur].size();
            for (int i = 0; i < size; i++) {
            	int next = adjList[cur].get(i);
                if (!visited[next] && !isSelected[next]) {
                	visited[next] = true;
                	queue.add(next);
                }
            }
        }
		for (int i = 1; i <= N; i++)
			if (!visited[i]) return false;
		return true;
				
	}

	private static void connectedMin(int cnt) {
		int sumA = 0, sumB = 0;
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) sumA += district[i];
			else sumB += district[i];
		}
		min = Math.min(min, Math.abs(sumA - sumB));
	}
}
