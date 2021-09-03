package bowling.step2.domain;

import java.util.List;

public interface Frame {
    void pitch(int count);

    Frame nextFrame();

    boolean finished();

    boolean isAbleToPitch();

    List<Integer> current();
}