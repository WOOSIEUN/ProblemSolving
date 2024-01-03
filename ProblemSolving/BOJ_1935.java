import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_1935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String postfix = br.readLine();
		double[] num = new double [N];
		for (int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		for(int i = 0; i < postfix.length(); i++) {
			char cur = postfix.charAt(i);
			
			if ('A' <= cur && cur <= 'Z') {
				stack.push(num[cur - 'A']);
			} else {
				double b = stack.pop();
				double a = stack.pop();				
				if (cur == '+') {
					stack.push(a + b);
				} else if (cur == '-') {
					stack.push(a - b);
				} else if (cur == '*') {
					stack.push(a * b);
				} else if (cur == '/') {
					stack.push(a / b);
				}
			}
		}
		
		bw.write(String.format("%.2f", stack.pop()));
		br.close();
		bw.close();
	}
}
