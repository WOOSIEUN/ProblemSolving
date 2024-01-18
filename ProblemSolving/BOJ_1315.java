import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1315 {
	
	static final int MAX = 1001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] STR = new int [N];
		int[] INT = new int [N];
		int[] PNT = new int [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br .readLine());
			STR[i] = Integer.parseInt(st.nextToken());
			INT[i] = Integer.parseInt(st.nextToken());
			PNT[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] possibleQuest = new boolean [MAX][MAX];
		int[][] availablePoint = new int [MAX][MAX];
		int[][] solvedQuest = new int [MAX][MAX];
		
		for (int curStr = 1; curStr < MAX; curStr++) {
	    	for (int curInt = 1; curInt < MAX; curInt++) {
	            int pointSum = 0;
	            
	            for (int questIdx = 0; questIdx < N; questIdx++) {
	                if (STR[questIdx] <= curStr || INT[questIdx] <= curInt) {
	                    solvedQuest[curStr][curInt] += 1;
	                    pointSum += PNT[questIdx];
	                }
	            }
	            
	            availablePoint[curStr][curInt] = pointSum - (curStr + curInt - 2);
	            
	            if (curStr == 1 && curInt == 1) {
	            	possibleQuest[curStr][curInt] = true;
	            	continue;
	            }
	            
	            if (possibleQuest[curStr - 1][curInt] && curStr >= 1 && availablePoint[curStr - 1][curInt] > 0) {
	            	possibleQuest[curStr][curInt] = true;
	            	continue;
	            }
	            
	            if (possibleQuest[curStr][curInt - 1] && curInt >= 1 && availablePoint[curStr][curInt - 1] > 0) {
	            	possibleQuest[curStr][curInt] = true;
	            	continue;
	            }
	        }
	    }
		
		int ans = 0;
		for (int curStr = 1; curStr < MAX; curStr++) {
	        for (int curInt = 1; curInt < MAX; curInt++) {
	        	if (possibleQuest[curStr][curInt]) {
	        		ans = Math.max(ans, solvedQuest[curStr][curInt]);
	        	}
	        }
	    }
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
