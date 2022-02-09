import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class BOJ_2075 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				pQueue.offer(Integer.parseInt((st.nextToken())));
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			result = pQueue.poll();
		}
		System.out.println(result);
	}

}
