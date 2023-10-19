import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> cardQueue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			cardQueue.add(Integer.parseInt(br.readLine()));
		}
		
		while (cardQueue.size() > 1) {
			int sum = cardQueue.poll() + cardQueue.poll();
			ans += sum;
			cardQueue.add(sum);
		}	
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
