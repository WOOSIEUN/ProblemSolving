import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {
	static class Lecture implements Comparable<Lecture> {
		int start, end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lecture lecture) {
			if (this.start == lecture.start) {
				return this.end - lecture.end;
			}
			return this.start - lecture.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		Lecture[] lectures = new Lecture [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));			
		}
		Arrays.sort(lectures);

		PriorityQueue<Integer> lectureRoom = new PriorityQueue<>();
		lectureRoom.offer(lectures[0].end);
		
		for (int i = 1; i < N; i++) {
            if (lectureRoom.peek() <= lectures[i].start) {
            	lectureRoom.poll();
            }
            lectureRoom.offer(lectures[i].end);
        }
		
		bw.write(String.valueOf(lectureRoom.size()));
		br.close();
		bw.close();
	}
}
