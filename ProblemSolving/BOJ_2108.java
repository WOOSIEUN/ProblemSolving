import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2108 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int[] arr = new int [8001];
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num + 4000] += 1;
			sum += num;			
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		int rank = 0, median = 0, modeMax = Integer.MIN_VALUE, mode = 0;
		boolean flag = false;
		for(int i = min + 4000; i <= max + 4000; i++) {
			if (arr[i] == 0) {
				continue;
			}
			
			if (rank < (N + 1) / 2) {
				median = i - 4000;
				rank += arr[i];
			}
			
			if (modeMax < arr[i]) {
				modeMax = arr[i];
				mode = i - 4000;
				flag = true;
			} else if (modeMax == arr[i] && flag) {
				mode = i - 4000;
				flag = false;
			}
		}
		
		sb.append((int) Math.round((double) sum / N)).append("\n");
		sb.append(median).append("\n");
		sb.append(mode).append("\n");
		sb.append(max - min).append("\n");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
