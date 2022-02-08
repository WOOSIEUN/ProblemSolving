import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {
	static int N, cur, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			cnt = 1;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) queue.add(Integer.parseInt(st.nextToken()));
			while(true) {
				cur = queue.poll() - cnt;
				if(cur <= 0) {
					queue.add(0);
					break;
				}
				queue.add(cur);
				if(++cnt > 5) cnt = 1;
			}
			System.out.printf("#%d ", t);
			while(!queue.isEmpty())
				System.out.print(queue.poll() + " ");
			System.out.println();
		}
		br.close();
	}

}
