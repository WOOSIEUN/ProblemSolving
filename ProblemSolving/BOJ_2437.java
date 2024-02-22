import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2437 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] weight = new int [N];
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weight);
		
		int sum = 1;
		for(int i = 0; i < N; i++) {
			 if (sum < weight[i]) {
				 break;
			 }
			 
			 sum += weight[i];
		}
		
		bw.write(String.valueOf(sum));
		br.close();
		bw.close();
	}
}
