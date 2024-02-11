import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_24416 {
	
	static int cntByRecursive;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		fibonacciByRecursive(N);
		
		bw.write(cntByRecursive + " " + fibonacciByDP(N));
		br.close();
		bw.close();
	}
	
	private static int fibonacciByRecursive(int N) {
		if (N < 3) {			
			cntByRecursive++;
			return 1;
		}
				
		return fibonacciByRecursive(N - 2) + fibonacciByRecursive(N - 1);
	}
	
	private static int fibonacciByDP(int N) {
		int cnt = 0;
		
		int[] fibo = new int [N + 1];
		fibo[1] = 1;
		fibo[2] = 1;
		for (int i = 3; i < N + 1; i++, cnt++) {
			fibo[i] = fibo[i - 2] + fibo[i - 1];
		}
		
		return cnt;
	}
}
