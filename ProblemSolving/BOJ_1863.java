import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int numOfBuildings = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
				numOfBuildings++;
            }
			
			if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }
			
			stack.push(y);
		}
		
		while (!stack.isEmpty()) {
            if (stack.pop() > 0) {
            	numOfBuildings++;
            }
        }
		
		bw.write(String.valueOf(numOfBuildings));
		br.close();
		bw.close();
	}
}
