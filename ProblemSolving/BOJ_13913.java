import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {
	
	static final int MAX = 100001;
	static int N, K;
	static int[] time = new int [MAX], parent = new int [MAX];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		hideAndSeek();
		
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		
        int cur = K;
        while (cur != N) {
            stack.push(parent[cur]);
            cur = parent[cur];
        }

		StringBuilder sb = new StringBuilder();
		sb.append(time[K] - 1).append("\n");
		while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void hideAndSeek() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		time[N] = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur == K) {
				return;
			}
			
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = cur - 1;
				} else if (i == 1) {
					next = cur + 1;
				} else {
					next = cur * 2;
				}
				
				if (isInMap(next) && time[next] == 0) {
					queue.add(next);
					parent[next] = cur;
					time[next] = time[cur] + 1;
				}
			}
		}
	}

	private static boolean isInMap(int target) {
		return 0 <= target && target < MAX;
	}
}
