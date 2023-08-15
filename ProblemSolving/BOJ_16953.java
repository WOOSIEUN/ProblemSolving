import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {

	static long A, B;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		bw.write(String.valueOf(bfs()));
		br.close();
		bw.close();
	}

	private static int bfs() {
		Queue<Long> queue = new LinkedList<>();
		queue.add(A);
		
		while (!queue.isEmpty()) {
			cnt++;
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				long cur = queue.poll();
				if (cur == B) {
					return cnt;
				}
				if (cur * 2 <= B) {
					queue.add(cur * 2);
				}
	            if (cur * 10 + 1 <= B) {
	            	queue.add(cur * 10 + 1);
	            }
			}
		}		
		return -1;
	}
}
