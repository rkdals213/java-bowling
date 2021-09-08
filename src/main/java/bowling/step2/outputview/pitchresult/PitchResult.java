package bowling.step2.outputview.pitchresult;

import bowling.step2.domain.state.PitchStatus;

public class PitchResult {
    private final PitchStatus pitchStatus;

    private final int count;

    public PitchResult(PitchStatus pitchStatus, int count) {
        this.pitchStatus = pitchStatus;
        this.count = count;
    }

    public static PitchResult of(PitchStatus pitchStatus, int count) {
        return new PitchResult(pitchStatus, count);
    }

    public String result() {
        return pitchStatus.result(count);
    }
}
