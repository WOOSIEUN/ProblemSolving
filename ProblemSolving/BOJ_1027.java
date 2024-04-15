import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1027 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] buildings = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxCount = 0;
		for (int cur = 0; cur < N; cur++) {
			int count = 0;
			int left = cur, right = cur;
			
			double prevSlope = Double.MAX_VALUE;
			while (--left >= 0) {
				double slope = getSlope(cur, buildings[cur], left, buildings[left]);
				 if (prevSlope > slope) {
		                prevSlope = slope;
		                count++;
		           }
			}
			
			prevSlope = -Double.MAX_VALUE;
			while (++right < N) {
				double slope = getSlope(right, buildings[right], cur, buildings[cur]);
				 if (prevSlope < slope) {
		                prevSlope = slope;
		                count++;
		           }
			}
			
			maxCount = Math.max(maxCount, count);
		}
		
		bw.write(String.valueOf(maxCount));
		br.close();
		bw.close();
	}

	private static double getSlope(int startX, int startY, int endX, int endY) {
		return (double) (endY - startY) / (endX - startX);
	}
}
