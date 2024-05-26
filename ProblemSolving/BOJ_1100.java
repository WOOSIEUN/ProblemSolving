import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ans = 0;
		for (int row = 0; row < 8; row++) {
			char[] line = br.readLine().toCharArray();
			for (int col = 0; col < 8; col++) {
				if (line[col] == 'F' && (row + col) % 2 == 0) {
					ans++;
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
