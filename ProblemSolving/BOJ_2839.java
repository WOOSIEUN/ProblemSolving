import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839 {
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while (N >= 0) {
			if(N % 5 == 0) {
				result += N/5;
				System.out.println(result);
				return;
			}
			result++;
			N -= 3;
		}
		System.out.println("-1");
	}
}
