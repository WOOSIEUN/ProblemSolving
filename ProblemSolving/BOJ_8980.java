import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8980 {
	static class Box implements Comparable<Box> {
		int from, to, numOfPackage;
		
		public Box(int from, int to, int numOfPackage) {
			this.from = from;
			this.to = to;
			this.numOfPackage = numOfPackage;
		}
		
		@Override
		public int compareTo(Box box) {
			if (this.to == box.to) {
				return this.from - box.from; 
			}			
			return this.to - box.to;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		int[] village = new int [N];
		for (int i = 0; i < N; i++) {
			village[i] = C;
		}
		
		Box[] boxes = new Box [M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			boxes[i] = new Box(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(boxes);
		
		int ans = 0;
		for (int i = 0; i < M; i++) {
			Box box = boxes[i];
			
			int minBox = C;
			for (int j = box.from; j < box.to; j++) {
				minBox = Math.min(minBox, village[j]);
			}
			
			if (minBox == 0) {
				continue;
			}
			
			int numOfDeliverableBoxes = (minBox < box.numOfPackage ? minBox : box.numOfPackage);
			for (int j = box.from; j < box.to; j++) {
				village[j] -= numOfDeliverableBoxes;
			}
			ans += numOfDeliverableBoxes;
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
