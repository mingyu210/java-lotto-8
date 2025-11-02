package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottos(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(Map<Rank, Integer> results) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", results.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", results.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.getOrDefault(Rank.FIRST, 0));
    }
}
