package com.epam.rd.autotasks;

public class CarouselRun {
    int[] elements = DecrementingCarousel.elements;
    int position = 0;
    int actionLimit = DecrementingCarouselWithLimitedRun.actionLimit;

    public int next() {
        if (isFinished()) return -1;
        if (position == elements.length) {
            position = 0;
        }
        if (elements[position] == 0) {
            position++;
            return next();
        }
        actionLimit--;
        return elements[position++]--;
    }

    public boolean isFinished() {
        if (actionLimit == 0) {
            return true;
        }
        for (int element: elements ) {
            if (element > 0) return false;
        }
        return true;
    }
}
