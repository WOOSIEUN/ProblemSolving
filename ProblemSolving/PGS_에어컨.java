
public class PGS_에어컨 {

	class Solution {
		public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
			int tempUpperRange = 50, tempLowerRange = 0;
			temperature += 10;
			t1 += 10;
			t2 += 10;

			int MAX = 100 * 1000;
			int[][] dp = new int [onboard.length][tempUpperRange + 1];
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[0].length; j++) {
					dp[i][j] = MAX;
				}
			}

			dp[0][temperature] = 0;

			for (int time = 0; time < dp.length - 1; time++) {
				for (int curTemp = 0; curTemp < dp[0].length; curTemp++) {
					if (onboard[time] == 1 && (curTemp < t1 || t2 < curTemp)) {
						continue;
					}

					int nextTemp = curTemp;
					if (curTemp < temperature && curTemp < tempUpperRange) {
						nextTemp = curTemp + 1;
					} else if (curTemp > temperature && curTemp > tempLowerRange) {
						nextTemp = curTemp - 1;
					}
					dp[time + 1][nextTemp] = Math.min(dp[time][curTemp], dp[time + 1][nextTemp]);

					if (curTemp > tempLowerRange) {
						dp[time + 1][curTemp - 1] = Math.min(dp[time][curTemp] + a, dp[time + 1][curTemp - 1]);
					}

					if (curTemp < tempUpperRange) {
						dp[time + 1][curTemp + 1] = Math.min(dp[time][curTemp] + a, dp[time + 1][curTemp + 1]);
					}

					dp[time + 1][curTemp] = Math.min(dp[time][curTemp] + b, dp[time + 1][curTemp]);
				}
			}

			int answer = MAX;
			for (int temp = 0; temp < dp[0].length; temp++) {
				if (onboard[onboard.length - 1] == 1 && (temp < t1 || t2 < temp)) {
					continue;
				}
				answer = Math.min(answer, dp[dp.length - 1][temp]);
			}

			return answer;
		}
	}
	
}
