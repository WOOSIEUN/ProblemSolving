import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9576 {
	static class Student implements Comparable<Student> {
		int a, b;
		
		public Student(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Student student) {
			if (this.b == student.b) {
				return this.a - student.a;
			}
			return this.b - student.b;
		}		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean[] books = new boolean [N + 1];
			Student[] students = new Student [M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
		
			Arrays.sort(students);
			
			int numOfBooks = 0;
			for (Student student : students) {
				for (int i = student.a; i <= student.b; i++) {
					if (!books[i]) {
						books[i] = true;
						numOfBooks++;
						break;
					}						
				}
			}
			
			sb.append(numOfBooks).append("\n");			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
