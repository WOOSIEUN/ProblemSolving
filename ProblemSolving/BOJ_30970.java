import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_30970 {
	static class Miniature {
		int price, quality;
		
		public Miniature(int quality, int price) {
			this.price = price;
			this.quality = quality;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Miniature[] miniatures = new Miniature[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			miniatures[i] = new Miniature(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		
		Arrays.sort(miniatures, new Comparator<Miniature>() {
			@Override
			public int compare(Miniature o1, Miniature o2) {
				if (o1.quality == o2.quality) {
					return o1.price - o2.price;
				}
				return o2.quality - o1.quality;
			}
		});
		
		sb.append(miniatures[0].quality).append(" ").append(miniatures[0].price).append(" ");		
		sb.append(miniatures[1].quality).append(" ").append(miniatures[1].price).append("\n");
		
		Arrays.sort(miniatures, new Comparator<Miniature>() {
			@Override
			public int compare(Miniature o1, Miniature o2) {
				if (o1.price == o2.price) {
					return o2.quality - o1.quality;
				}
				return o1.price - o2.price;
			}
		});

		sb.append(miniatures[0].quality).append(" ").append(miniatures[0].price).append(" ");		
		sb.append(miniatures[1].quality).append(" ").append(miniatures[1].price).append("\n");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
