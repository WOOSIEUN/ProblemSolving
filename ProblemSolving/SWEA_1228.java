import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228 {
	static int N, M, x, y;
	static String cmd;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList <Integer> list = new LinkedList<>();
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				list.add(Integer.parseInt(st.nextToken()));
			M = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), "I ");
			while (st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for (int i = 0; i < y; i++)				
					list.add(x+i, Integer.parseInt(st.nextToken()));
			}		
			
			System.out.printf("#%d ", t);
			for (int i = 0; i < 10; i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
			list.clear();
		}
		br.close();
	}
}
