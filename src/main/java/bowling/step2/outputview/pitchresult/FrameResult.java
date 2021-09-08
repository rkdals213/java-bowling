package bowling.step2.outputview.pitchresult;

import bowling.step2.domain.Frame;
import bowling.step2.domain.result.PitchResultGroup;

public class FrameResult {
    private final PitchResultGroup pitchResultGroup;

    private FrameResult(Frame frame) {
        this.pitchResultGroup = frame.createResult();
    }

    public static FrameResult of(Frame frame) {
        return new FrameResult(frame);
    }

    public String getPitchResults() {
        return pitchResultGroup.getPitchResults();
    }
}
