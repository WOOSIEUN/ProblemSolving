import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20044 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		int[] students = new int [2 * N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(students);
		
		int min = Integer.MAX_VALUE; 
		for (int i = 0; i < N; i++) {
			min = Math.min(min, students[i] + students[2 * N - i - 1]);
		}
		
		bw.write(String.valueOf(min));
		br.close();
		bw.close();
	}
}
