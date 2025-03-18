package comparing;

import formatting.ColumnInfo;
import formatting.TableFormatter;

import java.text.DecimalFormat;

public class CountryTableFormatter extends TableFormatter<Country> {

    private static final int nameLength = 15;
    private static final int populationLength = 15;
    private static final int areaLength = 15;
    private static final int gdpLength = 15;

    private static final DecimalFormat areaFormat = new DecimalFormat("#,### Km²");
    private static final DecimalFormat populationFormat = new DecimalFormat("#,###");
    private static final DecimalFormat gdpFormat = new DecimalFormat("#,### M$");

    public static final ColumnInfo<Country> nameColumnInfo =
            new ColumnInfo<>("nombre", nameLength, null, Country::getName);

    public static final ColumnInfo<Country> populationColumnInfo =
            new ColumnInfo<>("poblacion", populationLength, populationFormat, Country::getPopulation);

    public static final ColumnInfo<Country> areaColumnInfo =
            new ColumnInfo<>("area", areaLength, areaFormat, Country::getArea);

    public static final ColumnInfo<Country> gdpColumnInfo =
            new ColumnInfo<>("gdp", gdpLength, gdpFormat, Country::getGdp);


    public static final CountryTableFormatter DEFAULT = new CountryTableFormatter();


    public CountryTableFormatter() {
        super(nameColumnInfo, populationColumnInfo, areaColumnInfo, gdpColumnInfo);
    }

    @SafeVarargs
    public CountryTableFormatter(ColumnInfo<Country>... columns) {
        super(columns);
    }
}


class Demo {
    public static void main(String[] args) {
        CountryTableFormatter countryTableFormatter = new CountryTableFormatter();
        System.out.println(countryTableFormatter.getTable(Countries.COUNTRIES));

        CountryTableFormatter countryTableFormatter2 = new CountryTableFormatter(CountryTableFormatter.nameColumnInfo, CountryTableFormatter.populationColumnInfo);
        System.out.println(countryTableFormatter2.getTable(Countries.COUNTRIES));
    }
}
