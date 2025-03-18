package comparing;

public class Empleado extends Person {

    private final int salary;

    public Empleado(String name, String lastName, int age, int salary) {
        super(name, lastName, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "{" + getName() + " " + getLastName() + " (" + getAge() + ") : " + salary + "€}";
    }
}
