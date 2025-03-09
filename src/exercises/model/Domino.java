package exercises.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Domino {

    private final int top;
    private final int bottom;

    public Domino(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    boolean contains(int number) {
        return number == top || number == bottom;
    }

    Domino flip() {
        return flip(this);
    }

    public static Domino flip(Domino domino) {
        return new Domino(domino.bottom, domino.top);
    }


    private static String toDots(int number) {
        return switch (number) {
            case 1 -> " ∙ ";
            case 2 -> " ̇ .";
            case 3 -> "˙∙.";
            case 4 -> ": :";
            case 5 -> ":∙:";
            case 6 -> ":::";
            case 0 -> "   ";
            default -> " " + number + " ";
        };
    }

    private static String sideToString(int number) {
        //return sideValue != 0 ? String.valueOf(sideValue) : " ";
        return toDots(number);
    }

    @Override
    public final boolean equals(Object other) {
        if (!(other instanceof Domino domino)) return false;
        if(hashCode() != domino.hashCode()) return false;
        return this.top == domino.top && this.bottom == domino.bottom
                || this.top == domino.bottom && this.bottom == domino.top;
    }

    @Override
    public int hashCode() {
        int result = top;
        result = 31 * result + bottom;
        return result;
    }

    private static final char SURROGATE_PAIR_HIGH = '\uD83C';
    private static final char SURROGATE_PAIR_LOW_HORIZONTAL = '\uDC31';
    private static final char SURROGATE_PAIR_LOW_VERTICAL = '\uDC63';

    String toChar(boolean vertical) {
        char surrogatePairLowBase = vertical ? SURROGATE_PAIR_LOW_VERTICAL : SURROGATE_PAIR_LOW_HORIZONTAL;
        int offset = bottom + top * 7;
        char surrogatePairLow = (char) (surrogatePairLowBase + offset);
        return String.format("%s%s", SURROGATE_PAIR_HIGH, surrogatePairLow);
    }


    @Override
    public String toString() {
        return "[" + sideToString(top) + "|" + sideToString(bottom) + "]";
    }
}

class DominoesTest {

    public static void main(String[] args) {

        testFlip();
        testEquals();

        List<Domino> dominoList = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                dominoList.add(new Domino(i, j));
            }
        }

        /*for(Dominoes dominoe : dominoes) {
            System.out.println(dominoe.toChar(true));
        }*/

        StringJoiner sj = new StringJoiner("");
        for (Domino domino : dominoList) {
            sj.add(domino.toChar(true));
        }
        System.out.println(sj);
    }

    private static void testEquals() {
        Domino domino1 = new Domino(3, 5);
        Domino domino2 = new Domino(5, 3);
        Domino domino3 = new Domino(3, 4);

        boolean areEquals = domino1.equals(domino2);
        System.out.println(domino1 + " es igual a " + domino2 + "? " + areEquals);
        areEquals = domino1.equals(domino3);
        System.out.println(domino1 + " es igual a " + domino3 + "? " + areEquals);
    }

    private static void testFlip() {
        Domino domino = new Domino(3, 5);
        System.out.println(domino);
        domino = domino.flip();
        System.out.println(domino);
    }

}
