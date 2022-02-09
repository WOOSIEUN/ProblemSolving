import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
	static Stack<String> stack;
	static String str, cur;
	static int result, tmp;

	public static void main(String args[]) throws Exception {
		stack = new Stack<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		result = 0;
		tmp = 1;
		for (int i = 0; i < str.length(); i++) {
			cur = Character.toString(str.charAt(i));
			if (cur.equals("(")) {
				tmp *= 2;
				stack.push(cur);
			} else if (cur.equals("[")) {
				tmp *= 3;
				stack.push(cur);
			} else if (cur.equals(")")) {
				if (stack.isEmpty() || !stack.pop().equals("(")) {
					result = 0;
					break;
				} else if (str.charAt(i - 1) == '(')
					result += tmp;
				tmp /= 2;
			} else if (cur.equals("]")) {
				if (stack.isEmpty() || !stack.pop().equals("[")) {
					result = 0;
					break;
				} else if (str.charAt(i - 1) == '[')
					result += tmp;
				tmp /= 3;
			}
		}
		if (!stack.isEmpty())
			result = 0;
		System.out.print(result);
	}
}
