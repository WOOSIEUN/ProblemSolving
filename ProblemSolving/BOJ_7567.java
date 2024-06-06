import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_7567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] plate = br.readLine().toCharArray();
		int ans = 10;
		for (int i = 1; i < plate.length; i++) {
			ans += (plate[i - 1] == plate[i] ? 5 : 10);
		}

		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
