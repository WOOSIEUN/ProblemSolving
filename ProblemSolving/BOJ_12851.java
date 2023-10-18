import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {
	
	static final int MAX = 100001;
	static int N, K, count, minTime = Integer.MAX_VALUE;
	static int[] time = new int [MAX];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N == K) {
			minTime = 0;
			count = 1;
		} else {
			hideAndSeek();
		}				
		bw.write(minTime + "\n" + count);
		br.close();
		bw.close();	
	}

	private static void hideAndSeek() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		time[N] = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (minTime < time[cur]) {
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
				
				if (next == K) {
                    minTime = time[cur];
                    count++;
                }
				
				if (isInMap(next) && (time[next] == 0 || time[next] == time[cur] + 1)) {
					queue.add(next);
					time[next] = time[cur] + 1;
				}
			}
		}
	}

	private static boolean isInMap(int target) {
		return 0 <= target && target < MAX;
	}
}
