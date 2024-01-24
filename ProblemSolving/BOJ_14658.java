import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14658 {
	static class ShootingStar {
		int x, y;
		
		public ShootingStar(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, L, K;
	static ArrayList<ShootingStar> shootingStars;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		shootingStars = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			shootingStars.add(new ShootingStar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int maxShootingStar = 0;
		for (ShootingStar firstShootingStar : shootingStars) {
			for (ShootingStar secondShootingStar : shootingStars) {
				maxShootingStar = Math.max(maxShootingStar, getNumOfShootingStars(firstShootingStar.x, secondShootingStar.y));
			}
		}
		
		bw.write(String.valueOf(K - maxShootingStar));
		br.close();
		bw.close();
	}

	private static int getNumOfShootingStars(int X, int Y) {
		int numOfShootingStars = 0;
		for (ShootingStar shootingStar : shootingStars) {
			if (isInTrampolin(X, Y, shootingStar.x, shootingStar.y)) {
				numOfShootingStars++;
			}
		}
		return numOfShootingStars;
	}

	private static boolean isInTrampolin(int X, int Y, int x, int y) {
		return X <= x && x <= X + L && Y <= y && y <= Y + L;
	}
}
