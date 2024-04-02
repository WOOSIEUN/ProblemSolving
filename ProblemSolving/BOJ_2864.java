import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2864 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] changedA = changeNumber(A);
		int[] changedB = changeNumber(B);	
		
		bw.write((changedA[1] + changedB[1]) + " " + (changedA[0] + changedB[0]));
		br.close();
		bw.close();
	}

	private static int[] changeNumber(int n) {
		StringBuilder max = new StringBuilder();
		StringBuilder min = new StringBuilder();
		
		while (n > 0) {
			int remain = n % 10;
			n /= 10;
			
			max.append(remain == 5 ? 6 : remain);
			min.append(remain == 6 ? 5 : remain);
		}
		
		int[] res = {Integer.parseInt(max.reverse().toString()), Integer.parseInt(min.reverse().toString())};		
		return res;
	}
}
