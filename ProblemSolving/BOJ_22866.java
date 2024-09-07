import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_22866 {
	static class Building {
		int idx, height;
		
		public Building(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Building[] buildings = new Building [N];
		int[] cnt = new int [N];
		int[] near = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
			near[i] = -100_001;
		}
		
		Stack<Building> stack = new Stack<>();
		for (int cur = 0; cur < N; cur++) {
			while (!stack.isEmpty() && stack.peek().height <= buildings[cur].height) {
				stack.pop();
			}
			
			cnt[cur] = stack.size();
			if (stack.size() > 0) {
				near[cur] = stack.peek().idx;
			}
			stack.push(buildings[cur]);
		}
		
		stack = new Stack<>();
		for (int cur = N - 1; cur >= 0; cur--) {
			while (!stack.isEmpty() && stack.peek().height <= buildings[cur].height) {
				stack.pop();
			}
			
			cnt[cur] += stack.size();
			if (stack.size() > 0 && stack.peek().idx - cur < cur - near[cur]) {
				near[cur] = stack.peek().idx;
			}
			stack.push(buildings[cur]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(cnt[i]);
			
			if (cnt[i] > 0) {
				sb.append(" ").append(near[i] + 1);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
