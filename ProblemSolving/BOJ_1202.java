import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
	static class Jewel implements Comparable<Jewel>{
		int weight;
		int price;
		
		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		
		@Override
		public int compareTo(Jewel jewel) {
			if (this.weight == jewel.weight) {
				return jewel.price - this.price;
			}
			return this.weight - jewel.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long ans = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewel[] jewels = new Jewel [N];
		int[] bags = new int [K];		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(weight, price); 
		}
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewels);
		Arrays.sort(bags);
		
		PriorityQueue<Integer> candidates = new PriorityQueue<>(Comparator.reverseOrder());
		int jewelIdx = 0;
		for (int bagLimit : bags) {
			while (jewelIdx < N && jewels[jewelIdx].weight <= bagLimit) {
				candidates.add(jewels[jewelIdx++].price);
			}
			if (!candidates.isEmpty()) {
				ans += candidates.poll();
			}
		}
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
