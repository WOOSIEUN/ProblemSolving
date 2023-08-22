import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644 {
	
	static int ans = -1, n, from, to;
	static ArrayList<Integer>[] family;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		family = new ArrayList [n + 1];
		visited = new boolean [n + 1];
		for (int i = 0; i < n + 1; i++) {
			family[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());
		
		int numOfPairs = Integer.parseInt(br.readLine());
		for (int i = 0; i < numOfPairs; i++) {
			st = new StringTokenizer(br.readLine());
			int personA = Integer.parseInt(st.nextToken());
			int personB= Integer.parseInt(st.nextToken());
			family[personA].add(personB);
			family[personB].add(personA);
		}
	
		getDegreesOfKinship(from, 0);
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

	private static void getDegreesOfKinship(int curPerson, int count) {
		if (curPerson == to) {
			ans = count;
		}
		for (int nextPerson : family[curPerson]) {
			if (!visited[nextPerson]) {
				visited[nextPerson] = true;
				getDegreesOfKinship(nextPerson, count + 1);
			}			
		}
	}
}
