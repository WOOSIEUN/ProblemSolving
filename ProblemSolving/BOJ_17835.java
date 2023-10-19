import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17835 {
	static class Node implements Comparable<Node> {
        int city;
        long weight;

        public Node(int city, long weight) {
            this.city = city;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.weight, node.weight);
        }
    }
	
	static int N, M, K;
	static long[] minDist;
	static ArrayList<Node>[] cities;
	static PriorityQueue<Node> cityQueue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cities = new ArrayList [N + 1];
		for (int i = 1; i < N + 1; i++) {
			cities[i] = new ArrayList<>();
		}
		
		minDist = new long [N + 1];
		for (int i = 1; i < N + 1; i++) {
			minDist[i] = Long.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			cities[to].add(new Node(from, weight));
		}
		
		cityQueue = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int interviewPlace = Integer.parseInt(st.nextToken());
			cityQueue.add(new Node(interviewPlace, 0));
			minDist[interviewPlace] = 0;
		}
		
		findDistanceForInterview();
		Node answer = getMaxDistanceCity();
		
		bw.write(answer.city + "\n" + answer.weight);
		br.close();
		bw.close();
	}

	private static Node getMaxDistanceCity() {
		int city = 0;
		long maxDist = 0;
		
		for (int i = 1; i < N + 1; i++) {
			if (maxDist < minDist[i]) {
				city = i;
				maxDist = minDist[i];	
			}		
		}
		return new Node(city, maxDist);
	}

	private static void findDistanceForInterview() {
		while (!cityQueue.isEmpty()) {
			Node cur = cityQueue.poll();
			
			if (minDist[cur.city] < cur.weight) {
				continue;
			}
			
			for (Node next : cities[cur.city]) {
				if (minDist[next.city] > minDist[cur.city] + next.weight) {
					minDist[next.city] = minDist[cur.city] + next.weight;
					cityQueue.add(new Node(next.city, minDist[next.city]));
				}
			}
		}
	}
}