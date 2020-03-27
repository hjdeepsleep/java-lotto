package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 티켓 정상 생성")
    @Test
    public void constructor() throws Exception {
        //given
        LottoTicket ticket1 = new LottoTicket(numbers);
        LottoTicket ticket2 = new LottoTicket(numbers);

        assertThat(ticket1.equals(ticket2)).isTrue();
    }

    /**
     * lottosize(), lottosize2() 테스트 코드를 합칠순 없을지...
     */
    @DisplayName("로또 티켓은 번호 6개만 지정 가능")
    @Test
    public void lottosize() throws Exception {
        assertThatThrownBy(
                () -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5))
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("번호는 6개만 지정 가능 합니다.");
    }

    @DisplayName("로또 티켓은 번호 6개만 지정 가능")
    @Test
    public void lottosize2() throws Exception {
        assertThatThrownBy(
                () -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("번호는 6개만 지정 가능 합니다.");
    }

    @DisplayName("한번 생성된 로또 번호는 변경 불가능해야 한다.")
    @Test
    public void modify() throws Exception {
        //given
        LottoTicket ticket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        List<Integer> numbers = ticket.getNumbers();

        //then
        assertThatThrownBy(
                () -> numbers.set(0, 11)
        ).isInstanceOf(UnsupportedOperationException.class);
    }
}
