import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1092 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> crane = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		
		bw.write(String.valueOf(moveBox(crane, box)));
		br.close();
		bw.close();
	}

	private static int moveBox(ArrayList<Integer> crane, ArrayList<Integer> box) {
		if (crane.get(0) < box.get(0)){
			return -1;
        }
		
		int day = 0;
		while (!box.isEmpty()){
            int boxIdx = 0, craneIdx = 0;
            while (craneIdx < crane.size()){
                if (boxIdx == box.size()) {
                    break;
                }
                
                if (crane.get(craneIdx) >= box.get(boxIdx)){
                    box.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }

            day++;
        }
		
		return day;
	}
}
