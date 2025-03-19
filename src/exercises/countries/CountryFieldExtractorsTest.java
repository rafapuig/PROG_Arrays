package exercises.countries;

import formatting.FieldValueExtractor;
import org.junit.jupiter.api.Test;

public class CountryFieldExtractorsTest {

    @Test
    public void test() {

        // Un field extractor creado mediante un tipo anónimo
        FieldValueExtractor<Country, Integer> populationExtractor =
                new FieldValueExtractor<Country, Integer>() {
                    @Override
                    public Integer extract(Country country) {
                        return country.getPopulation();
                    }
                };

        printExtractedField(populationExtractor);
    }


    public void printExtractedField(FieldValueExtractor<Country, ?> fieldValueExtractor) {

        Country[] countries = Countries.provideCountries();

        for (int i = 0; i < countries.length; i++) {
            Object countryFieldValue = fieldValueExtractor.extract(countries[i]);
            System.out.println(countryFieldValue);
        }
    }

}
