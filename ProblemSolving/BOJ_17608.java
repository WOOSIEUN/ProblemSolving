import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_17608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			while (!stack.isEmpty() && stack.peek() <= cur) {
				stack.pop();
			}
			stack.add(cur);
		}
		
		bw.write(String.valueOf(stack.size()));
		br.close();
		bw.close();
	}
}
