package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.elements;

public class GraduallyDecreasingCarouselRun extends CarouselRun {
    @Override
    public int next() {
        if (isFinished()) return -1;
        if (position == elements.length) {
            position = 0;
            decrement++;
        }
        if (elements[position] <= 0) {
            position++;
            return next();
        }
        int result = elements[position];
        elements[position] = elements[position++] - decrement;
        return result;
    }
}
