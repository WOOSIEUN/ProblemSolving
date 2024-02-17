import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_1874 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		boolean isAvailable = true;
		int curNum = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (curNum < num) {
				for (int j = curNum + 1; j <= num; j++) {
					stack.push(j);
					sb.append('+').append('\n');
				}
				
				curNum = num;
			} else if (stack.peek() != num) {
				isAvailable = false;
				break;
			}
			
			stack.pop();
			sb.append('-').append('\n');
		}
		
		bw.write(isAvailable ? sb.toString() : "NO");
		br.close();
		bw.close();
	}
}
