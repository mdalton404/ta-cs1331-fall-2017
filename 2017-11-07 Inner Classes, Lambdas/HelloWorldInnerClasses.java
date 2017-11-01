/**
 * Demonstration of the use of inner classes
 * @author mdalton31
 */
public class HelloWorldInnerClasses {
    interface HelloWorld {
        public void greet();
        public void greetSomeoneElse(String someone);
    }

    public void sayHello() {
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeoneElse(name);
            }
            public void greetSomeoneElse(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }
        HelloWorld e = new EnglishGreeting();
        e.greet();
    }
    
    public static void main(String[] args) {
        HelloWorldInnerClasses h = new HelloWorldInnerClasses();
        h.sayHello();
    }
}
    /*
        Notes:
            - Inner classes are most useful when you create a class only to be used in one other class
            - Inner classes can be private or public, just like regular classes
            - Inner and outer classes have access to each others private members

        Inner classes are very useful in helping outer classes handle things without
        having to flush out a class in another file. However, sometimes even providing
        the class with a name is unnecessary. Is it really that important that we gave the
        EnglishGreeting a class name? Is there a way where we can not worry about
        doing that? (Yes, see HelloWorldAnonymousClasses.java)
     */