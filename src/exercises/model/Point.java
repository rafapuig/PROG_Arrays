package exercises.model;

import java.util.StringJoiner;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "(", ")")
                .add("x:" + x)
                .add("y:" + y)
                .toString();
    }
}

class PointTest {

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        System.out.println(p1);

        Point p2 = new Point(1, 2);
        System.out.println(p2);

        boolean areEquals = p1.equals(p2);
        System.out.println(p1 + " es igual a " + p2 + " ? " + areEquals);

        Point p3 = new Point(1, 3);
        System.out.println(p3);

        areEquals = p1.equals(p3);
    }

}
