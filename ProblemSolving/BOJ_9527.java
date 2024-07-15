import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
				
		bw.write(String.valueOf(getNumOfOnesInRange(A, B)));
		br.close();
		bw.close();
	}

	private static long getNumOfOnesInRange(long A, long B) {
		final int MAX = 55;
		long[] numOfOnes = new long [MAX];

		numOfOnes[0] = 1;
		for (int i = 1; i < MAX; i++) {
			numOfOnes[i] = numOfOnes[i - 1] * 2 + (1L << i);
		}		
		
		return getNumOfOnes(B, numOfOnes) - getNumOfOnes(A - 1, numOfOnes);
	}

	private static long getNumOfOnes(long target, long[] numOfOnes) {
		long ans = target & 1;

	    for (int i = numOfOnes.length - 1; i > 0; i--) {
	        if ((target & (1L << i)) > 0L) {
	            ans += numOfOnes[i - 1] + (target - (1L << i) + 1);
	            target -= (1L << i);
	        }
	    }
	    
	    return ans;
	}
}
