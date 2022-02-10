import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder result = new StringBuilder("<");
		int idx = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) q.offer(i);
		while(!q.isEmpty()) {
			if(++idx % K ==0) result.append(String.valueOf(q.poll())).append(", ");
			else q.offer(q.poll());
		}
		result.replace(result.length()-2, result.length()-1, ">");
		bw.write(result.toString());
		br.close();
		bw.close();		
	}
}
