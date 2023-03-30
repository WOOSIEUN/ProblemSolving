import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5585 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] coins = {500, 100, 50, 10, 5, 1};
		int money = 1000 - Integer.parseInt(br.readLine());
		int ans = 0;
		for (int coin : coins) {
			ans += money / coin;
			money %= coin;
		}
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
