package bowling.step2.outputview.pitchresult;

import bowling.step2.domain.state.Gutter;
import bowling.step2.domain.state.Miss;
import bowling.step2.domain.state.Spare;
import bowling.step2.domain.state.Strike;

public class PitchPrinterImpl implements PitchPrinter {
    public String print(Strike strike) {
        return "X";
    }

    public String print(Spare spare) {
        return "/";
    }

    public String print(Miss miss) {
        return String.valueOf(miss.count());
    }

    public String print(Gutter gutter) {
        return "-";
    }
}
