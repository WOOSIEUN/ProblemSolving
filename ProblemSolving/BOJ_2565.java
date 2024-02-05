import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565 {
	static class Wire implements Comparable<Wire> {
		int from, to;
		
		public Wire(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
		@Override
		public int compareTo(Wire wire) {
			return this.from - wire.from;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Wire[] wires = new Wire [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wires[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(wires);
		
		int maxWire = 0;
		int[] LIS = new int [N];
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(wires[j].to < wires[i].to) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
			
			maxWire = Math.max(maxWire, LIS[i]);
		}
		
		bw.write(String.valueOf(N - maxWire));
		br.close();
		bw.close();
	}
}
