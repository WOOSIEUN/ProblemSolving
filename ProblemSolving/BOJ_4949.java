import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_4949 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			char[] line = br.readLine().toCharArray();
			
			if (line[0] == '.') {
				break;
			}
			
			boolean balancedStr = true;
			Stack<Character> stack = new Stack<>();
			for (char ch : line) {
				if (ch == '(' || ch == '[') {
					stack.add(ch);
				} else if (ch == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						balancedStr = false;
						break;
					}
				} else if (ch == ']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						balancedStr = false;
						break;
					}
				}
			}
			
			if (!stack.isEmpty()) {
				balancedStr = false;
			}
			
			sb.append(balancedStr ? "yes\n" : "no\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
