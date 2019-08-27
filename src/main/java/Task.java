public class Task {
    protected boolean isDone;
    protected String description;

    public Task (String details) {
        this.description = details;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[✓]" : "[✗]");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String isString() {
        return getStatusIcon() + " " + description;
    }
}
