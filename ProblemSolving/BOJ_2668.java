import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		for (int i = 1; i < num.length; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		List<Integer> cycleList = new ArrayList<>();
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i < visited.length; i++) {
            visited[i] = true;
            findCycle(i, i, num, visited, cycleList);
            visited[i] = false;
        }
		
		Collections.sort(cycleList);
		
		StringBuilder sb = new StringBuilder();
		sb.append(cycleList.size()).append("\n");
        for (int i = 0; i < cycleList.size(); i++) {
    		sb.append(cycleList.get(i)).append("\n");
        }
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void findCycle(int idx, int target, int[] num, boolean[] visited, List<Integer> cycleList) {
        if (num[idx] == target) {
        	cycleList.add(target);
        	return;
        }
        
		if (!visited[num[idx]]) {
            visited[num[idx]] = true;
            findCycle(num[idx], target, num, visited, cycleList);
            visited[num[idx]] = false;
        }
	}
}
