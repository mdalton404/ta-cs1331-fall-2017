public abstract class Dog extends Canine {
    private boolean isWaggingTail;

    public Dog(String name, boolean isWaggingTail) {
        super(name);
        this.isWaggingTail = isWaggingTail;
    }
    public boolean getIsWaggingTail() {
        return this.isWaggingTail;
    }
    //not necessary to include because Dog is still Abstract
    //public abstract void speak();
}