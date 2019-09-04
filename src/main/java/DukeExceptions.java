public class DukeExceptions extends Exception {
    public DukeExceptions () {}
    public void EmptyDescription(String type) {
        System.out.println("   \u2639 OOPS!!! The description of a " + type + " cannot be empty.\n");
    }
    public void InvalidInput() {
        System.out.println("   \u2639 OOPS!!! I'm sorry, but I don't know what that means :-(\n");
    }
}
