import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0, ans = 0, diff = 100;
		for (int i = 0; i < 10; i++) {
			sum += Integer.parseInt(br.readLine());
			
			if (Math.abs(100 - sum) <= diff) {
                diff = Math.abs(100 - sum);
                ans = sum;
            }
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
