import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			char[] cmds = br.readLine().toCharArray();
			
			int n = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine(), "[],");
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean valid = true, forward = true;
			for (char cmd : cmds) {
				if (cmd == 'R') {
					forward = !forward;
				} else {
					if (deque.isEmpty()) {
						valid = false;
						break;
					}
					
					if (forward) {
						deque.pollFirst();
					} else {
						deque.pollLast();
					}
				}
			}
			
			if (valid) {
				sb.append("[");
				
				if (!deque.isEmpty() && forward) {
					sb.append(deque.pollFirst());
					
					while (!deque.isEmpty()) {
						sb.append(",").append(deque.pollFirst());
					}
				} else if (!deque.isEmpty() && !forward) {
					sb.append(deque.pollLast());
					
					while (!deque.isEmpty()) {
						sb.append(",").append(deque.pollLast());
					}
				}
				
				sb.append("]\n");
			} else {
				sb.append("error\n");				
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
