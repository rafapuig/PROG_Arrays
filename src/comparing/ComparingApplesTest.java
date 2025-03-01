package comparing;

import java.util.Arrays;

public class ComparingApplesTest {

    public static void main(String[] args) {
        //compareTwoApples();
        compareAppleArray();
    }


    static void compareTwoApples() {
        Apple apple1 = new Apple(Apple.Color.GREEN, 1.5f);
        Apple apple2 = new Apple(Apple.Color.RED, 2.5f);
        Apple apple3 = new Apple(Apple.Color.YELLOW, 1.5f);

        int result;

        result = apple1.compareTo(apple2); // -1
        ComparisonUtils.printComparisonResults(apple1, apple2, result);

        // Si las comparo al revés...
        result = apple2.compareTo(apple1); // 1
        ComparisonUtils.printComparisonResults(apple2, apple1, result);

        result = apple1.compareTo(apple3);
        ComparisonUtils.printComparisonResults(apple1, apple3, result);

        result = apple3.compareTo(apple1);
        ComparisonUtils.printComparisonResults(apple3, apple1, result);
    }


    static void compareAppleArray() {
        Apple[] apples = new Apple[5];
        apples[0] = new Apple(Apple.Color.RED, 0.5f);
        apples[1] = new Apple(Apple.Color.GREEN, 0.25f);
        apples[2] = new Apple(Apple.Color.YELLOW, 0.35f);
        apples[3] = new Apple(Apple.Color.YELLOW, 0.10f);
        apples[4] = new Apple(Apple.Color.RED, 0.05f);

        System.out.println(Arrays.toString(apples));

        Arrays.sort(apples);

        System.out.println(Arrays.toString(apples));
    }

}
