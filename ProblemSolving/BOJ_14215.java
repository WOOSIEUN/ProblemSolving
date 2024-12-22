import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] sticks = new int [3];
		sticks[0] = Integer.parseInt(st.nextToken());
		sticks[1] = Integer.parseInt(st.nextToken());
		sticks[2] = Integer.parseInt(st.nextToken());
		Arrays.sort(sticks);
		
		bw.write(String.valueOf(sticks[0] + sticks[1] > sticks[2] ? sticks[0] + sticks[1] + sticks[2] : (sticks[0] + sticks[1]) * 2 - 1));
		br.close();
		bw.close();
	}
}
