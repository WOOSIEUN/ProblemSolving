import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_11286 {
	static int N, tmp;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<Integer>((o1,o2) -> {
			if(Math.abs(o1) > Math.abs(o2)) return 1;
			else if(Math.abs(o1) == Math.abs(o2)) return o1-o2;
			else return -1;
			});
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				if (pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll() + "\n");
			}
			else pq.offer(tmp);
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
