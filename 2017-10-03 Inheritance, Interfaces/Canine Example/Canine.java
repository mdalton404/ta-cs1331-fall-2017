/**
 * example of how abstract classes fit into the hierarchy of classes
 */
public abstract class Canine {
    private String name;

    public Canine(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    //abstract methods do not include implementation
    //only a requirement that concrete subclasses must have
    public abstract void speak();
}