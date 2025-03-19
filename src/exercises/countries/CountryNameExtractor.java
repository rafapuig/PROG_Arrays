package exercises.countries;

import formatting.FieldValueExtractor;
import org.junit.jupiter.api.Test;

public class CountryNameExtractor implements FieldValueExtractor<Country, String> {

    @Override
    public String extract(Country value) {
        return value.getName();
    }
}

class CountryNameExtractorTest {

    @Test
    public void test() {
        CountryNameExtractor countryNameExtractor = new CountryNameExtractor();
        Country country = Countries.SPAIN;

        String countryName = countryNameExtractor.extract(country);
        System.out.println(countryName);
    }

    @Test
    public void test2() {
        CountryNameExtractor countryNameExtractor = new CountryNameExtractor();
        Country[] countries = Countries.provideCountries();

        for (int i = 0; i < countries.length; i++) {
            String countryName = countryNameExtractor.extract(countries[i]);
            System.out.println(countryName);
        }

    }

    @Test
    public void testExtractor() {
        CountryNameExtractor countryNameExtractor = new CountryNameExtractor();
        printExtractedField(countryNameExtractor);
    }


    public void printExtractedField(FieldValueExtractor<Country, ?> fieldValueExtractor) {

        Country[] countries = Countries.provideCountries();

        for (int i = 0; i < countries.length; i++) {
            Object countryFieldValue = fieldValueExtractor.extract(countries[i]);
            System.out.println(countryFieldValue);
        }
    }

}
