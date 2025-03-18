package comparing;

import java.util.StringJoiner;

public class Apple implements Comparable<Apple>  {


    public enum Color {GREEN, RED, YELLOW}

    private final Color color;
    private final float weight;

    public Apple(Color color, float weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "{", "}")
                .add("color=" + color)
                .add("weight=" + weight)
                .toString();
    }

    @Override
    public int compareTo(Apple other) {
        if (this.weight > other.weight) return 1;
        if (this.weight < other.weight) return -1;
        return 0;
    }
}
