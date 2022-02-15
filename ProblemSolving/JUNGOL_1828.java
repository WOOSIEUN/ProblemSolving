import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JUNGOL_1828 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [][] chemical = new int[N][2];
		for (int i = 0; i < chemical.length; i++) {
			st = new StringTokenizer(br.readLine());
			chemical[i][0] = Integer.parseInt(st.nextToken());
			chemical[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(chemical, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int max = chemical[0][1], refri = 1;
		for (int i = 0; i < chemical.length; i++) {
			if(chemical[i][0] > max) {
				refri++;
				max = chemical[i][1];
			}
		}
		bw.write(""+refri);
		br.close();
		bw.close();
	}
		
}
