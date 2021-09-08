package bowling.step2.outputview.pitchresult;

import bowling.step2.domain.state.Gutter;
import bowling.step2.domain.state.Miss;
import bowling.step2.domain.state.Spare;
import bowling.step2.domain.state.Strike;

public interface PitchPrinter {
    String print(Strike strike);

    String print(Spare spare);

    String print(Miss miss);

    String print(Gutter gutter);
}
