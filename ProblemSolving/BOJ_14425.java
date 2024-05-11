import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> strings = new HashSet<>();
		for (int i = 0; i < N; i++) {
			strings.add(br.readLine());
		}
		
		int ans = 0;
		for (int i = 0; i < M; i++) {
			if (strings.contains(br.readLine())) {
				ans++;
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
