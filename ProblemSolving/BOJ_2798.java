import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2798 {
	
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cards = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		searchCards(cards, 0, 0, 0, M);
		
		bw.write(String.valueOf(max));
		br.close();
		bw.close();
	}

	private static void searchCards(int[] cards, int start, int cnt, int sum, int M) {
		if (cnt == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = start; i < cards.length; i++) {
			if (sum + cards[i] > M) {
				continue;
			}
			searchCards(cards, i + 1, cnt + 1, sum + cards[i], M);
		}
	}
}
