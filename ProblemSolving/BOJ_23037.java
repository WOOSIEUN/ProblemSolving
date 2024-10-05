import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_23037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] n = br.readLine().toCharArray();
		
		int ans = 0;
		for (int i = 0; i < n.length; i++) {
			ans += (int) Math.pow(n[i] - '0', 5);
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
