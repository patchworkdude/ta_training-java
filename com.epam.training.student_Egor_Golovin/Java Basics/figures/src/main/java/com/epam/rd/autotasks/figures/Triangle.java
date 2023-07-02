package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    Point A, B, C;
    double Ax, Ay, Bx, By, Cx, Cy;

    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;

        Ax = A.getX();
        Ay = A.getY();
        Bx = B.getX();
        By = B.getY();
        Cx = C.getX();
        Cy = C.getY();
    }

    @Override
    public double area() {
        return (Math.abs((Bx - Ax) * (Cy - Ay) - (Cx - Ax) * (By - Ay)))/2;
    }

    @Override
    public String pointsToString() {
        return String.format("(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)", Ax, Ay, Bx, By, Cx, Cy);
    }

    @Override
    public Point leftmostPoint() {
        int position = 0;
        double max = Integer.MAX_VALUE;
        Point[] points = new Point[]{A, B, C};
        for (int i = 0; i < points.length; i++) {
            if (points[i].getX() < max) {
                position = i;
                max = points[i].getX();
            }
        }
        return new Point(points[position].getX(), points[position].getY());
    }
}
