import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
/**
 * Example of Comparable and Comparator interfaces, as well as hashCode()
 * Run using java CarTester
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

    /**
     * Having the same hashcode DOES NOT imply equality. Equality DOES imply having the same hashcode
     * i.e. Whenever a.equals(b), then a.hashCode() == b.hashCode()
     * Whenever you implement equals, you MUST also implement hashCode (Object has both ofc)
     */
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + this.make.hashCode();
        hash = 31 * hash + this.year;
        return hash;
    }

    public int compareTo(Car c) {
        if (this.getYear() < c.getYear()) {
            return -1;
        } else if (this.getYear() > c.getYear()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class CarComparator<T extends Car> implements Comparator<T> {
     public int compare(T a, T b) {
          return a.getMake().compareTo(b.getMake());
     }
}


//Executable Tester
class CarTester {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Toyota Corolla", 2002));
        cars.add(new Car("Alfa-Romeo Giulia", 2017));
        cars.add(new Car("Ford Model A", 1941));
        
        CarComparator<Car> carComp = new CarComparator<>();

        //before sort
        System.out.println("Unsorted:");
        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.print("\n");

        Collections.sort(cars); //using natural order from the compareTo() (year)

        System.out.println("After sort by year (natural order)");
        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.print("\n");

        Collections.sort(cars, carComp); //using comparator order (make)

        System.out.println("After sort by make (using Comparator)");
        for (Car c : cars) {
            System.out.println(c);
        }
    }
}