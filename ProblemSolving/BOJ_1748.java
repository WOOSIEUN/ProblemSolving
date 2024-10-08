import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
	    for (int i = 1; i <= N; i *= 10) {
	        ans += N - i + 1;
	    }
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
