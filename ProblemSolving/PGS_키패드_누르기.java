
public class PGS_키패드_누르기 {
	
	class Solution {
		public String solution(int[] numbers, String hand) {
	        StringBuilder answer = new StringBuilder();
	        int left = 10, right = 12;
	        
	        for (int number : numbers) {
	            if (number == 0) {
	                number = 11;
	            }
	            
	            if (number % 3 == 0) {
	                answer.append("R");
	                right = number;
	            } else if (number % 3 == 1) {
	                answer.append("L");
	                left = number;
	            } else {
	                int leftDist = (Math.abs(number - left) / 3) + (Math.abs(number - left) % 3);
	                int rightDist = (Math.abs(number - right) / 3) + (Math.abs(number - right) % 3);
	                
	                if (leftDist < rightDist) {
	                    answer.append("L");
	                    left = number;                    
	                } else if (leftDist > rightDist) {
	                    answer.append("R");
	                    right = number;                    
	                } else {
	                    if (hand.equals("left")) {
	                        answer.append("L");
	                        left = number;         
	                    } else {
	                        answer.append("R");
	                        right = number;                        
	                    }
	                }
	            }
	        }
	        return answer.toString();
	    }
	}
	
}
