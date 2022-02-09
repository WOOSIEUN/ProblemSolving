import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499 {
	static int N,separate;
	static Queue<String> left = new LinkedList<String>();
	static Queue<String> right = new LinkedList<String>();
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			separate = (N%2==0?N/2:N/2+1);
			for (int i = 0; i < separate; i++)
				left.add(st.nextToken());
			for (int i = separate; i < N; i++)
				right.add(st.nextToken());
			result = "";
			for (int i = 0; i < N/2; i++) {
				result += left.poll()+" ";
				result += right.poll()+" ";
			}
			if(separate != N/2) result += left.poll()+" ";
			System.out.printf("#%d %s\n", t, result);
		}
		br.close();
	}
}
