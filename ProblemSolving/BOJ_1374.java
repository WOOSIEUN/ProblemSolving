import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374 {
	static class Lecture implements Comparable<Lecture> {
		int idx, start, end;

		public Lecture(int idx, int start, int end) {
			this.idx = idx;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ArrayList<Lecture> times = new ArrayList<>();
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
            times.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
		
        Collections.sort(times);

        int max = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++){
            while (!pq.isEmpty() && pq.peek() <= times.get(i).start){
                pq.poll();
            }
            
            pq.offer(times.get(i).end);
            max = Math.max(max, pq.size());
        }
        
		bw.write(String.valueOf(max));
		br.close();
		bw.close();
	}
}
