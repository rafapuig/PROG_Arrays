package exercises.model;

public class Dominoes {

    private final int top;
    private final int bottom;

    public Dominoes(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    private String sideToString(int sideValue) {
        return sideValue != 0 ? String.valueOf(sideValue) : " ";
    }

    @Override
    public final boolean equals(Object other) {
        if (!(other instanceof Dominoes dominoes)) return false;
        return this.top == dominoes.top && this.bottom == dominoes.bottom;
    }

    @Override
    public int hashCode() {
        int result = top;
        result = 31 * result + bottom;
        return result;
    }

    @Override
    public String toString() {
        return "[" + sideToString(top) + "|" + sideToString(bottom) + "]";
    }
}

class DominoesTest {

    public static void main(String[] args) {
        Dominoes dominoes = new Dominoes(1, 2);
        Dominoes dominoes2 = new Dominoes(0, 0);
        System.out.println(dominoes);
        System.out.println(dominoes2);
        System.out.println('\u2684' + "::");
    }

}
