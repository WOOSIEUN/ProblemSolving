import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655 {
	
	static StringBuilder sb;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		selected = new boolean [N];
		combi(0, 0, arr, M);
				
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void combi(int start, int cnt, int[] arr, int M) {
		if (cnt == M) {
	        for (int i = 0; i < arr.length; i++) {
	            if (selected[i]) {
	                sb.append(arr[i]).append(" ");
	            }
	        }
	        sb.append("\n");
	        return;
	    }

	    for (int i = start; i < arr.length; i++) {
	        selected[i] = true;
	        combi(i + 1, cnt + 1, arr, M);
	        selected[i] = false;
	    }
	}
}
