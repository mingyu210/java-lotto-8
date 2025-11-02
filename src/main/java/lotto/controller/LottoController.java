package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run(){
        int purchaseAmount = InputView.inputPurchaseAmount();
        lottoService.buyLottos(purchaseAmount);

        OutputView.printLottos(lottoService.getLottos());

        String WinningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        lottoService.setWinningNumbers(WinningNumbers, bonusNumber);
        OutputView.printStatistics(lottoService.calculateResults(purchaseAmount));
    }
}
