import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> trucks = new LinkedList<> ();	
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}		

		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		int time = 0, weight = 0;
		while (!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();
			
			if (trucks.isEmpty()) {
				continue;
			}
			
			if (trucks.peek() + weight <= L) {
				int truck = trucks.poll();
				bridge.add(truck);
				weight += truck;				
			} else {
				bridge.add(0);
			}
		}
		
		bw.write(String.valueOf(time));
		br.close();
		bw.close();
	}
}
