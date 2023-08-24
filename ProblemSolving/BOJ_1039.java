import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1039 {
	static class Number {
		int num, cnt;
		
		public Number(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	static int N, K, ans = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		changeNum(N);
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

	private static void changeNum(int n2) {
		int numLen = String.valueOf(N).length();
        boolean[][] visited = new boolean[1000001][K + 1];
		Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(N, 0));
        visited[N][0] = true;
        
        while (!queue.isEmpty()) {
        	Number cur = queue.poll();
        	if (cur.cnt == K) {
        		ans = Math.max(ans, cur.num);
        		continue;
        	}
        	
        	for (int i = 0; i < numLen - 1; i++) {
        		for (int j = i + 1; j < numLen; j++) {
        			int swapedNum = swap(cur.num, i, j);
        			if (swapedNum != -1 && !visited[swapedNum][cur.cnt + 1]) {
        				visited[swapedNum][cur.cnt + 1] = true;
        				queue.add(new Number(swapedNum, cur.cnt + 1));
        			}
        		}
        	}
        }
	}

	private static int swap(int number, int i, int j) {
		char[] numberCharArr = String.valueOf(number).toCharArray();
		
		if (i == 0 && numberCharArr[j] == '0') {
			return -1;
		}
		
		char tmp = numberCharArr[j];
		numberCharArr[j] = numberCharArr[i];
		numberCharArr[i] = tmp;
		
		return Integer.valueOf(String.valueOf(numberCharArr));
	}
}
