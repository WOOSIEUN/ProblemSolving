import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] lesson = new int[N];
		int maxLen = 0, sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			maxLen = Math.max(maxLen, lesson[i]);
			sum += lesson[i];
		}
		
		bw.write(String.valueOf(getLenOfBluray(maxLen, sum, lesson, M)));
		br.close();
		bw.close();
	}

	private static int getLenOfBluray(int left, int right, int[] lesson, int M) {
		while (left <= right) {
			int sum = 0, cnt = 1; 
			int mid = (left + right) / 2;
			
			for (int i = 0; i < lesson.length; i++) {
				sum += lesson[i];
				
				if (sum > mid) {
					sum = lesson[i];
					cnt++;
				}
			}
			
			if (cnt <= M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
}
