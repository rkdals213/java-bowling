package bowling.step2.domain.result;

import bowling.step2.domain.state.PitchStatus;
import bowling.step2.outputview.pitchresult.PitchPrinterImpl;

public class PitchResult {
    private final PitchStatus pitchStatus;

    public PitchResult(PitchStatus pitchStatus) {
        this.pitchStatus = pitchStatus;
    }

    public static PitchResult of(PitchStatus pitchStatus) {
        return new PitchResult(pitchStatus);
    }

    public String result() {
        return pitchStatus.result(new PitchPrinterImpl());
    }
}
