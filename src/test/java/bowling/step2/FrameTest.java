package bowling.step2;

import bowling.step2.domain.Frame;
import bowling.step2.domain.LastFrame;
import bowling.step2.domain.NormalFrame;
import bowling.step2.domain.TryNo;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FrameTest {

    @ParameterizedTest
    @CsvSource(value = {"10:10", "6:6"}, delimiter = ':')
    public void 투구_성공(int count, int expected) {
        //given
        NormalFrame normalFrame = NormalFrame.of(1);

        //when
        normalFrame.pitch(TryNo.FIRST, count);

        //then
        assertThat(normalFrame.total()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:10:10", "4:6:10", "1:1:2"}, delimiter = ':')
    public void 투구_성공2(int count1, int count2, int expected) {
        //given
        NormalFrame normalFrame = NormalFrame.of(1);

        //when
        normalFrame.pitch(TryNo.FIRST, count1);
        normalFrame.pitch(TryNo.SECOND, count2);

        //then
        assertThat(normalFrame.total()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:11", "11:6", "10:1"}, delimiter = ':')
    public void 투구_실패(int count1, int count2) {
        //given
        NormalFrame normalFrame = NormalFrame.of(1);

        //when, then
        assertThatThrownBy(() -> {
            normalFrame.pitch(TryNo.FIRST, count1);
            normalFrame.pitch(TryNo.SECOND, count2);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 프레임_생성() {
        //given
        NormalFrame normalFrame = NormalFrame.of(1);

        //when
        Frame nextFrame = normalFrame.nextFrame();

        //then
        assertThat(nextFrame).isInstanceOf(NormalFrame.class);
    }

    @Test
    public void 마지막_프레임_생성() {
        //given
        NormalFrame normalFrame = NormalFrame.of(9);

        //when
        Frame nextFrame = normalFrame.nextFrame();

        //then
        assertThat(nextFrame).isInstanceOf(LastFrame.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:10:20", "6:4:10"}, delimiter = ':')
    public void 마지막_프레임_투구_성공(int count1, int count2, int expected) {
        //given
        LastFrame lastFrame = new LastFrame();

        //when
        lastFrame.pitch(TryNo.FIRST, count1);
        lastFrame.pitch(TryNo.SECOND, count2);

        //then
        assertThat(lastFrame.total()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:10:10:30", "6:4:10:20"}, delimiter = ':')
    public void 마지막_프레임_추가투구_성공(int count1, int count2, int count3, int expected) {
        //given
        LastFrame lastFrame = new LastFrame();

        //when
        lastFrame.pitch(TryNo.FIRST, count1);
        lastFrame.pitch(TryNo.SECOND, count2);
        lastFrame.pitch(TryNo.ADDITIONAL, count3);

        //then
        assertThat(lastFrame.total()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"11:10", "6:6"}, delimiter = ':')
    public void 마지막_프레임_투구_실패(int count1, int count2) {
        //given
        LastFrame lastFrame = new LastFrame();

        //when, then
        assertThatThrownBy(() -> {
            lastFrame.pitch(TryNo.FIRST, count1);
            lastFrame.pitch(TryNo.SECOND, count2);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:10", "6:3:10"}, delimiter = ':')
    public void 마지막_프레임_추가투구_실패(int count1, int count2, int count3) {
        //given
        LastFrame lastFrame = new LastFrame();

        //when, then
        assertThatThrownBy(() -> {
            lastFrame.pitch(TryNo.FIRST, count1);
            lastFrame.pitch(TryNo.SECOND, count2);
            lastFrame.pitch(TryNo.ADDITIONAL, count3);
        }).isInstanceOf(RuntimeException.class);
    }
}
