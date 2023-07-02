package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    Point A, B, C, D;
    double Ax, Ay, Bx, By, Cx, Cy, Dx, Dy;

    public Quadrilateral(Point A, Point B, Point C, Point D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;

        Ax = A.getX();
        Ay = A.getY();
        Bx = B.getX();
        By = B.getY();
        Cx = C.getX();
        Cy = C.getY();
        Dx = D.getX();
        Dy = D.getY();
    }

    @Override
    public double area() {
        double ABC = (Math.abs((Bx - Ax) * (Cy - Ay) - (Cx - Ax) * (By - Ay)))/2.0;
        double ACD = (Math.abs((Cx - Ax) * (Dy - Ay) - (Dx - Ax) * (Cy - Ay)))/2.0;
        return ABC + ACD;
    }

    @Override
    public String pointsToString() {
        return String.format("(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)", Ax, Ay, Bx, By, Cx, Cy, Dx, Dy);
    }

    @Override
    public Point leftmostPoint() {
        int position = 0;
        double max = Integer.MAX_VALUE;
        Point[] points = new Point[]{A, B, C, D};
        for (int i = 0; i < points.length; i++) {
            if (points[i].getX() < max) {
                position = i;
                max = points[i].getX();
            }
        }
        return new Point(points[position].getX(), points[position].getY());
    }
}
