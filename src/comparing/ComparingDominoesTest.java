package comparing;

import exercises.model.Domino;
import sorting.ArrayUtils;

import java.util.Arrays;

public class ComparingDominoesTest {

    public static void main(String[] args) {
        compareTwoDominoes();
        compareDominoesArray();
    }


    private static void compareTwoDominoes() {
        Domino domino1 = new Domino(3,5);
        Domino domino2 = new Domino(4,5);
        Domino domino3 = new Domino(5,4);

        ComparisonUtils.printComparisonResults(domino1, domino2);
        ComparisonUtils.printComparisonResults(domino1, domino3);
        ComparisonUtils.printComparisonResults(domino2, domino3);
        ComparisonUtils.printComparisonResults(domino2, domino1);
        ComparisonUtils.printComparisonResults(domino3, domino1);
        ComparisonUtils.printComparisonResults(domino3, domino2);
    }

    private static void compareDominoesArray() {
        Domino[] dominoes = new Domino[6*6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dominoes[i*6+j] = new Domino(i,j);
            }
        }

        ArrayUtils.shuffle(dominoes);
        System.out.println(Arrays.toString(dominoes));
        Arrays.sort(dominoes);
        System.out.println(Arrays.toString(dominoes));
    }


}
