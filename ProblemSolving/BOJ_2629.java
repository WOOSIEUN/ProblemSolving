import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2629 {
	static int weightNum, marbleNum, marble;
	static int[] weight, available;
	static boolean[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		weightNum = Integer.parseInt(br.readLine());
		weight = new int [weightNum+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < weightNum; i++) weight[i] = Integer.parseInt(st.nextToken());
		dp = new boolean [weightNum+1][15001];
		dp(0, 0);
		marbleNum = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < marbleNum; i++) {
			marble = Integer.parseInt(st.nextToken());
			if(marble > 15000) sb.append("N ");
			else if (dp[weightNum][marble]) sb.append("Y ");
			else sb.append("N ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static void dp(int idx, int w) {
		if(idx > weightNum || dp[idx][w]) return;
		dp[idx][w] = true;
		dp(idx + 1, w + weight[idx]);
		dp(idx + 1, Math.abs(w - weight[idx]));
		dp(idx + 1, w);
	}
}
