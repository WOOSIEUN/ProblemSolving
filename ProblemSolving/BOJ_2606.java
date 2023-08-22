import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
	
	static ArrayList<Integer>[] computers;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int numOfComputers = Integer.parseInt(br.readLine());
		int numOfPairs = Integer.parseInt(br.readLine());
		
		computers = new ArrayList [numOfComputers + 1];
		visited = new boolean [numOfComputers + 1];
		for (int i = 1; i < numOfComputers + 1; i++) {
			computers[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < numOfPairs; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			computers[from].add(to);
			computers[to].add(from);
		}

		bw.write(String.valueOf(getInfectedComputer(1)));
		br.close();
		bw.close();
	}
	
	private static int getInfectedComputer(int start) {
		int numOfInfectedComputers = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int curComputer = queue.poll();
			for (int nextComputer : computers[curComputer]) {
				if (!visited[nextComputer]) {
					queue.add(nextComputer);
					visited[nextComputer] = true;
					numOfInfectedComputers++;
				}
			}
		}		
		return numOfInfectedComputers;
	}
}
