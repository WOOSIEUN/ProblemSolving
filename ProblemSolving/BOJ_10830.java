import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10830 {
	
	static final int MOD = 1_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		int[][] matrix = new int [A][A];
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < A; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}
		
		int[][] result = pow(matrix, B);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static int[][] multiply(int[][] matrix1, int[][] matrix2) {		
		int[][] result = new int [matrix1.length][matrix1[0].length];
		
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				for (int k = 0; k < matrix2.length; k++) {					
					result[i][j] += matrix1[i][k] * matrix2[k][j];
					result[i][j] %= MOD;
				}
			}
		}
		
		return result;
	}
	
	private static int[][] pow(int[][] base, long exponent) {
		if (exponent == 1) {
			return base;
		}
		
		int[][] square = pow(base, exponent / 2);
		square = multiply(square, square);
		
	 	if (exponent % 2 == 1) {
			return multiply(square, base);
		}
	 	
		return square;
	}
}
