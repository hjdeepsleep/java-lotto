package lotto.view;

import lotto.domain.item.LottoTickets;

public class MatchedLottoDto {
    private LottoTickets tickets;
    private int firstGameCount = 0;
    private int secondGameCount = 0;
    private int thirdGameCount = 0;
    private int fourthGameCount = 0;
    private int fifthGameCount = 0;
    private double earningRate = 0;

    public LottoTickets getTickets() {
        return tickets;
    }

    public int getFirstGameCount() {
        return firstGameCount;
    }

    public int getSecondGameCount() {
        return secondGameCount;
    }

    public int getThirdGameCount() {
        return thirdGameCount;
    }

    public int getFourthGameCount() {
        return fourthGameCount;
    }

    public int getFifthGameCount() {
        return fifthGameCount;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public void setTickets(LottoTickets tickets) {
        this.tickets = tickets;
    }

    public void setFirstGameCount(int firstGameCount) {
        this.firstGameCount = firstGameCount;
    }

    public void setSecondGameCount(int secondGameCount) {
        this.secondGameCount = secondGameCount;
    }

    public void setThirdGameCount(int thirdGameCount) {
        this.thirdGameCount = thirdGameCount;
    }

    public void setFourthGameCount(int fourthGameCount) {
        this.fourthGameCount = fourthGameCount;
    }

    public void setFifthGameCount(int fifthGameCount) {
        this.fifthGameCount = fifthGameCount;
    }

    public void setEarningRate(double earningRate) {
        this.earningRate = earningRate;
    }
}