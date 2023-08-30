import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		while (!queue.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append(">");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
