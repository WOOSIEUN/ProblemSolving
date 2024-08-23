import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10101 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		bw.write(getSortOfTriangle(A, B, C));
		br.close();
		bw.close();
	}

	private static String getSortOfTriangle(int A, int B, int C) {
		if (A == B && B == C) {
			return "Equilateral";
		} else if (A + B + C == 180) {
			if (A == B || B == C || C == A) {
				return "Isosceles";
			} else {
				return "Scalene";
			}
		} else {
			return "Error";
		}
	}
}
