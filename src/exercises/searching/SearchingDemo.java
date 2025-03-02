package exercises.searching;

import exercises.model.Dominoes;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class SearchingDemo {

    public static void main(String[] args) {

        Dominoes[] dominoes = {
                new Dominoes(1,5), // 0
                new Dominoes(2,5), // 1
                new Dominoes(3,4), // 2
                new Dominoes(4,4), // 3
                new Dominoes(0,6), // 4
                new Dominoes(6,6), // 5
        };

        printDominoesVerticalFunctional(dominoes);
        printDominoesHorizontalFunctional(dominoes);
        int result = indexOf(dominoes, new Dominoes(0,6));
        System.out.println(result);
    }

    static void printDominoesVertical(Dominoes[] dominoes) {
        for (int i = 0; i < dominoes.length; i++) {
            System.out.println(dominoes[i]);
        }
    }

    static void printDominoesHorizontal(Dominoes[] dominoes) {
        StringJoiner joiner = new StringJoiner(", ");

        for (int i = 0; i < dominoes.length; i++) {
            joiner.add(dominoes[i].toString());
        }
        System.out.println(joiner);
    }




    static void printDominoesVerticalFunctional(Dominoes[] dominoes) {
        Arrays.stream(dominoes).forEach(System.out::println);
    }

    static void printDominoesHorizontalFunctional(Dominoes[] dominoes) {
        String text = Arrays.stream(dominoes)
                .map(Dominoes::toString)
                .collect(Collectors.joining(", "));
        System.out.println(text);
    }



    static int indexOf(Dominoes[] dominoes, Dominoes domino) {
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i].equals(domino)) {
                return i;
            }
        }
        return -1;
    }
}
