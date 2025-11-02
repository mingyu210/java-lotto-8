package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run(){
        int purchaseAmount = InputView.inputPurchaseAmount();
        lottoService.buyLottos(purchaseAmount);

        String WinningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        lottoService.setWinningNumbers(WinningNumbers, bonusNumber);
    }
}
