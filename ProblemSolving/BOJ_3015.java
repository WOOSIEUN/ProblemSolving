import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_3015 {
	static class Pair {
		int height, cnt;

		public Pair(int height, int cnt) {
			this.height = height;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] audiences = new int [N];
		for(int i = 0; i < N; i++) {
			audiences[i] = Integer.parseInt(br.readLine());
		}
		
		long answer = 0;
		Stack<Pair> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			while (!stack.isEmpty() && stack.peek().height < audiences[i]) {
				answer += stack.pop().cnt;
			}
			
			if (stack.isEmpty()) {
				stack.push(new Pair(audiences[i], 1));
			} else {
				if (stack.peek().height == audiences[i]) {
					answer += stack.peek().cnt++;
				
					if (stack.size() > 1) {
						answer++; 
					}
				} else {
					stack.push(new Pair(audiences[i], 1));
					answer++;
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
}