package exercises.searching;

import exercises.model.Domino;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchingDemo {

    public static void main(String[] args) {

        Domino[] dominoes = {
                new Domino(1, 5), // 0
                new Domino(2, 5), // 1
                new Domino(3, 4), // 2
                new Domino(4, 4), // 3
                new Domino(0, 6), // 4
                new Domino(6, 6), // 5
        };

        printDominoesVerticalFunctional(dominoes);
        printDominoesHorizontalFunctional(dominoes);

        testFind(dominoes);
    }

    private static void testFind(Domino[] dominoes) {
        Domino domino = new Domino(0, 6);
        System.out.println("Buscando domino: " + domino + " en: " + Arrays.toString(dominoes));
        int result = indexOfFunctional(dominoes, domino);
        if (result == -1) {
            System.out.println("Domino no encontrado");
        } else {
            System.out.println("Domino encontrado en indice: " + result);
        }
    }

    static void printDominoesVertical(Domino[] dominoes) {
        for (int i = 0; i < dominoes.length; i++) {
            System.out.println(dominoes[i]);
        }
    }

    static void printDominoesHorizontal(Domino[] dominoes) {
        StringJoiner joiner = new StringJoiner(", ");

        for (int i = 0; i < dominoes.length; i++) {
            joiner.add(dominoes[i].toString());
        }
        System.out.println(joiner);
    }


    static void printDominoesVerticalFunctional(Domino[] dominoes) {
        Arrays.stream(dominoes).forEach(System.out::println);
    }

    static void printDominoesHorizontalFunctional(Domino[] dominoes) {
        String text = Arrays.stream(dominoes)
                .map(Domino::toString)
                .collect(Collectors.joining(", "));
        System.out.println(text);
    }


    static int indexOf(Domino[] dominoes, Domino domino) {
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i].equals(domino)) {
                return i;
            }
        }
        return -1;
    }

    static int indexOfFunctional(Domino[] dominoes, Domino domino) {
        return IntStream.range(0, dominoes.length)
                .filter(i -> dominoes[i].equals(domino))
                .findFirst()
                .orElse(-1);
    }
}
