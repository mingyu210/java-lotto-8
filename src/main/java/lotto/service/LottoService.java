package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    private final List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNubmbers;
    private int bonusNumber;

    public void buyLottos(int amount){
        int count = amount/1000;

        for(int i = 0; i < count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottos.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinningNumbers(String input, int bonus){
        winningNubmbers = Arrays.stream(input.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        bonusNumber = bonus;
    }

    public Map<Rank, Integer> calculateResults(int amount) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNubmbers::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        printProfitRate(results, amount);
        return results;
    }

    private void printProfitRate(Map<Rank, Integer> results, int amount) {
        double totalPrize = results.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrize() * e.getValue())
                .sum();
        double rate = (totalPrize / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }

}
