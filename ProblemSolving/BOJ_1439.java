import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1439 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ans = 0;
		char[] arr = br.readLine().toCharArray();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				ans++;
			}
		}
		
		bw.write(String.valueOf((ans + 1) / 2));
		br.close();
		bw.close();
	}
}
