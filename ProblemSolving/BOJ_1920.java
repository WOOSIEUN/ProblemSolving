import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(isExist(Integer.parseInt(st.nextToken()), num, 0, N - 1) ? 1 : 0).append("\n");
		}		
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static boolean isExist(int target, int[] num, int start, int end) {
		if (start > end) {
			return false;
		}
		
		int mid = (start + end) / 2;
		if (num[mid] == target) {
			return true;
		} else if (num[mid] > target) {
			return isExist(target, num, start, mid - 1);
		} else {
			return isExist(target, num, mid + 1, end);
		}
	}
}
