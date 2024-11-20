import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] materials = new int [N];
		for (int i = 0; i < N; i++) {
			materials[i] = Integer.parseInt(st.nextToken());
		}
		
        Arrays.sort(materials);
        
        int ans = 0;
		for (int left = 0, right = N - 1; left < right;) {
			if (materials[left] + materials[right] < M) {
				left++;
			} else if (materials[left] + materials[right] > M) {
				right--;
			} else {
				left++;
				right--;
				ans++;
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
