package comparing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class ComparingCountriesTest {

    /**
     * Metodo auxiliar para imprimir un listado en forma de tabla de los países por consola
     */
    void printCountries(Country[] countries) {
        System.out.println(CountryTableFormatter.DEFAULT.getTable(countries));
    }

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

        printCountries(countries);
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
        Country[] countries = Countries.provideCountries();

        Arrays.sort(countries, comparator);

        printCountries(countries);
    }


    @Test
    void testSortByGDP() {

        Comparator<Country> comparator = new Country.ByGDPComparator();
        Country[] countries = Countries.provideCountries();

        Arrays.sort(countries, comparator.reversed());

        printCountries(countries);
    }

    @Test
    void testSortByArea() {
        Comparator<Country> comparator = new Country.ByAreaComparator();
        Country[] countries = Countries.provideCountries();

        Arrays.sort(countries, comparator);

        printCountries(countries);
    }

    @Test
    void testPrintCountries() {
        Country[] countries = Countries.provideCountries();
        printCountries(countries);
    }


}
