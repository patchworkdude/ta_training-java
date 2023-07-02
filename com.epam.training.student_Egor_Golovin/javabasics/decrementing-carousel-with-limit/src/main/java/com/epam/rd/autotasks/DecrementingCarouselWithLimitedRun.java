package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    static int actionLimit = Integer.MAX_VALUE;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }

    @Override
    public CarouselRun run() {
        if (run) {
            return null;
        }
        run = true;
        return new CarouselRun();
    }
}
