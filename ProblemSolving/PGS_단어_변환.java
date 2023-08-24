
public class PGS_단어_변환 {
	
	class Solution {
		
	    int answer = 52;
	    String targetWord;
	    String[] wordArr;
	    boolean[] visited;
	    
	    public int solution(String begin, String target, String[] words) {
	        visited = new boolean [words.length];
	        targetWord = target;
	        wordArr = words;
	        convertWord(begin, 0);
	        return answer == 52 ? 0 : answer;
	    }
	    
	    private void convertWord(String curWord, int cnt) {
	        if (curWord.equals(targetWord)) {
	            answer = Math.min(answer, cnt);
	            return;
	        }
	        
	        for (int i = 0; i < wordArr.length; i++) {          
	            if (!visited[i] && isSameExceptOneLetter(curWord, wordArr[i])) {
	                visited[i] = true;
	                convertWord(wordArr[i], cnt + 1);
	                visited[i] = false;
	            }
	        }
	    }
	    
	    private boolean isSameExceptOneLetter(String a, String b) {
	        int cnt = 0;
	        for (int i = 0; i < a.length(); i++) {
	            if (a.charAt(i) != b.charAt(i)) {
	               cnt++;
	            }
	        }
	        return cnt == 1 ? true : false;
	    }
	}
}
