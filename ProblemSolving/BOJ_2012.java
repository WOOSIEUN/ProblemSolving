import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2012 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] student = new int [N];
		for (int i = 0; i < N; i++) {
			student[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(student);
		
		long complaint = 0;
		for (int i = 0; i < N; i++) {
			complaint += Math.abs(student[i] - i - 1);
		}
		
		bw.write(String.valueOf(complaint));
		br.close();
		bw.close();
	}
}
