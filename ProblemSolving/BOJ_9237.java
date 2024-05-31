import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_9237 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] tree = new Integer [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree, Collections.reverseOrder());
		int max = tree[0] + 1;
		for (int i = 1; i < tree.length; i++) {
			max = Math.max(max, tree[i] + i + 1);
		}
		
		bw.write(String.valueOf(max + 1));
		br.close();
		bw.close();
	}
}
