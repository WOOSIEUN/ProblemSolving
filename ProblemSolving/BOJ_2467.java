import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] solution = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] idx = getSolutionsIndex(solution);
		
		bw.write(solution[idx[0]] + " " + solution[idx[1]]);
		br.close();
		bw.close();
	}

	private static int[] getSolutionsIndex(int[] solution) {
		int left = 0, right = solution.length - 1;
		int minLeft = 0, minRight = 0;
		long min = Long.MAX_VALUE;
		
		while (left < right) {
			long sum = (long) solution[left] + solution[right];
			
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				minLeft = left;
				minRight = right;
			}
			
			if (min == 0) {
				break;
			}
			
			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}
		
		return new int[] {minLeft, minRight};
	}
}
