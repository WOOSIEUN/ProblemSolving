import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2754 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String grade = br.readLine();
		StringBuilder sb = new StringBuilder();
		if (grade.equals("A+")) {
			sb.append("4.3");
		} else if (grade.equals("A0")) {
			sb.append("4.0");
		} else if (grade.equals("A-")) {
			sb.append("3.7");
		} else if (grade.equals("B+")) {
			sb.append("3.3");
		} else if (grade.equals("B0")) {
			sb.append("3.0");
		} else if (grade.equals("B-")) {
			sb.append("2.7");
		} else if (grade.equals("C+")) {
			sb.append("2.3");
		} else if (grade.equals("C0")) {
			sb.append("2.0");
		} else if (grade.equals("C-")) {
			sb.append("1.7");
		} else if (grade.equals("D+")) {
			sb.append("1.3");
		} else if (grade.equals("D0")) {
			sb.append("1.0");
		} else if (grade.equals("D-")) {
			sb.append("0.7");
		} else {
			sb.append("0.0");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
