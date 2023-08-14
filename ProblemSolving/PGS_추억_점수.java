import java.util.*;
public class PGS_추억_점수 {
	
	class Solution {
    	public int[] solution(String[] name, int[] yearning, String[][] photo) {
			int[] answer = new int [photo.length];
			HashMap<String, Integer> missingScore = new HashMap<> ();
			for (int i = 0; i < name.length; i++) {
				missingScore.put(name[i], yearning[i]);
			}
			for (int i = 0; i < photo.length; i++) {
				for (String person : photo[i]) {
					answer[i] += missingScore.getOrDefault(person, 0);
				}
			}
			return answer;
    	}	
	}	
	
}
