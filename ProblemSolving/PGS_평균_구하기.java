
public class PGS_평균_구하기 {
	class Solution {
	    public double solution(int[] arr) {
	        double answer = 0;
	        for(int item : arr)
	            answer += item;
	        return answer/(arr.length);
	    }
	}
}
