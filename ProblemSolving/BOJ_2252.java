import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {

	static int N;
	static int[] indegree;
	static ArrayList<Integer>[] students;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		students = new ArrayList[N + 1];
		indegree = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			students[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			students[to].add(from);
			indegree[from]++;
		}

		bw.write(getStudentList());
		br.close();
		bw.close();
	}

	private static String getStudentList() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			for (int next : students[cur]) {
				if (--indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		return sb.toString();
	}
}
