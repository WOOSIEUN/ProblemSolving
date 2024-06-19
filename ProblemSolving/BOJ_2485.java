import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] tree = new int [N];
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		int gcd = 0;
		for (int i = 0; i < N - 1; i++) {
            gcd = getGCD(gcd, tree[i+1] - tree[i]);
        }
		
		bw.write(String.valueOf((tree[N - 1] - tree[0]) / gcd + 1 - tree.length));
		br.close();
		bw.close();
	}

	private static int getGCD(int a, int b) {
		while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
		
        return a;
	}
}
