package lotto.view;

import lotto.domain.item.LottoTickets;

public class MatchedLottoDto {

    private LottoTickets tickets;

    public LottoTickets getTickets() {
        return tickets;
    }

    public void setTickets(LottoTickets tickets) {
        this.tickets = tickets;
    }
}