import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1943 {
	static class Coin {
		int value, quantity;

		public Coin(int value, int quantity) {
			this.value = value;
			this.quantity = quantity;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;		

		boolean[] dp;
		Coin[] coins;
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 3; t++) {
			int N = Integer.parseInt(br.readLine());
			coins = new Coin [N];
			dp = new boolean [50001];

			int sum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int value = Integer.parseInt(st.nextToken());
				int quantity = Integer.parseInt(st.nextToken());
				coins[i] = new Coin(value, quantity);
				sum += value * quantity;
			}
			
			if (sum % 2 == 1) {
	            sb.append("0\n");
	            continue;
	        }
			
			dp[0] = true;
			for (Coin coin : coins) {
				for (int curValue = sum / 2; curValue >= coin.value; curValue--) {
					if (dp[curValue - coin.value]) {
						for (int curQuantity = 0; curQuantity < coin.quantity && (curValue + coin.value * curQuantity) <= (sum / 2); curQuantity++) {
      							dp[curValue + coin.value * curQuantity] = true;
      					}
      				}
      			}
      		}
			
			sb.append(dp[sum / 2] ? "1\n" : "0\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
