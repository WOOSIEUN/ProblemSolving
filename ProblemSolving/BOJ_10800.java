import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10800 {
	static class Ball implements Comparable<Ball>{
		int idx;
		int color;
		int size;
		
		public Ball(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
		
		@Override
		public int compareTo(Ball ball) {
			return this.size - ball.size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		long ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		Ball[] balls = new Ball [N];
		int[] sumByColor = new int [N + 1];
		int[] answer = new int [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(i, color, size);
		}
		Arrays.sort(balls);
		
		int sum = 0;
		int compareIdx = 0;
		for (int i = 0; i < N; i++) {
			Ball ball = balls[i];
			while (ball.size > balls[compareIdx].size) {
				sumByColor[balls[compareIdx].color] += balls[compareIdx].size;
				sum += balls[compareIdx++].size;
			}
			answer[ball.idx] = sum - sumByColor[ball.color];
		}	
		
		for (int i = 0; i < N; i++) {
			sb.append(answer[i] + "\n");
		}		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}