package comparing;

import java.util.Comparator;
import java.util.StringJoiner;

public class Country implements Comparable<Country> {

    private final String name;
    private final int population;
    private final float area; // En kilómetros cuadrados
    private final float gdp; // En miles de millones de dolares

    public Country(String name, int population, float area, float gdp) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.gdp = gdp;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public float getArea() {
        return area;
    }

    public float getGdp() {
        return gdp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "{", "}")
                .add("name='" + name + "'")
                .add("population=" + population)
                .add("area=" + area)
                .add("gdp=" + gdp)
                .toString();
    }

    /**
     * Ordenación natural, los países se ordenan según su nombre
     */
    @Override
    public int compareTo(Country other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    /**
     * Comparador por población
     */
    public static class ByPopulationComparator implements Comparator<Country> {

        @Override
        public int compare(Country country1, Country country2) {
            return Integer.compare(country1.population, country2.population);
        }
    }

    /**
     * Comparador de países por superficie
     */
    public static class ByAreaComparator implements Comparator<Country> {

        @Override
        public int compare(Country country1, Country country2) {
            return Float.compare(country1.area, country2.area);
        }
    }

    /**
     * Comparador de países por GDP (Producto Interior Bruto)
     */
    public static class ByGDPComparator implements Comparator<Country> {

        @Override
        public int compare(Country country1, Country country2) {
            return Float.compare(country1.gdp, country2.gdp);
        }
    }


}
