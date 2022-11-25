import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14786 {

	static int A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		double curX = 0, nextX;

		while(Math.abs(fx(curX)) > 0.000000001) {
			nextX = curX - newtonRaphson(curX);
			curX = nextX;
		}

		bw.write(String.valueOf(curX));
		br.close();
		bw.close();
	}

	public static double fx(double x) {
		return (A*x + B * Math.sin(x) - C);
	}

    public static double newtonRaphson(double x) {
		return (A*x + B * Math.sin(x) - C) / (A + B * Math.cos(x));
    }
}
