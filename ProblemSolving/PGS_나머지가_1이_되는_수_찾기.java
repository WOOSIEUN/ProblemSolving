
public class PGS_나머지가_1이_되는_수_찾기 {

	class Solution {
		public int solution(int n) {
			int answer = -1;
			for (int div = 2; div < n; div++) {
				if (n % div == 1) {
					answer = div;
					break;
				}
			}
			return answer;
		}
	}
	
}
