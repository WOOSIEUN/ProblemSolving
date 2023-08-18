import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2212 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[] sensors = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}		
		Arrays.sort(sensors);
		
		int[] distances = new int [N - 1];
		for (int i = 0; i < N - 1; i++) {
			distances[i] = sensors[i + 1] - sensors[i];
		}
		Arrays.sort(distances);
		
		for (int i = 0; i < N - K; i++) {
			ans += distances[i];
		}
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
