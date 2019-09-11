/**
 * Exceptions information class
 */
public class DukeExceptions extends Exception {
    public DukeExceptions () {}

    /**
     * Exception message printing for empty command type
     * @param type
     */
    public void EmptyDescription(String type) {
        System.out.println("   \u2639 OOPS!!! The description of a " + type + " cannot be empty.\n");
    }

    /**
     * Exception message printing for invalid command format
     */
    public void InvalidInput() {
        System.out.println("   \u2639 OOPS!!! I'm sorry, but I don't know what that means :-(\n");
    }
}
