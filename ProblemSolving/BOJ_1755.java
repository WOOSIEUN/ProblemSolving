import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1755 {
	static class Number implements Comparable<Number> {
		int num;
		String str;
        public Number(int num, String str) {
			this.num = num;
			this.str = str;
		}
		@Override
		public int compareTo(Number o) {
			return this.str.compareTo(o.str);
		}
	}
	static int M, N;
	static String[] numString = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	static ArrayList<Number> numbers = new ArrayList<Number>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
        for (int i = M; i < N + 1; i++) {
            String numToStr = String.valueOf(i);
            StringBuilder numEachStr = new StringBuilder();
            for (int j = 0; j < numToStr.length(); j++)
                numEachStr.append(numString[numToStr.charAt(j) - '0'] + " ");
            numbers.add(new Number(i, numEachStr.toString()));
		}
        Collections.sort(numbers);
        for (int i = 0; i < N - M + 1; i++) {
            if(i != 0 && i % 10 == 0) sb.append("\n");
            sb.append(numbers.get(i).num + " ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
