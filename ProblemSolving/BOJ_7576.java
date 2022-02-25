import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	static class Node {
		int x, y, day;
		
		public Node(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	static int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Queue<Node> q = new LinkedList<Node>();
	static Node cur;
	static int [][] tomato;
	static int M, N, result, nx, ny;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int [N][M];     
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) q.offer(new Node(i, j, 0));
			}
        }
        while (!q.isEmpty()) {
        	cur = q.poll();
        	result = cur.day;
        	for (int[] dir : dirs) {
				nx = cur.x + dir[0];
				ny = cur.y + dir[1];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && tomato[nx][ny] == 0) {
					tomato[nx][ny] = 1;
					q.offer(new Node(nx, ny, cur.day + 1));
				}
			}			
		}
        for (int i = 0; i < N; i++)
    		for (int j = 0; j < M; j++)
    			if(tomato[i][j] == 0) flag = true;
        if(flag) bw.write("-1");
        else bw.write("" + result);
        bw.close();
        br.close();
	}
}
