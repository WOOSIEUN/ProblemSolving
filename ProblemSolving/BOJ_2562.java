import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 0, ans = -1;
		for (int i = 1; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > max) {
				max = num;
				ans = i;
			}
		}		
		bw.write(max + "\n" + ans);
		br.close();
		bw.close();
	}
}
