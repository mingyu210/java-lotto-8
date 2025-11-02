package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

}
