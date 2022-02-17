import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9663 {
	static int N, ans;
	static int col[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		col = new int[N+1];
		setQueen(1);
		bw.write(""+ans);
		br.close();
		bw.close();
	}
	
	public static void setQueen(int row) {		
		if(!isAvailable(row-1)) return;
		if(row>N) {
			ans++;
			return;
		}		
		for (int i = 1; i <= N; i++) {
			col[row] = i;
			setQueen(row+1);
		}
	}

	private static boolean isAvailable(int row) {
		for (int i = 1; i < row; i++) {
			if(col[row] == col[i] || row-i == Math.abs(col[row] - col[i])) return false;
		}
		return true;
	}
}
