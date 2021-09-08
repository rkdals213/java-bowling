package bowling.step2.domain.state;

import bowling.step2.outputview.pitchresult.PitchPrinter;

public class Spare implements PitchStatus {

    private final int count;

    public Spare(int count) {
        this.count = count;
    }

    public int count() {
        return this.count;
    }

    @Override
    public String result(PitchPrinter printer) {
        return printer.print(this);
    }

}
