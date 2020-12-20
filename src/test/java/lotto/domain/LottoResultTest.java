package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(8, 21, 23, 41, 42, 43));
        lottoList.add(new Lotto(3, 5, 11, 16, 32, 38));
        lottoList.add(new Lotto(7, 11, 16, 35, 36, 44));
        lottoList.add(new Lotto(1, 8, 11, 31, 41, 42));
        lottoList.add(new Lotto(13, 14, 16, 38, 42, 45));
        lottoList.add(new Lotto(7, 11, 30, 40, 42, 43));
        lottoList.add(new Lotto(2, 13, 22, 32, 38, 45));
        lottoList.add(new Lotto(23, 25, 33, 36, 39, 41));
        lottoList.add(new Lotto(1, 3, 5, 14, 22, 45));
        lottoList.add(new Lotto(5, 9, 38, 41, 43, 44));
        lottoList.add(new Lotto(2, 8, 9, 18, 19, 21));
        lottoList.add(new Lotto(13, 14, 18, 21, 23, 35));
        lottoList.add(new Lotto(17, 21, 29, 37, 42, 45));
        lottoList.add(new Lotto(3, 8, 27, 30, 35, 44));

        Lotto winnerLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);

        int buyAmount = 14000;

        lottoResult = new LottoResult(lottoList, winnerLotto, bonusNumber, buyAmount);
    }

    @Test
    @DisplayName("당첨 갯수별 로또 수 테스트")
    void getSameLottoCount() {
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(0);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(0);
        assertThat(lottoResult.getRankCount(Rank.THIRD)).isEqualTo(0);
        assertThat(lottoResult.getRankCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.getRankCount(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void getRevenueRate() {
        assertThat(lottoResult.getRewardRate()).isCloseTo(0.35, offset(0.1d));
    }
}