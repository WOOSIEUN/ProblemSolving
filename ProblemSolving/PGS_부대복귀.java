import java.util.*;

public class PGS_부대복귀 {
	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		ArrayList<Integer>[] graph = new ArrayList [n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] road : roads) {
			graph[road[0] - 1].add(road[1] - 1);
			graph[road[1] - 1].add(road[0] - 1);
		}

		int[] costs = getCosts(graph, destination - 1);

		int[] answer = new int[sources.length];
		for (int i = 0; i < sources.length; i++) {
			answer[i] = costs[sources[i] - 1];
		}

		return answer;
	}

	private int[] getCosts(ArrayList<Integer>[] graph, int start) {
		int[] costs = new int[graph.length];
		for (int i = 0; i < costs.length; i++) {
			costs[i] = -1;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		costs[start] = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : graph[cur]) {
				if (costs[next] == -1) {
					costs[next] = costs[cur] + 1;
					queue.add(next);
				}
			}
		}

		return costs;
	}
}
