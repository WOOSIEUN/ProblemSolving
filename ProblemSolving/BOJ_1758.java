import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Integer[] tips = new Integer [N];
		for (int i = 0; i < N; i++) {
			tips[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(tips, Collections.reverseOrder());
		
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (tips[i] - i > 0) {
				sum += (tips[i] - i);
			}
		}
		
		bw.write(String.valueOf(sum));
		br.close();
		bw.close();
	}
}
