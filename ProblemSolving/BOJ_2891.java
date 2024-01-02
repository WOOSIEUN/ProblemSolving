import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2891 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[] kayak = new int [N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			kayak[Integer.parseInt(st.nextToken())] -= 1;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			kayak[Integer.parseInt(st.nextToken())] += 1;
		}
		
		for (int i = 1; i < N; i++) {
			if (kayak[i] == -1 && kayak[i + 1] == 1) {
				kayak[i] += 1;
				kayak[i + 1] -= 1;
			} else if (kayak[i] == 1 && kayak[i + 1] == -1) {
				kayak[i] -= 1;
				kayak[i + 1] += 1;
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (kayak[i] == -1) {
				ans++;
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
