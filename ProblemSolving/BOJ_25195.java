import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_25195 {
	static ArrayList<Integer>[] list;
	static boolean[] isGomGomEE;
	static int N, M, S;
	static boolean meetGomGomEE = true;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++)
            list[i] = new ArrayList<>(); 
        
		int start, end;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			list[start].add(end);
		}
		
		S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		isGomGomEE = new boolean[N + 1];
        for(int i = 0; i < S; i++)
            isGomGomEE[Integer.parseInt(st.nextToken())] = true;
		
        dfs(1);
		
		if(meetGomGomEE) bw.write("Yes");
		else bw.write("yes");
		
		br.close();
		bw.close();
	}

	private static void dfs(int cur) {
		if(isGomGomEE[cur]) return;
		if (list[cur].size() == 0) {
            meetGomGomEE = false;
            return;
        }
		for (Integer next : list[cur])
			dfs(next);
	}
}
