import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_9935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<>();
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();

		for (int i = 0; i < str.length; i++) {
			stack.push(str[i]);
			if (stack.size() >= bomb.length) {
				boolean exist = true;
				
				for (int j = 0; j < bomb.length; j++) {
					if (stack.get(stack.size() - bomb.length + j) != bomb[j]) {
						exist = false;
						break;
					}
				}
				
				if (exist) {
					for (int j = 0; j < bomb.length; j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		bw.write(sb.length() == 0 ? "FRULA" : sb.reverse().toString());
		br.close();
		bw.close();
	}
}
