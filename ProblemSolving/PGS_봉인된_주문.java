import java.util.*;

public class PGS_봉인된_주문 {
	
	class Solution {
		public String solution(long n, String[] bans) {
			String answer = "";

			long num;
			long[] bansNums = new long[bans.length];
			for (int i = 0; i < bans.length; i++) {
				bansNums[i] = convertStrToNum(bans[i]);
			}

			Arrays.sort(bansNums);
			for (long ban : bansNums) {
				if (ban > n) {
					break;
				}
				n++;
			}

			return convertNumToStr(n);
		}

		private long convertStrToNum(String str) {
			long num = 0;

			for (int i = 0; i < str.length(); i++) {
				num += (str.charAt(i) - 'a' + 1) * Math.pow(26, (str.length() - i - 1));
			}

			return num;
		}

		private String convertNumToStr(long num) {
			StringBuilder sb = new StringBuilder();

			while (num > 0) {
				sb.append((char) ((num - 1) % 26 + 'a'));
				num = (num - 1) / 26;
			}

			return sb.reverse().toString();
		}
	}
	
}
