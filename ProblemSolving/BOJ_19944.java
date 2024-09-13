import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_19944 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      bw.write(getStudentType(M, N));
      br.close();
      bw.close();
   }

   private static String getStudentType(int grade, int criteria) {
      if (grade < 3) {
         return "NEWBIE!";
      } else if (grade <= criteria) {
         return "OLDBIE!";
      } else {
         return "TLE!";
      }
   }
}