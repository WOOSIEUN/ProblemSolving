import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] students = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(students);
		
		bw.write(String.valueOf(students[N - k]));
		br.close();
		bw.close();
	}
}
