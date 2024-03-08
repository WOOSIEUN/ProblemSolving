import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2217 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int [N];
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope);
		
		int maxWeight = rope[N - 1];
		for (int i = N - 1; i >= 0; i--) {
			int curWeight = rope[i] * (N - i);
			maxWeight = Math.max(maxWeight, curWeight);
		}
		
		bw.write(String.valueOf(maxWeight));
		br.close();
		bw.close();
	}
}
