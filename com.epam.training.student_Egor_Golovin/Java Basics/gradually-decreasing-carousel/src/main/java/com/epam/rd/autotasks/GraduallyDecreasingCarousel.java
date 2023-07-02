package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run() {
        if (run) {
            return null;
        }
        run = true;
        return new GraduallyDecreasingCarouselRun();
    }
}
