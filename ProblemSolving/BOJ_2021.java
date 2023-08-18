import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2021 {
	static class Node implements Comparable<Node>{
		int station, line, transferCount;
		
		public Node(int station, int line, int transferCount) {
			this.station = station;
			this.line = line;
			this.transferCount = transferCount;
		}
		
		@Override
		public int compareTo(Node node) {
			return this.transferCount - node.transferCount;
		}
	}
	
	static ArrayList<Integer>[] stations, lines;
	static boolean[] visitedStation, visitedLine;
	static int startStation, endStation;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		stations = new ArrayList [N + 1];
		lines = new ArrayList [L];
		visitedStation = new boolean [N + 1];
		visitedLine = new boolean [L];
		for (int i = 1; i < N + 1; i++) {
			stations[i] = new ArrayList<>();
		}
		
		for (int curLine = 0; curLine < L; curLine++) {
			lines[curLine] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int curStation = -1;
			while ((curStation = Integer.parseInt(st.nextToken())) != -1) {
				stations[curStation].add(curLine);
				lines[curLine].add(curStation);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		startStation = Integer.parseInt(st.nextToken());
		endStation = Integer.parseInt(st.nextToken());
		
		ans = getMinTransfer();
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

	private static int getMinTransfer() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int nextLine : stations[startStation]) {
			pq.add(new Node(startStation, nextLine, 0));
		}
		visitedStation[startStation] = true;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.station == endStation) {
				return cur.transferCount;
			}
			
			for (int nextStation : lines[cur.line]) {
				if (visitedStation[nextStation]) {
					continue;
				}				
				visitedStation[nextStation] = true;
				pq.add(new Node(nextStation, cur.line, cur.transferCount));
				
				for (int nextLine : stations[nextStation]) {
					if (visitedLine[nextLine]) {
						continue;
					}
					visitedLine[nextLine] = true;
					pq.add(new Node(nextStation, nextLine, cur.transferCount + 1));
				}
			}
		}		
		return -1;
	}
}
