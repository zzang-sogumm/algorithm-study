package isu.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20546 {
    private final static String BUY_AND_PAY = "BNP";
    private final static String SAME = "SAMESAME";
    private final static String TIMING = "TIMING";

    public static void main(String[] args) throws IOException {
        new BOJ20546().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cash = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] stockPrices = new int[14];
        int index = 0;

        while (tokenizer.hasMoreElements()) {
            stockPrices[index] = Integer.parseInt(tokenizer.nextToken());
            index++;
        }

        int jProfit = computeJProfit(cash, stockPrices);
        int sProfit = computeSProfit(cash, stockPrices);

        printResult(jProfit, sProfit);
    }

    // BNP 방식의 수익 계산
    private int computeJProfit(int cash, int[] stockPrices) {
        int stockNum = 0;

        for (int stockPrice : stockPrices) {
            // 매수한 주식 개수
            int boughtStock = cash / stockPrice;

            cash -= (boughtStock * stockPrice);
            stockNum += boughtStock;

            if (cash <= 0) {
                break;
            }
        }

        return computeFinalAssets(cash, stockPrices[stockPrices.length - 1], stockNum);
    }

    // TIMING 방식의 수익 계산
    private int computeSProfit(int cash, int[] stockPrices) {
        int stockNum = 0;
        int risingDays = 0;
        int fallingDays = 0;

        for (int index = 1; index < stockPrices.length; index++) {
            // 전날과 비교해서 가격이 올랐는지 확인
            int todayStockPrice = stockPrices[index];
            int comparing = todayStockPrice - stockPrices[index - 1];

            if (comparing > 0) { // 상승
                risingDays++;
                fallingDays = 0;
            } else if (comparing < 0) { // 하락
                fallingDays++;
                risingDays = 0;
            } else {
                risingDays = 0;
                fallingDays = 0;
            }

            // 3일 연속 하락인 경우 전량 매수
            if (fallingDays >= 3) {
                int boughtStock = cash / todayStockPrice;

                cash -= (boughtStock * todayStockPrice);
                stockNum += boughtStock;
            }

            // 3일 연속 상승인 경우 전량 매도
            if (risingDays >= 3) {
                cash += (stockNum * todayStockPrice);
                stockNum = 0;
            }
        }

        return computeFinalAssets(cash, stockPrices[stockPrices.length - 1], stockNum);
    }


    // 최종 자산 계산
    private int computeFinalAssets(int cash, int stockPriceOfLastDay, int totalStockNum) {
        return cash + (stockPriceOfLastDay * totalStockNum);
    }

    // 최종 결과 출력
    private void printResult(int jProfit, int sProfit) {
        String result;

        if (jProfit > sProfit) {
            result = BUY_AND_PAY;
        } else if (jProfit < sProfit) {
            result = TIMING;
        } else {
            result = SAME;
        }

        System.out.println(result);
    }
}
