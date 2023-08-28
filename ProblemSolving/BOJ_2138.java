import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2138 {
	
	static int N, ans = Integer.MAX_VALUE;
	static char[][] srcBulbs;
	static char[] desBulbs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		srcBulbs = new char [2][N];
		srcBulbs[0] = br.readLine().toCharArray();
		srcBulbs[1] = srcBulbs[0].clone();
		desBulbs = br.readLine().toCharArray();		

		pressSwitch(0, 0);
		findMinCount(1, 1, 0);
		findMinCount(1, 0, 1);
		
		bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));
		br.close();
		bw.close();
	}

	private static void findMinCount(int index, int count, int targetBulbs) {
		if (index == N) {
			if (srcBulbs[targetBulbs][index - 1] == desBulbs[index - 1]) {
				ans = Math.min(ans, count);
			}
			return;
		}
		
		if (srcBulbs[targetBulbs][index - 1] != desBulbs[index - 1]) {
			pressSwitch(targetBulbs, index);
			findMinCount(index + 1, count + 1, targetBulbs);			
		} else {
			findMinCount(index + 1, count, targetBulbs);
		}
	}

	private static void pressSwitch(int targetBulbs, int index) {
		for (int i = index - 1; i <= index + 1; i++) {
            if (0 <= i && i < N) {
            	srcBulbs[targetBulbs][i] = srcBulbs[targetBulbs][i] == '1' ? '0' : '1';
            }
        }
	}
}
