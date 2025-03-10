package exercises.model;

import java.util.*;

public class Domino implements Comparable<Domino> {

    private static final int NUM_ENDS = 2;
    private static final int MIN_DOTS = 0;
    private static final int MAX_DOTS = 6;
    private final int[] ends = new int[NUM_ENDS];

    public static boolean isValidNumberOfDots(int dots) {
        return dots >= MIN_DOTS && dots <= MAX_DOTS;
    }

    private static void checkNumberOfDots(int dots) {
        if (!isValidNumberOfDots(dots)) {
            throw new IllegalArgumentException("Número de puntos invalido, entre 0 y 6");
        }
    }

    public Domino(int firstEndDots, int secondEndDots) {
        checkNumberOfDots(firstEndDots);
        checkNumberOfDots(secondEndDots);
        this.ends[0] = firstEndDots;
        this.ends[1] = secondEndDots;
    }

    public int weight() {
        int sum = 0;
        for (int i = 0; i < ends.length; i++) {
            sum += ends[i];
        }
        return sum;
    }

    public boolean isDouble() {
        return ends[0] == ends[1];
    }

    public boolean isSingle() {
        return !isDouble();
    }

    public int getFirstEndDots() {
        return ends[0];
    }

    public int getSecondEndDots() {
        return ends[1];
    }

    boolean contains(int dots) {
        for (int i = 0; i < ends.length; i++) {
            if (dots == ends[i]) return true;
        }
        return false;
    }

    Domino flip() {
        return flip(this);
    }

    public static Domino flip(Domino domino) {
        return new Domino(domino.ends[1], domino.ends[0]);
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

    private static String endToString(int points) {
        //return sideValue != 0 ? String.valueOf(sideValue) : " ";
        return toDots(points);
    }

    @Override
    public final boolean equals(Object other) {
        if (!(other instanceof Domino domino)) return false;
        if (hashCode() != domino.hashCode()) return false;

        if (Arrays.equals(ends, domino.ends)) return true;
        return Arrays.equals(ends, domino.flip().ends);
    }

    @Override
    public int hashCode() {
        //return Arrays.hashCode(endDots);
        int result = 13;
        for (int i = 0; i < ends.length; i++) {
            result = 31 * result + ends[i];
        }
        return result;
    }

    private static final char SURROGATE_PAIR_HIGH = '\uD83C';
    private static final char SURROGATE_PAIR_LOW_HORIZONTAL = '\uDC31';
    private static final char SURROGATE_PAIR_LOW_VERTICAL = '\uDC63';

    String toChar(boolean vertical) {
        char surrogatePairLowBase = vertical ? SURROGATE_PAIR_LOW_VERTICAL : SURROGATE_PAIR_LOW_HORIZONTAL;
        int offset = ends[1] + ends[0] * 7;
        char surrogatePairLow = (char) (surrogatePairLowBase + offset);
        return String.format("%s%s", SURROGATE_PAIR_HIGH, surrogatePairLow);
    }


    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("|", "[", "]");
        for (int i = 0; i < ends.length; i++) {
            sj.add(endToString(ends[i]));
        }
        return sj.toString();

        //return "[" + sideToString(endDots[0]) + "|" + sideToString(endDots[1]) + "]";
    }

    @Override
    public int compareTo(Domino other) {
        if (other == null) return 1;
        if (other == this) return 0;
        for (int i = 0; i < ends.length; i++) {
            int diff = Integer.compare(ends[i], other.ends[i]);
            if (diff != 0) return diff;
        }
        return 0;
        /*if(endDots[0] < other.endDots[0]) return -1;
        if(endDots[0] > other.endDots[0]) return 1;
        return Integer.compare(endDots[1], other.endDots[1]);*/
    }
}

class DominoesTest {

    public static void main(String[] args) {
        testException();
        testWeight();
        testFlip();
        testEquals();

        List<Domino> dominoList = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominoList.add(new Domino(i, j));
            }
        }

        /*for(Dominoes dominoe : dominoes) {
            System.out.println(dominoe.toChar(true));
        }*/

        printDominoTiles(dominoList);

        Collections.shuffle(dominoList);
        printDominoTiles(dominoList);
        Collections.sort(dominoList);
        printDominoTiles(dominoList);
    }

    private static void printDominoTiles(Collection<Domino> dominoList) {
        StringJoiner sj = new StringJoiner("");
        for (Domino domino : dominoList) {
            sj.add(domino.toChar(true));
        }
        System.out.println(sj);
    }

    private static void testException() {
        try {
            new Domino(1, 7);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void testWeight() {
        Domino domino = new Domino(5, 6);
        System.out.println(domino.weight());
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
