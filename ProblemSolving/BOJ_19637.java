import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_19637 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] score = new int [N];
		String[] title = new String [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			title[i] = st.nextToken();
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(br.readLine());
			
			int left = 0, right = N - 1;
			while (left <= right) {
				int mid = (left + right) / 2;				
				if (score[mid] < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			sb.append(title[left]).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
