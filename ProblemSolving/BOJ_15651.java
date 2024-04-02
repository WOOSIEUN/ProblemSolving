import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15651 {
	
	static int N, M;
	static int[] numbers;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int [M];
		sb = new StringBuilder();
		
		permutation(0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void permutation(int cnt) {
        if (cnt == M) {
            for (int num : numbers) {
            	sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            numbers[cnt] = i + 1;
            permutation(cnt + 1);
        }
    }
}
