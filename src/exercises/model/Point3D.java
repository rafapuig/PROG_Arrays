package exercises.model;

import java.util.StringJoiner;

public class Point3D {

    float[] coords;

    public Point3D(float coord1, float coord2, float coord3) {
        this.coords = new float[]{coord1, coord2, coord3};
    }

    public float getX() {
        return coords[0];
    }

    public float getY() {
        return coords[1];
    }

    public float getZ() {
        return coords[2];
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "(", ")");
        for (int i = 0; i < coords.length; i++) {
            sj.add(Float.toString(coords[i]));
        }
        return sj.toString();
    }

    double distance(Point3D point) {
        double squaresSum = 0;
        for (int i = 0; i < coords.length; i++) {
            double diff = coords[i] - point.coords[i];
            squaresSum += diff * diff;
        }
        return Math.sqrt(squaresSum);
    }
}

class Point3DTest {

    public static void main(String[] args) {
        Point3D p1 = new Point3D(1.1f, 2.2f, 3.3f);
        System.out.println(p1);

        Point3D p2 = new Point3D(1.0f, 2.0f, 4.0f);
        System.out.println(p2);

        double distance = p1.distance(p2);
        System.out.println(distance);

        Point3D p3 = new Point3D(1.1f, 2.2f, 4.3f);
        double distance2 = p3.distance(p1);
        System.out.println(distance2);
    }

}
