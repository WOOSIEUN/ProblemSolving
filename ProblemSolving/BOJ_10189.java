import java.io.*;

public class BOJ_10189 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
		sb.append("#  # #### #### #  #\n");
		sb.append("#### #  # #  # # #\n");
		sb.append("#### #  # #  # # #\n");
 		sb.append("#  # #### #### #  #\n");
        
        bw.write(sb.toString());
        bw.close();
    }
}