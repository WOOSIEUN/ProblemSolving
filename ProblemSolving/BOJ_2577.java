import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int result = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
		
		int[] cnt = new int [10];
		while (result > 0) {
			cnt[result % 10]++;
			result /= 10;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int el : cnt) {
			sb.append(el).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
