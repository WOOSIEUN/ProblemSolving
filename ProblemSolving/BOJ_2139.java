import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            if (day == 0 && month == 0 && year == 0) {
                break;
            }

            LocalDate date1 = LocalDate.of(year, 1, 1);
            LocalDate date2 = LocalDate.of(year, month, day);

            sb.append(ChronoUnit.DAYS.between(date1, date2) + 1).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
