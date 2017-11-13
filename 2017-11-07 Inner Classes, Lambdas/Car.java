import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Modified Car class from previous recitation, 
 * used to demonstrate anonymous classes and lambdas
 * @author mdalton31
 */
public class Car implements Comparable<Car> {

    private String make;
    private int year;

    public Car(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } if (!(o instanceof Car)) {
            return false;
        }
        Car c = (Car) o;
        return c.getMake().equals(this.make) && c.getYear() == this.year;
    }

    public String toString() {
        return this.year + " " + this.make;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + this.make.hashCode();
        hash = 31 * hash + this.year;
        return hash;
    }

    public int compareTo(Car c) {
        if (this.year < c.getYear()) {
            return -1;
        } else if (this.year > c.getYear()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Toyota Corolla", 2002));
        cars.add(new Car("Alfa-Romeo Giulia", 2017));
        cars.add(new Car("Ford Model A", 1941));

        //before sort
        System.out.println("Unsorted:");
        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.print("\n");

        /*
        These three are equivalent
        ===========================================================
        */

        //(1) using inner class
        Collections.sort(cars, new MakeComparator<Car>());

        class MakeComparator implements Comparator<Car> { //note: class is below where it is instantiated,
            public int compare(Car a, Car b) {            //demonstrating order doesn't matter, just scope
                return a.getMake().compareTo(b.getMake());//for inner classes
            }
        }

        System.out.println("(1) Sort by make: ");
        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.print("\n");

        //(2) using anonymous class
        Collections.sort(cars,  new Comparator<Car>() {
            public int compare(Car a, Car b) {
                return a.getMake().compareTo(b.getMake());
            }
        });



        System.out.println("(2) Sort by make: ");
        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.print("\n");

        //(3) using lambdas
        Collections.sort(cars, (Car a, Car b) -> a.getMake().compareTo(b.getMake()));   //note: If you specify a single expression 
                                                                                        //in a lambda then the Java runtime evaluates 
        System.out.println("(3) Sort by make: ");                                       //the expression and returns its value.
        for (Car c : cars) {                                                            //No return statement required in this case.
            System.out.println(c);
        }
    }
}
/*
    Lambdas are nothing but a syntactic shortcut for anonymous inner classes

    Lambda syntax:
    (Parameter1, Parameter2, ...) -> body of the abstract method

    -> is called the arrow token and it signifies the definition of a method

    A lambda can always be rewritten as an anonymous class. (NOTE: the
    converse is not always true)

    You can use a lambda to easily implement the single abstract method that is present in a functional interface.
    e.g. compare(T a, T b) from Comparator
*/