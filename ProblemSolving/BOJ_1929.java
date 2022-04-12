import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1929 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		arr[0] = arr[1] = 1;		
		for (int i = 2; i <= N; i++) {
			if (arr[i] == 0) {
				if (M <= i)
					sb.append(i).append("\n");
				for (int j = 1; i*j <= N; j++)
					arr[i*j] = 1;
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
