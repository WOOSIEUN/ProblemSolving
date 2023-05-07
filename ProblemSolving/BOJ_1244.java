import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;		
		
		int numOfSwitches = Integer.parseInt(br.readLine()) + 1;
		st = new StringTokenizer(br.readLine());
		int[] switches = new int [numOfSwitches];
		for (int i = 1; i < numOfSwitches; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		int numOfStudents = Integer.parseInt(br.readLine());
		int[][] students = new int [numOfStudents][2];
		for (int i = 0; i < numOfStudents; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int[] student : students) {
			if (student[0] == 1) {
				for (int i = student[1]; i < numOfSwitches; i += student[1]) {
					switches[i] = changeSwitch(switches[i]);
				}
			} else {
				switches[student[1]] = changeSwitch(switches[student[1]]);
				for (int left = student[1] - 1, right = student[1] + 1; left > 0 && right < numOfSwitches; left--, right++) {
					if (switches[left] == switches[right]) {
						switches[left] = changeSwitch(switches[left]);
						switches[right] = changeSwitch(switches[right]);
					} else {
						break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < numOfSwitches; i++) {
			sb.append(switches[i]);
			if (i != 0 && i % 20 == 0) {
				sb.append("\n");
			} else {
				sb.append(" ");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static int changeSwitch(int target) {
		if (target == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
