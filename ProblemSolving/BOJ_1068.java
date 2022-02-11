import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BOJ_1068 {	
	static ArrayList<Integer>[] adjList;
	static boolean [] isVisited;
	static int cnt, root, del;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N];
		for( int i = 0 ; i < N ; i++ )
			adjList[i] = new ArrayList<Integer>();
		isVisited = new boolean[N];
				
    	st = new StringTokenizer(br.readLine());
    	int parent;
		for (int i = 0; i < N; i++) {
			parent = Integer.parseInt(st.nextToken());
			if (parent == -1) root = i;
			else {				
				adjList[parent].add(i);
				adjList[i].add(parent);
			}
		}		
		del = Integer.parseInt(br.readLine());
		if(root != del)
			dfs(root);
		System.out.println(cnt);
		br.close();
	}

	private static void dfs(int vertex) {
		isVisited[vertex] = true;	
		boolean flag = false;
		for (Integer cur : adjList[vertex])
			if(!isVisited[cur] && cur != del) {
				dfs(cur);
				flag=true;
			}
		if(!flag) cnt++;
	}

}
