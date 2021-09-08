package bowling.step2.domain.state;

import bowling.step2.outputview.pitchresult.PitchPrinter;

public interface PitchStatus {
    int count();

    String result(PitchPrinter printer);
}
