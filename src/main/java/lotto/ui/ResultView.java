package lotto.ui;

import lotto.LottoCollection;
import lotto.domain.LottoResult;

import java.util.Set;

public class ResultView {
    public static void printLottoNumberList(LottoCollection lottoCollection) {
        int lottoCount = lottoCollection.getLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> lottoNumbers = lottoCollection.getLottoNumbers(i);
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public static void printStatistics(LottoResult result, int buyAmount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", result.getSameLottoCount(3));
        System.out.printf("4개 일치 (50000원)- %d개\n", result.getSameLottoCount(4));
        System.out.printf("5개 일치 (1500000원)- %d개\n", result.getSameLottoCount(5));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", result.getSameLottoCount(6));
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", result.getRevenueRate(buyAmount));
    }
}
