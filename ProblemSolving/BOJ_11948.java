import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_11948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] science = new int [4];
		for (int i = 0; i < 4; i++) {
			science[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(science);
		int ans = science[1] + science[2] + science[3];
		ans += Math.max(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
