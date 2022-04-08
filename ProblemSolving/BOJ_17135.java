import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BOJ_17135 {
	static int N, M, D, max;
	static int[] archers;//궁수조합
	static ArrayList<Enemy> elist;//적군리스트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1.초기값 입력
		N = sc.nextInt();// 행
		M = sc.nextInt();// 열
		D = sc.nextInt();// 유효거리
		archers = new int[3];//궁수들의 열위치가 저장되어 있음
		
		//2.입력
		elist = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(sc.nextInt() == 1) {
					elist.add(new Enemy(i, j));//적군정보 저장
				}
			}
		}
		
		//3.궁수조합 만들기
		combi(0, 0);
		
		//4.결과 출력
		System.out.println(max);
	}

	//궁수의 조합이 만들어 질때마다 적군 처리(max)
	private static void combi(int cnt, int start) {
		if(cnt == 3) {//조합 한개 완성
			fire();
			return;
		}
		
		for (int i = start; i < M ; i++) {
			archers[cnt] = i;
			combi(cnt+1, start+1);
		}		
	}

	//정해진 조합으로 몇명이나 죽일 수 있나 계산
	private static void fire() {
		ArrayList<Enemy> elist2 = new ArrayList<>();//매조합마다 죽여봐야 하므로
		for (Enemy e : elist) {
			elist2.add(new Enemy(e.x, e.y));
		}
		
		int killed = gameStart(elist2, archers);//하나의 궁수 조합으로 사살된 적의 수 리턴		
		max = Math.max(max, killed);
	}

	//궁수 한사람씩 꺼내서 그 궁수에게서 가장 가까운 적을 찾아 죽일놈리스트에 추가
	private static int gameStart(ArrayList<Enemy> elist, int[] archers) {
		int cnt = 0;//죽은 적의 수
		
		while(elist.size() != 0) {
			ArrayList<Enemy> temp = new ArrayList<>();//모든 궁수가 죽일 적을 정하고 나서
			
			//궁수들 한명씩 쏴볼거임
			for (int position : archers) {//열값
				int targetIndex = findNear(elist, position);//현재 궁수에게서 가장 가까운 적의 인덱스 찾기
				if(targetIndex >= 0) {
					temp.add(elist.get(targetIndex));//나중에 죽일놈들
				}
			}//궁수 3명이 모두 temp에 죽일 적들 정보를 저장한 후
			
			for (Enemy e : temp) {
				if(elist.remove(e))
					cnt++;
			}			
			enemyDown(elist);//적들 하강			
		}		
		return cnt;
	}

	private static void enemyDown(ArrayList<Enemy> elist) {
		for (int i = 0; i < elist.size(); i++) {
			Enemy e = elist.get(i);
			e.x++;//아래로 내려옴
			
			//성벽에 닿았다면 die
			if(e.x == N) {
				elist.remove(i);//die
				i--;
			}
		}	
	}
	
	private static void enemyDown2(ArrayList<Enemy> elist) {
		Iterator<Enemy> it = elist.iterator();
		while(it.hasNext()) {//데이터가 있으면
			Enemy e = it.next();
			e.x++;
			
			if(e.x == N)
				it.remove();
		}		
	}
	//리스트에 저장된 적들 중 현재위치(position)에서 가장 가까운 적 인덱스(elist)를 리턴
	private static int findNear(ArrayList<Enemy> elist, int position) {
		 int minDistance = Integer.MAX_VALUE;//적과 가장 가까운 거리값
		 int minColumn = 50;//가장 가까운 적의 컬럼값
		 int minIndex = -1;//(elist 안에서 )가장 가까운 적의 인덱스
		 
		 for (int i = 0; i < elist.size(); i++) {
			Enemy e = elist.get(i);
			
			int d = (N - e.x) + Math.abs(position - e.y);//둘간의 거리
			if(d  > D) continue;
			
			if(d < minDistance) {//이전 최단거리보다 더 가까우면
				minDistance = d;
				minColumn = e.y;
				minIndex = i;
			
			}else if(d == minDistance) {
				if(e.y < minColumn) {//지금애가 더 왼쪽에 있음
					minColumn = e.y;
					minIndex = i;
				}
			}		
		}				
		return minIndex;
	}

	static class Enemy {
		int x, y;
		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}