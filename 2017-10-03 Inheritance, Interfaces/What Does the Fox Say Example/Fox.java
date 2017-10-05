/**
 * Class representation of a fox
 * Fox is-an Animal
 * @author Isabella Plonk
 * @version 1.0
 */
public class Fox extends Animal implements Dances {

    private String noise;
    private boolean isGuardianAngel;

    /**
     * Creates a fox
     * @param noise WHAT DOES THE FOX SAY?!
     * @param isGuardianAngel whether or not the fox is your guardian angel
     */
    public Fox(String noise, boolean isGuardianAngel) {
        super(4, "orange");
        this.noise = noise;
        this.isGuardianAngel = isGuardianAngel;
    }

    public void makeNoise() {
        System.out.println(noise);
    }

    /**
     * Communicates to a friendly horse in morse code
     */
    public void speakToFriendlyHorse() {
        System.out.println(".-- .... .- - .----. ... / ..- .--.");
    }

    /**
     * Example of method overloading
     * Communicates to a friendly horse in morse code
     * if it knows morse code. Otherwise, communicates in English.
     * @param horse the horse to which the fox is communicating
     */
    public void speakToFriendlyHorse(Horse horse) {
        if (horse.getKnowsMorse()) {
            speakToFriendlyHorse();
        } else {
            System.out.println("What's up?");
        }
    }

    /**
     * @return whether or not the fox is your guardian angel
     */
    public boolean getIsGuardianAngel() {
        return isGuardianAngel;
    }

    /**
     * @param isGuardianAngel whether or not the fox is your guardian angel
     */
    public void setIsGuardianAngel(boolean isGuardianAngel) {
        this.isGuardianAngel = isGuardianAngel;
    }

    public void dance() {
        System.out.println("I'm dancing.");
    }
}