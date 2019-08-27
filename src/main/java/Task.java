public class Task {
    protected boolean isDone;
    protected String description;
    protected String type;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[✓]" : "[✗]");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String toString() {
        return getStatusIcon() + " " + description; // final content of list with Icon
    }
}
