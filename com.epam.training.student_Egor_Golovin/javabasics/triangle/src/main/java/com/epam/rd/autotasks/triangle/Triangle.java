package com.epam.rd.autotasks.triangle;

class Triangle {
    public double ax;
    public double ay;
    public double bx;
    public double by;
    public double cx;
    public double cy;

    public Triangle(Point a, Point b, Point c) {
        ax = a.getX();
        ay = a.getY();
        bx = b.getX();
        by = b.getY();
        cx = c.getX();
        cy = c.getY();

        if (area() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return ((Math.abs((bx - ax) * (cy - ay) - (cx - ax) * (by - ay)))/2);
    }

    public Point centroid(){
        double x = 1.0/3 * (ax + bx + cx);
        double y = 1.0/3 * (ay + by + cy);
        return new Point(x,y);
    }

}
