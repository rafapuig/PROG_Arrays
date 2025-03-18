package comparing;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class ComparingCountriesTest {

    @Test
    public void testCompareNaturalOrder() {

        int comparisonResult = Countries.SPAIN.compareTo(Countries.CHINA);

        System.out.println(comparisonResult);

        char sign = ComparisonUtils.sign(comparisonResult);

        System.out.println(Countries.SPAIN.getName() + " " + sign + " " + Countries.CHINA.getName());
    }

    @Test
    public void testCompareNaturalOrder2() {

        int comparisonResult = Countries.USA.compareTo(Countries.MEXICO);

        System.out.println(comparisonResult);

        char sign = ComparisonUtils.sign(comparisonResult);

        System.out.println(Countries.USA.getName() + " " + sign + " " + Countries.MEXICO.getName());
    }

    @Test
    void testSortNaturalOrder() {
        Country[] countries = new Country[Countries.COUNTRIES.length];

        for (int i = 0; i < Countries.COUNTRIES.length; i++) {
            countries[i] = Countries.COUNTRIES[i];
        }

        Arrays.sort(countries);

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < countries.length; i++) {
            joiner.add(countries[i].getName());
        }
        System.out.println(joiner);
    }


    @Test
    void testSortNaturalOrder2() {
        Country[] countries = Countries.provideCountries();

        Arrays.sort(countries);

        System.out.println(Countries.toCountriesTableString(countries));
    }




    @Test
    void testCompareByPopulation() {

        Comparator<Country> comparator = new Country.ByPopulationComparator();

        int result = comparator.compare(Countries.USA, Countries.CHINA);

        char sign = ComparisonUtils.sign(result);
        System.out.println(result);

        System.out.println(Countries.USA + " " + sign + " " + Countries.CHINA);
    }

    @Test
    void testSortByPopulation() {

        Comparator<Country> comparator = new Country.ByPopulationComparator();

        Country[] countries = new Country[Countries.COUNTRIES.length];

        for (int i = 0; i < Countries.COUNTRIES.length; i++) {
            countries[i] = Countries.COUNTRIES[i];
        }

        Arrays.sort(countries, comparator);

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < countries.length; i++) {
            joiner.add(countries[i].getName() + " (" + countries[i].getPopulation() + ")");
        }
        System.out.println(joiner);

    }


    @Test
    void testSortByGDP() {

        // Given
        Comparator<Country> comparator = new Country.ByGDPComparator();

        Country[] countries = Countries.provideCountries();

        // When
        Arrays.sort(countries, comparator.reversed());

        // Then
        System.out.println(Countries.toCountriesTableString(countries));

    }

    @Test
    void testSortByArea() {
        Comparator<Country> comparator = new Country.ByAreaComparator();
        Country[] countries = Countries.provideCountries();

        Arrays.sort(countries, comparator);

        String header = String.format("%-15s%-15s\n", "NOMBRE", "    AREA");
        String line = "-".repeat(header.length()) + "\n";
        String prefix = header + line;

        DecimalFormat df = new DecimalFormat("#,### Km²");
        System.out.println(
                Countries.toCountriesString(countries, country ->
                                String.format("%-15s", country.getName())
                                        + String.format("%15s", df.format(country.getArea())),
                        "\n", prefix, "\n" + line)
        );

    }

    @Test
    void testPrintCountries() {
        Country[] countries = Countries.provideCountries();
        System.out.println(Countries.toCountriesTableString2(countries));
    }


}
