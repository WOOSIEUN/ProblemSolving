import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] pipe = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pipe);
		
		int prev = pipe[0], cnt = 0;
		for (int i = 1; i < N; i++) {
			if (L < pipe[i] - prev + 1) {
				prev = pipe[i];
				cnt++;
			}
		}
		
		bw.write(String.valueOf(++cnt));
		br.close();
		bw.close();
	}
}
