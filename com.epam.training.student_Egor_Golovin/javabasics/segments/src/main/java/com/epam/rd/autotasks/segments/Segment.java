package com.epam.rd.autotasks.segments;

import static java.lang.Math.*;

class Segment {

    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }
        if (start.equals(end))
            throw new IllegalArgumentException("The points must differ");
        this.start = start;
        this.end = end;
    }

    double length() {
        return sqrt(pow(end.getX() - start.getX(), 2) + pow(end.getY() - start.getY(), 2));
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {

        double k1 = (end.getY() - start.getY()) / (end.getX() - start.getX());
        double k2 = (another.end.getY() - another.start.getY()) / (another.end.getX() - another.start.getX());
        double b1 = end.getY() - k1 * end.getX();
        double b2 = another.end.getY() - k2 * another.end.getX();

        if (k1 == k2) {
            return null;
        }

        double x = (b2 - b1) / (k1 - k2);
        double y = k1 * x + b1;

        if (min(start.getX(), end.getX()) <= x && x <= max(start.getX(), end.getX()) &&
                min(another.start.getX(), another.end.getX()) <= x && x <= max(another.start.getX(), another.end.getX())) {
            return new Point(x, y);
        } else return null;
    }
}
