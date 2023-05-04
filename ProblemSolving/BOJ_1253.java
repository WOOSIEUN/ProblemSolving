import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N - 1;
			while (start < end) {
				if (numbers[start] + numbers[end] == numbers[i]) {
					if (i == start) {
						start++;
					} else if (i == end) {
						end--;
					} else {
						answer++;
						break;
					}
				} else if (numbers[start] + numbers[end] < numbers[i]) {
					start++;
				} else {
					end--;
				}
			}
		}
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
}
