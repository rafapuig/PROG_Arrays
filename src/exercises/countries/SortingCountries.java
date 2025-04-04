package exercises.countries;

import sorting.MergeSort;
import sorting.SortStrategy;

public class SortingCountries {

    public static void main(String[] args) {
        Country[] countries = Countries.COUNTRIES;

        SortStrategy sortStrategy = new MergeSort();

        sortStrategy.sort(countries, new Country.ByGDPComparator());

        CountryTableFormatter countryTableFormatter = new CountryTableFormatter();
        System.out.println(countryTableFormatter.getTable(countries));

    }

}
