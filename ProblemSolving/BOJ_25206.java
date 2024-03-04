import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_25206 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		double totalCredit = 0, totalScore = 0;
		for (int t = 0; t < 20; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			double credit = Double.parseDouble(st.nextToken());
			double grade = getGrade(st.nextToken());
			
			if (grade == -1) {
				continue;
			}
			
			totalScore += (credit * grade);
			totalCredit += credit;
		}
		
		bw.write(String.valueOf(totalScore / totalCredit));
		br.close();
		bw.close();
	}

	private static double getGrade(String grade) {
		if (grade.equals("A+")) {
			return 4.5;
		} else if (grade.equals("A0")) {
			return 4.0;
		} else if (grade.equals("B+")) {
			return 3.5;
		} else if (grade.equals("B0")) {
			return 3.0;
		} else if (grade.equals("C+")) {
			return 2.5;
		} else if (grade.equals("C0")) {
			return 2.0;
		} else if (grade.equals("D+")) {
			return 1.5;
		} else if (grade.equals("D0")) {
			return 1.0;
		} else if (grade.equals("F")) {
			return 0.0;
		}
		return -1;
	}
}
