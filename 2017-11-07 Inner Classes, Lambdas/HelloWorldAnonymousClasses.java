/**
 * Anonymous implementation of HelloWorldInnerClasses
 * @author mdalton31
 */
public class HelloWorldAnonymousClasses {
    interface HelloWorld {
        public void greet();
        public void greetSomeoneElse(String someone);
    }

    public void sayHello() {
        HelloWorld e = new HelloWorld() {
            String name = "world";
            public void greet() {
                greetSomeoneElse(name);
            }
            public void greetSomeoneElse(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        };
        e.greet();
    }
    
    public static void main(String[] args) {
        HelloWorldAnonymousClasses h = new HelloWorldAnonymousClasses();
        h.sayHello();
    }
}
    /*
        There are situations where naming the inner class is just a waste of space or time 
        or just unnecessary. We call inner classes we don't provide a name to Anonymous Classes.

        Notes:
            - anonymous classes are always constructed without arguments
    */