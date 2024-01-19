import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_17837 {
	static class ChessPiece {
		int x, y, dir;
		
		public ChessPiece(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static int N, K;
	static int[][] mapColor, dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	static ChessPiece[] chessPieces;
	static LinkedList<Integer>[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mapColor = new int [N][N];
		chessPieces = new ChessPiece [K];
		map = new LinkedList [N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
				mapColor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			
			if (dir == 1) {
				dir = 2;
			} else if (dir == 2) {
				dir = 1;
			}
			
			chessPieces[i] = new ChessPiece(x, y, dir);
			map[x][y].add(i);
		}
		
		bw.write(String.valueOf(playGame()));
		br.close();
		bw.close();
	}

	private static int playGame() {
		for (int turn = 1; turn <= 1000; turn++) {
			for (int i = 0; i < K; i++) {
				int nx = chessPieces[i].x + dirs[chessPieces[i].dir][0];
				int ny = chessPieces[i].y + dirs[chessPieces[i].dir][1];
				
				if (!isInMap(nx, ny) || mapColor[nx][ny] == 2) {
					chessPieces[i].dir = (chessPieces[i].dir + 2) % 4;
					nx = chessPieces[i].x + dirs[chessPieces[i].dir][0];
					ny = chessPieces[i].y + dirs[chessPieces[i].dir][1];
					
					if (!isInMap(nx, ny) || mapColor[nx][ny] == 2) {
						continue;
					}
				}

				movePiece(i, nx, ny);
				
				if (isGameOver(nx, ny)) {
					return turn;
				}
			}
		}		
		return -1;
	}

	private static boolean isGameOver(int x, int y) {
		if (map[x][y].size() >= 4) {
			return true;
		}
		return false;
	}

	private static void movePiece(int pieceIdx, int nx, int ny) {
		int x = chessPieces[pieceIdx].x, y = chessPieces[pieceIdx].y;
		int pieceOrder = getOrder(pieceIdx, x, y);
		int curPiece = -1;
		while (map[x][y].size() > pieceOrder) {
			if (mapColor[nx][ny] == 0) {			
				curPiece = map[x][y].remove(pieceOrder);
			} else {
				curPiece = map[x][y].removeLast();
			}
			
			chessPieces[curPiece].x = nx;
			chessPieces[curPiece].y = ny;
			map[nx][ny].add(curPiece);
		}
	}

	private static int getOrder(int pieceIdx, int x, int y) {
		for (int i = 0; i < map[x][y].size(); i++) {
			if (map[x][y].get(i) == pieceIdx) {
				return i;
			}
		}
		return -1;
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
