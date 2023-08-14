import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1765 {
	
	static ArrayList<Integer> [] friendsList, enemiesList;
	static boolean [] friendsVisited, enemiesVisited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int answer = 0;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		friendsList = new ArrayList [n + 1];
        for (int i = 1; i <= n; i++) {
        	friendsList[i] = new ArrayList<>();
        }
        enemiesList = new ArrayList [n + 1];
        for (int i = 1; i <= n; i++) {
        	enemiesList[i] = new ArrayList<>();
        }
				
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char type = st.nextToken().charAt(0);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (type == 'F') {
				friendsList[from].add(to);
				friendsList[to].add(from);
			} else {
				enemiesList[from].add(to);
				enemiesList[to].add(from);				
			}
		}
		
		for (int i = 1; i <= n; i++) {
			enemiesVisited = new boolean [n + 1];
			findFriendByEnemy(i, i, 0);
		}
		
		friendsVisited = new boolean [n + 1];
		for (int i = 1; i <= n; i++) {
			if (friendsVisited[i]) {
				continue;
			}
			answer++;
			findGroupOfFriends(i);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	
	private static void findFriendByEnemy(int startNode, int curNode, int depth) {
		if (depth == 2) {
			friendsList[startNode].add(curNode);
			return;
		}
		
		for (Integer nextNode : enemiesList[curNode]) {
			if (enemiesVisited[nextNode]) {
				continue;
			}
			enemiesVisited[nextNode] = true;
			findFriendByEnemy(startNode, nextNode, depth + 1);
		}
	}
	
	private static void findGroupOfFriends(int curNode) {
		for (Integer nextNode : friendsList[curNode]) {
			if (friendsVisited[nextNode]) {
				continue;
			}
			friendsVisited[nextNode] = true;
			findGroupOfFriends(nextNode);
		}
	}
}
