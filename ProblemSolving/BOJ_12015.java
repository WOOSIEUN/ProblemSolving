import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12015 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int [N];
		int[] LIS = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int LISLen = 1;
		LIS[0] = sequence[0];
		
		for (int i = 1; i < N; i++) {
			int cur = sequence[i];
			if (LIS[LISLen - 1] < cur) {
				LIS[LISLen++] = cur;
			} else {
				int low = 0;
				int high = LISLen - 1;
				while (low < high) {
					int mid = (low + high) / 2;
					if (LIS[mid] < cur) {
						low = mid + 1;
					} else {
						high = mid;
					}
				}
				LIS[low] = cur;
			}
		}
		
		bw.write(String.valueOf(LISLen));
		br.close();
		bw.close();
	}
}
