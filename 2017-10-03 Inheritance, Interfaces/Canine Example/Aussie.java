public class Aussie extends Dog implements Guard {
    
    private boolean isGuardDog;

    public Aussie(String name, boolean isWaggingTail, boolean isGuardDog) {
        super(name, isWaggingTail);
        this.isGuardDog = isGuardDog;
    }

    public boolean getIsGuardDog() {
        return this.isGuardDog;
    }
    //implementation of speak from abstract class Animal
    public void speak() {
        System.out.println("Roof!");
    }
    //implements guard from interface Guard
    public void guard() {
        System.out.println("Beware of Dog");
    }
}