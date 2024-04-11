import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] solution = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solution);
		int[] idx = getSolutionsIndex(solution);
		
		bw.write(solution[idx[0]] + " " + solution[idx[1]] + " " + solution[idx[2]]);
		br.close();
		bw.close();
	}

	private static int[] getSolutionsIndex(int[] solution) {
		int minFirst = 0, minLeft = 0, minRight = 0;
		long min = Long.MAX_VALUE;
		
		out : for (int first = 0; first < solution.length - 2; first++) {
			int left = first + 1;
			int right = solution.length - 1;
			
			while (left < right) {
				long sum = (long) solution[first] + solution[left] + solution[right];
				
				if (min > Math.abs(sum)) {
					min = Math.abs(sum);
					minFirst = first;
					minLeft = left;
					minRight = right;
				}
				
				if (min == 0) {
					break out;
				}
				
				if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		
		return new int[] {minFirst, minLeft, minRight};
	}
}
