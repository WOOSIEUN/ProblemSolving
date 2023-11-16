import java.util.*;
public class PGS_올바른_괄호 {
	
	class Solution {
		boolean solution(String s) {        
	        Stack<Character> stack = new Stack<>();
	        for(char cur : s.toCharArray()){
	            if (cur == '(') {
	                stack.push('(');
	            } else {
	                if (!stack.isEmpty()) {
	                    stack.pop();
	                } else {
	                    return false;
	                }
	            }
	        }
	        return stack.isEmpty() ? true : false;
	    }
	}
	
}
