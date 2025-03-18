package comparing;

import formatting.ColumnInfo;
import formatting.TableFormatter;

import java.text.DecimalFormat;
import java.util.StringJoiner;
import java.util.function.Function;

/**
 * Clase de utilidad que encapsula datos de países de ejemplo
 */
public class Countries {

    public static Country SPAIN = new Country("España", 46_505_963, 504_782, 1_356_000f);
    public static Country VENEZUELA = new Country("Venezuela", 27_223_228, 912_050, 367_500f);
    public static Country USA = new Country("EE.UU.", 310_232_863, 9_629_091, 16_720_000f);
    public static Country UK = new Country("Reino Unido", 62_348_447, 244_820, 2_490_000f);
    public static Country MEXICO = new Country("Mexico", 112_468_855, 1_972_550, 1_327_000f);
    public static Country CHINA = new Country("China", 1_330_044_000, 9_596_960, 9_330_000f);

    public static Country[] COUNTRIES = {SPAIN, VENEZUELA, USA, UK, MEXICO, CHINA};

    /**
     * Devuelve una copia del array de países
     */
    public static Country[] provideCountries() {
        Country[] countries = new Country[COUNTRIES.length];
        System.arraycopy(COUNTRIES, 0, countries, 0, COUNTRIES.length);
        return countries;
    }


    /**
     * Devuelve una representación del array de países
     *
     * @param countries array de países
     * @param converter conversor de un objeto Country a String
     */
    public static String toCountriesString(Country[] countries, Function<Country, String> converter, String delimiter, String prefix, String suffix) {
        StringJoiner joiner = new StringJoiner(delimiter, prefix, suffix);
        for (int i = 0; i < countries.length; i++) {
            joiner.add(converter.apply(countries[i]));
        }
        return joiner.toString();
    }

    public static String toCountriesString(Country[] countries, Function<Country, String> converter) {
        return toCountriesString(countries, converter, ", ", "[", "]");
    }

    private static final int nameLength = 15;
    private static final int populationLength = 15;
    private static final int areaLength = 15;
    private static final int gdpLength = 15;

    private static final DecimalFormat areaFormat = new DecimalFormat("#,### Km²");
    private static final DecimalFormat populationFormat = new DecimalFormat("#,###");
    private static final DecimalFormat gdpFormat = new DecimalFormat("#,### M$");


/*
    private static String toCountryRow(Country country) {
        String nameColumn = String.format("%-" + nameLength + "s", country.getName());
        String populationColumn = String.format("%" + populationLength + "s", populationFormat.format(country.getPopulation()));
        String areaColumn = String.format("%" + areaLength + "s", areaFormat.format(country.getArea()));
        String gdpColumn = String.format("%" + gdpLength + "s", gdpFormat.format(country.getGdp()));

        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(nameColumn);
        joiner.add(populationColumn);
        joiner.add(areaColumn);
        joiner.add(gdpColumn);
        return joiner.toString();
    }

    public static String toCountriesTableString(Country[] countries) {
        String nameColumnHeader = centerAligned("NOMBRE", nameLength);
        String populationColumnHeader = centerAligned("POBLACION", populationLength);
        String areaColumnHeader = centerAligned("AREA", areaLength);
        String gdpColumnHeader = centerAligned("GDP", gdpLength);

        StringBuilder builder = new StringBuilder();
        builder.append(nameColumnHeader);
        builder.append(populationColumnHeader);
        builder.append(areaColumnHeader);
        builder.append(gdpColumnHeader);
        String header = builder.toString();

        String line = "-".repeat(header.length());

        String prefix = header + "\n" + line + "\n";

        StringJoiner joiner = new StringJoiner("\n", prefix, "");

        for (Country country : countries) {
            joiner.add(toCountryRow(country));
        }
        return joiner.toString();
    }


    public static String centerAligned(String text, int width) {
        int printedLength = text.length();
        int padding = width - printedLength;
        int paddingLeft = padding / 2;

        return String.format("%-" + width + "s",
                String.format("%" + (paddingLeft + text.length()) + "s",
                        text));
    }

    */

    public static String toCountriesTableString(Country[] countries) {

        ColumnInfo<Country> nameColumnInfo =
                new ColumnInfo<>("nombre", nameLength, null, Country::getName);

        ColumnInfo<Country> populationColumnInfo =
                new ColumnInfo<>("poblacion", populationLength, populationFormat, Country::getPopulation);

        ColumnInfo<Country> areaColumnInfo =
                new ColumnInfo<>("area", areaLength, areaFormat, Country::getArea);

        ColumnInfo<Country> gdpColumnInfo =
                new ColumnInfo<>("gdp", gdpLength, gdpFormat, Country::getGdp);

        TableFormatter<Country> tablePrinter =
                new TableFormatter<>(nameColumnInfo, populationColumnInfo, areaColumnInfo, gdpColumnInfo);

        return tablePrinter.getTable(countries);
    }

}
