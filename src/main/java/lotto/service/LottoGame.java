package lotto.service;

import lotto.domain.Money;
import lotto.domain.item.Item;
import lotto.domain.item.LottoTicket;
import lotto.domain.item.LottoTickets;
import lotto.domain.item.WinLottoTicket;
import lotto.domain.stragegy.LottoGenerator;
import lotto.view.LottoDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private static final double LOTTO_PRICE = 1000;

    private Money money;
    private int playGameCount;
    private LottoTickets lottoTickets;

    public LottoGame(Money money) {
        this.money = money;
        this.playGameCount = money.getHowManyBuyItem(new Money(LOTTO_PRICE));
    }

    public LottoGame(Money money, LottoTickets lottoTickets) {
        this.money = money;
        this.lottoTickets = lottoTickets;
    }

    private LottoTicket buyOneLottoTicket(List<Integer> numbers) {
        playGameCount--;
        return new LottoTicket(numbers);
    }

    private void buyAllLottoTicket() {
        List<LottoTicket> lottos = new ArrayList<>();
        while (playGameCount > 0) {
            List<Integer> numbers = LottoGenerator.lottoNumberGenerator();
            lottos.add(buyOneLottoTicket(numbers));
        }
        this.lottoTickets = new LottoTickets(Collections.unmodifiableList(lottos));
    }

    public LottoDto play() {
        buyAllLottoTicket();
        LottoDto dto = new LottoDto();

        dto.setTickets(this.lottoTickets.getTickets());

        return dto;
    }

    public LottoDto findWinGame(Item winTicket) {
        LottoDto dto = new LottoDto();
        dto.setFirstGameCount(this.lottoTickets.getFirstLottoCount(winTicket));
        dto.setSecondGameCount(this.lottoTickets.getSecondLottoCount(winTicket));
        dto.setThirdGameCount(this.lottoTickets.getThirdLottoCount(winTicket));
        dto.setFourthGameCount(this.lottoTickets.getFourthLottoCount(winTicket));
        dto.setFifthGameCount(this.lottoTickets.getFifthLottoCount(winTicket));
        return dto;
    }

    private Money getAllEarningPrize(WinLottoTicket winTicket) {
        return this.lottoTickets.getAllEarningPrize(winTicket);
    }

    public LottoDto getEarningRate(WinLottoTicket winTicket) {
        LottoDto dto = new LottoDto();
        Money prize = getAllEarningPrize(winTicket);
        int howManyBuyItem = money.getHowManyBuyItem(new Money(LOTTO_PRICE));
        Money buyAmount = new Money(LOTTO_PRICE).multiply(howManyBuyItem);

        double rate = Math.floor(prize.divide(buyAmount).getMoney() * 100) / 100;

        dto.setEarningRate(rate);
        return dto;
    }
}
