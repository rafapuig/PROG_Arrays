package comparing;

import java.util.Comparator;
import java.util.StringJoiner;

public class Person implements Comparable<Person> {

    private final String name;
    private final String lastName;
    private final int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "{", "}")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(age, other.age);
    }

    /**
     * Clase anidada para comparar objetos Person por nombre
     */
    private static class ByNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    }

    /**
     * Clase anidada para comparar objetos Person por apellidos
     */
    private static class ByLastNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.lastName.compareToIgnoreCase(o2.name);
        }
    }

    /**
     * Clase anidada para comparar objetos Person por edad
     */
    private static class ByAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.age, o2.age);
        }
    }


    public static final Comparator<Person> byAge = new ByAgeComparator();
    public static final Comparator<Person> byName = new ByNameComparator();
    public static final Comparator<Person> byLastName = new ByLastNameComparator();
}
