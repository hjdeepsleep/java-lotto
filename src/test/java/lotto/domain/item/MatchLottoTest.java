package lotto.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchLottoTest {
    private List<Item> items;
    LottoTicket ticket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoTicket ticket2 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 10));

    private static Stream<Arguments> provideItems() {
        return Stream.of(
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 10))),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 10, 11))),
                Arguments.of(new LottoTicket(Arrays.asList(1, 10, 11, 12, 13, 14, 15))),
                Arguments.of(new LottoTicket(Arrays.asList(10, 11, 12, 13, 14, 15, 16)))
        );
    }

    @DisplayName("생성자 테스트")
    @Test
    public void construct() throws Exception {
        //given
        MatchLotto matchLotto = new MatchLotto(1, ticket1);

        //then
        assertThat(matchLotto.getItemsCount()).isEqualTo(1);
    }

    @DisplayName("매칭 리스트에 아이템 더해주고 list의 크기 비교")
    @Test
    public void addItem() throws Exception {
        //given
        MatchLotto matchLotto = new MatchLotto(1, ticket1);

        System.out.println(matchLotto);
        //when
        matchLotto = matchLotto.addItem(ticket2);
        System.out.println(matchLotto);

        //then
        assertThat(matchLotto.getItemsCount()).isEqualTo(2);
    }

    @DisplayName("매칭된 번호의 개수가 동일한지 체크")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "3:3", "4:4"}, delimiter = ':')
    public void isMatchCountSame(int matchCount, int compare) throws Exception {
        //given
        MatchLotto matchLotto = new MatchLotto(matchCount);

        //then
        assertThat(matchLotto.isMatchCountSame(compare)).isTrue();
    }

}