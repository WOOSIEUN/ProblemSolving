
public class PGS_금과_은_운반하기 {

	public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
		long answer = (long) (10e9 * 2 * 10e5 * 2);
		long start = 0;
		long end = answer;

		while (start <= end) {
			long mid = (start + end) / 2;
			int gold = 0, silver = 0, sum = 0;

			for (int i = 0; i < w.length; i++) {
				long curMove = (mid / t[i]) % 2 == 1 ? mid / (t[i] * 2) + 1 : mid / (t[i] * 2);
				gold += Math.min(g[i], curMove * w[i]);
				silver += Math.min(s[i], curMove * w[i]);
				sum += Math.min(g[i] + s[i], curMove * w[i]);
			}

			if (gold < a || silver < b || sum < a + b) {
				start = mid + 1;
			} else {
				end = mid - 1;
				answer = Math.min(mid, answer);
			}
		}

		return answer;
	}
	
}
