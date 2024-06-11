import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5555 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String target = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String ring = br.readLine();
			ring += ring;
			
			if (ring.contains(target)) {
				ans++;
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
