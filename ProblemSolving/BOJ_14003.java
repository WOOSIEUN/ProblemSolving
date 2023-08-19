import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int [N];
		int[] LIS = new int [N];
		int[] index = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int LISLen = 1;
		LIS[0] = sequence[0];
		
		for (int i = 1; i < N; i++) {
			int cur = sequence[i];
			if (LIS[LISLen - 1] < cur) {
				LIS[LISLen] = cur;
				index[i] = LISLen++;
			} else {
				int low = 0;
				int high = LISLen - 1;
				while (low < high) {
					int mid = (low + high) / 2;
					if (LIS[mid] < cur) {
						low = mid + 1;
					} else {
						high = mid;
					}
				}
				LIS[low] = cur;
				index[i] = low;
			}
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = N - 1, targetIdx = LISLen - 1; i >= 0 && targetIdx >= 0; i--) {
			if (targetIdx == index[i]) {
				stack.add(sequence[i]);
				targetIdx--;
			}
		}
		
		sb.append(LISLen).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
