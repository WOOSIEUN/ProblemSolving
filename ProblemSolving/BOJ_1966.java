import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
	static class Document implements Comparable<Document> {
		int idx, weight;
		
		public Document(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Document document) {
			return this.weight - document.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int doc = Integer.parseInt(st.nextToken());
			
			Queue<Document> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				queue.add(new Document(i, Integer.parseInt(st.nextToken())));
			}
			
			int cnt = 1;
			while (true) {
				Document max = Collections.max(queue);
				Document cur = queue.poll();
				
				if (cur.weight == max.weight) {
					if (cur.idx == doc) {
						break;
					}
					cnt++;
				} else {
					queue.add(cur);
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
