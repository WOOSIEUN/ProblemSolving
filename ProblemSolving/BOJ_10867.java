import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_10867 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> nums = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<Integer> list = new ArrayList<>(nums);
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int num : list) {
			sb.append(num).append(" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
