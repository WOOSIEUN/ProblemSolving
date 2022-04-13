import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9205 {
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n, x, y, dist;
	static boolean [][] arr;
	static ArrayList<Node> list;
	static Node cur, next;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<Node>();
			arr = new boolean[n+2][n+2];
			for(int i = 0; i < n+2; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                list.add(new Node(x,y));
            }
			for(int i=0; i < n+2; i++) {
                for(int j = 0; j < n+2; j++) {
                    if(i==j) continue;
                    cur = list.get(i);
                    next = list.get(j);
                    if(Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y) <= 1000) arr[i][j] = true;
                }
            }
			floydWarshall();
			if (arr[0][n+1]) sb.append("happy").append("\n");
            else sb.append("sad").append("\n");			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void floydWarshall() {
        for(int k = 0; k < n+2; k++)
            for(int i = 0; i < n+2; i++)
                for(int j = 0; j < n+2; j++)
                    if(arr[i][k] && arr[k][j])
                        arr[i][j] = true;
    }
}
