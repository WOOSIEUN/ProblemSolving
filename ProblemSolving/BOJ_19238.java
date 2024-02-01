import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Car extends Point {
		int fuel;

		public Car(int x, int y, int fuel) {
			super(x, y);
			this.fuel = fuel;
		}
		
		private void driveCar(int x, int y, int consumedFuel) {
			this.x = x;
			this.y = y;
			fuel -= consumedFuel;
		}
		
		private void fuelUp(int fuelAmount) {
			fuel += fuelAmount;
		}
	}
	
	static class Passenger extends Point {
		int desX, desY;

		public Passenger(int x, int y, int desX, int desY) {
			super(x, y);
			this.desX = desX;
			this.desY = desY;
		}
	}	
	
	static int N, M;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] map;
	static Car taxi;
	static LinkedList<Passenger> passengers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		
		map = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());			
			for (int j = 0; j < N; j++) {				
				map[i][j] = (Integer.parseInt(st.nextToken()) == 0 ? true : false);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		taxi = new Car(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, fuel);
		
		passengers = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			passengers.add(new Passenger(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
		}
		
		boolean completed = true;
		while (!passengers.isEmpty()) {
			int[] nextPassenger = getNextPassenger(taxi);
			
			if (nextPassenger[0] == -1 || nextPassenger[1] > taxi.fuel) {
				completed = false;
				break;
			}

			Passenger next = passengers.get(nextPassenger[0]);
			passengers.remove(nextPassenger[0]);
			
			int consumedFuel = getMinDist(next.x, next.y, next.desX, next.desY);

			if (consumedFuel == -1 || nextPassenger[1] + consumedFuel > taxi.fuel) {
				completed = false;
				break;
			}
			
			taxi.driveCar(next.desX, next.desY, nextPassenger[1] + consumedFuel);
			taxi.fuelUp(consumedFuel * 2);
		}
		
		bw.write(String.valueOf((completed ? taxi.fuel : -1)));
		br.close();
		bw.close();
	}
	
	private static int[] getNextPassenger(Car taxi) {
		int[] nextPassenger = {-1, Integer.MAX_VALUE};
		for (int i = 0; i < passengers.size(); i++) {
			Passenger cur = passengers.get(i);			
			int dist = getMinDist(taxi.x, taxi.y, cur.x, cur.y);
			
			if (dist == -1) {
				continue;
			}
			
			if (nextPassenger[0] == -1) {
				nextPassenger[0] = i;
				nextPassenger[1] = dist;
				continue;
			}
			
			if (nextPassenger[1] == dist) {
				Passenger next = passengers.get(nextPassenger[0]);
				
				if (next.x == cur.x) {
					if (next.y > cur.y) {
						nextPassenger[0] = i;
						nextPassenger[1] = dist;
					}
				} else if (next.x > cur.x) {
					nextPassenger[0] = i;
					nextPassenger[1] = dist;
				}
			} else if (nextPassenger[1] > dist) {
				nextPassenger[0] = i;
				nextPassenger[1] = dist;
			}
		}
		
		return nextPassenger;
	}
	
	private static int getMinDist(int fromX, int fromY, int toX, int toY) {
		boolean[][] visited = new boolean [N][N];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(fromX, fromY));
		visited[fromX][fromY] = true;
		
		int dist = 0;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				Point cur = queue.poll();
				
				if (cur.x == toX && cur.y == toY) {
					return dist;
				}
				
				for (int[] dir : dirs) {
					int nx = cur.x + dir[0];
					int ny = cur.y + dir[1];
					
					if (!isInMap(nx, ny) || visited[nx][ny] || !map[nx][ny]) {
						continue;
					}
					
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
			
			dist++;
		}
		
		return -1;		
	}
	
	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
