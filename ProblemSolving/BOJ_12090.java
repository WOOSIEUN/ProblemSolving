import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12090 {

    static final char[] CHO = {
            'ㄱ','ㄲ','ㄴ','ㄷ','ㄸ','ㄹ','ㅁ','ㅂ','ㅃ',
            'ㅅ','ㅆ','ㅇ','ㅈ','ㅉ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        bw.write(extractChosung(line));
        br.close();
        bw.close();
    }

    private static String extractChosung(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            int unicode = c - 0xAC00;
            int cho = unicode / (21 * 28);
            sb.append(CHO[cho]);
        }
        return sb.toString();
    }
}
