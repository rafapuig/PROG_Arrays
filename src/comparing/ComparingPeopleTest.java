package comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ComparingPeopleTest {

    static Person vanesa = new Person("Vanesa", "Tanica", 18);
    static Person marta = new Person("Marta", "Baco", 45);
    static Person pedro = new Person("Pedro", "Gado", 32);
    static Person sandra = new Person("Sandra", "Matica", 27);
    static Person amador = new Person("Amador", "Denador", 20);

    static Person[] people = new Person[]{vanesa, marta, pedro, sandra, amador};

    public static void main(String[] args) {
        comparingPeopleNaturalOrder();
        //comparingPeopleNaturalOrder2();
        //comparingPeopleArray();
        //comparingPeopleByNameAndLastName();
    }

    static void comparingPeopleNaturalOrder() {
        // Comparar por el orden natural dos objetos se hace mediante la interface Comparable
        // La clase Person debe haber implementado la interface Comparable<Person>

        // Comparamos a Vanesa (18) con Amador (20)
        int comparisonResult = vanesa.compareTo(amador); // Vanesa es menor que Amador --> resultado negativo

        System.out.println(comparisonResult); // resultado negativo

        // El metodo sign devuelve < si el argumento es negativo, = si es cero y > si es positivo
        char sign = ComparisonUtils.sign(comparisonResult);

        // Hacemos un "pretty print" del resultado
        System.out.println(vanesa + " " + sign + " " + amador);
    }


    static void comparingPeopleNaturalOrder2() {
        ComparisonUtils.printComparisonResults(vanesa, amador);
        ComparisonUtils.printComparisonResults(amador, vanesa);
    }






    private static void comparingPeopleByNameAndLastName() {
        Comparator<Person> byNameThenLastName = Person.byName.thenComparing(Person.byLastName);
        Arrays.sort(people, byNameThenLastName);
        System.out.println(Arrays.toString(people));
    }

    private static void comparingPeopleArray() {
        int result = vanesa.compareTo(marta);
        ComparisonUtils.printComparisonResults(vanesa, marta, result);
        ComparisonUtils.printComparisonResults(amador, pedro);

        Arrays.sort(people); // Ordenación  natural, usa la interface Comparable

        System.out.println(Arrays.toString(people));

        Arrays.sort(people, Person.byName);  // Ordenación mediante comparador (patrón estrategia)
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, Person.byAge.reversed().thenComparing(Person.byName)); // Ordenación mediante comparador (patrón estrategia)
        System.out.println(Arrays.toString(people));

        Comparator<Person> byAge2 = Comparator.comparing(Person::getAge);
        Arrays.sort(people, byAge2);

        Arrays.sort(people, Comparator.comparing(Person::getName));
        Arrays.sort(people, Comparator.comparing(person -> person.getLastName()));

    }


    static void anonymousTypeComparatorByName() {

        // Crear un comparador mediante un tipo anónimo
        Comparator<Person> byName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Arrays.sort(people, byName);
        System.out.println(Arrays.toString(people));
    }


    static void lambdaComparatorByName() {
        //Crear un comparador mediante una expresión lambda (T, T) -> int para el SAM  int compare(T, T);
        Comparator<Person> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());

        Arrays.sort(people, byName);
        System.out.println(Arrays.toString(people));
    }


    static void factoryMethodComparatorAndAnonymousTypeKeyExtractorByName() {

        Function<Person, String> getPersonName = new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        };

        String amadorName = getPersonName.apply(amador);

        Comparator<Person> byName = Comparator.comparing(getPersonName);

        Arrays.sort(people, byName);
        System.out.println(Arrays.toString(people));
    }


    static void factoryMethodComparatorAndLambdaKeyExtractorByName() {

        Function<Person, String> getPersonName = person -> person.getName();

        String amadorName = getPersonName.apply(amador);

        Comparator<Person> byName = Comparator.comparing(getPersonName);

        Arrays.sort(people, byName);
        System.out.println(Arrays.toString(people));
    }


    static void factoryMethodComparatorAndMethodReferenceKeyExtractorByName() {

        Function<Person, String> getPersonName = Person::getName;

        String amadorName = getPersonName.apply(amador);

        Comparator<Person> byName = Comparator.comparing(getPersonName);

        Arrays.sort(people, byName);
        System.out.println(Arrays.toString(people));
    }


    static void anonymousTypeComparatorByAge() {

        // Crear un comparador mediante un tipo anónimo
        Comparator<Person> byAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };

        Arrays.sort(people, byAge);
        System.out.println(Arrays.toString(people));
    }


    static void lambdaComparatorByAge() {
        //Crear un comparador mediante una expresión lambda (T, T) -> int para el SAM  int compare(T, T);
        Comparator<Person> byAge = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());

        Arrays.sort(people, byAge);
        System.out.println(Arrays.toString(people));
    }


    //Crear el comparador mediante el metodo factoría estática comparingInt que recibe un ToIntFunction<? super T>
    static void factoryMethodComparatorAndAnonymousTypeKeyExtractorByAge() {

        ToIntFunction<Person> getAge = new ToIntFunction<Person>() {
            @Override
            public int applyAsInt(Person value) {
                return value.getAge();
            }
        };

        int amadorAge = getAge.applyAsInt(amador);

        Comparator<Person> byAge = Comparator.comparingInt(getAge);

        Arrays.sort(people, byAge);
        System.out.println(Arrays.toString(people));
    }


    //Crear el comparador mediante el metodo factoría estática comparingInt que recibe un ToIntFunction<? super T>
    static void factoryMethodComparatorAndLambdaKeyExtractorByAge() {

        ToIntFunction<Person> getAge = value -> value.getAge();

        int amadorAge = getAge.applyAsInt(amador);

        Comparator<Person> byAge = Comparator.comparingInt(getAge);

        Arrays.sort(people, byAge);
        System.out.println(Arrays.toString(people));
    }


    //Crear el comparador mediante el metodo factoría estática comparingInt que recibe un ToIntFunction<? super T>
    static void factoryMethodComparatorAndMethodReferenceKeyExtractorByAge() {

        ToIntFunction<Person> getAge = Person::getAge;

        int amadorAge = getAge.applyAsInt(amador);

        Comparator<Person> byAge = Comparator.comparingInt(getAge);

        Arrays.sort(people, byAge);
        System.out.println(Arrays.toString(people));
    }

}
