import java.io.*;
import java.util.StringTokenizer;

import static javax.swing.text.html.HTML.Attribute.N;

public class BOJ_20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int money = Integer.parseInt(br.readLine());
        int moneyJunhyun = money, moneySungmin = money;
        int stockJunhyun = 0, stockSungmin = 0;

        final int DAY = 14;
        int[] stockPrices = new int[DAY];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < DAY; i++) {
            stockPrices[i] = Integer.parseInt(st.nextToken());

            int amount = moneyJunhyun / stockPrices[i];
            moneyJunhyun -= (amount * stockPrices[i]);
            stockJunhyun += amount;

            if (i < 3) {
                continue;
            }

            if (stockPrices[i - 3] < stockPrices[i - 2] && stockPrices[i - 2] < stockPrices[i - 1] && stockPrices[i - 1] < stockPrices[i]) {
                moneySungmin += (stockSungmin * stockPrices[i]);
                stockSungmin = 0;
            } else if (stockPrices[i - 3] > stockPrices[i - 2] && stockPrices[i - 2] > stockPrices[i - 1] && stockPrices[i - 1] > stockPrices[i]) {
                amount = moneySungmin / stockPrices[i];
                moneySungmin -= (amount * stockPrices[i]);
                stockSungmin += amount;
            }
        }

        int resultJunhyun = moneyJunhyun + (stockJunhyun * stockPrices[DAY - 1]);
        int resultSungmin = moneySungmin + (stockSungmin * stockPrices[DAY - 1]);

        bw.write(resultJunhyun > resultSungmin ? "BNP" : (resultJunhyun < resultSungmin ? "TIMING" : "SAMESAME"));
        br.close();
        bw.close();
    }
}
