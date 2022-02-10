import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {
	static int x,y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		boolean [][] paper = new boolean[101][101];		
		for (int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + 10; j++)
				for (int k = y; k < y + 10; k++)
					if(!paper[j][k]) {
						sum++;
						paper[j][k] = true;
					}		
		}
		System.out.println(sum);
		br.close();	
		
	}
}
