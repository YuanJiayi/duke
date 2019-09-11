import Tasks.ListOfTask;
import Tasks.Task;

/**
 * The class to generate the user interface
 */
public class UI {

    /**
     * The method to print out the start information
     */
    public static void Start() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String greet = "   Hello! I'm Duke\n"
                + "   What can I do for you?\n";

        System.out.println("Hello from\n" + logo
                + "__________________________________________________\n"
                + greet
                + "__________________________________________________\n");
    }

    /**
     * The method to print closing message
     */
    public static void UiBye() {
        System.out.println("__________________________________________________\n"
                + "   Bye. Hope to see you again soon!\n"
                + "__________________________________________________\n");
    }

    /**
     * The method to print out the current messages in the list
     * @param tasks
     * @param count
     */
    public static void UiList(ListOfTask tasks, int count) {
        System.out.println("__________________________________________________\n");
        for (int No = 1; No <= count; No++) {
            System.out.println("   " + No + ". " + tasks.get(No - 1).toString());
        }
        System.out.println("__________________________________________________\n");
    }

    /**
     * The method to print out the command asking for setting a task done has been done
     * @param task
     */
    public static void UiDone(Task task) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Nice! I've marked this task as done:\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("__________________________________________________\n");
    }

    /**
     * The method to print out the success message for deleting a task in the list
     * @param task
     * @param count
     */
    public static void UiDelete(Task task, int count) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Noted. I've removed this task:\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("   Now you have " + (count - 1) + " tasks in the list.\n");
        System.out.println("__________________________________________________\n");
    }

    /**
     * The method to show a new Todo task has been added
     * @param task
     * @param count
     */
    public static void UiTodo(Task task, int count) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Got it. I've added this task:" + "\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("   Now you have " + (count + 1) + " tasks in the list.\n");
        System.out.println("__________________________________________________\n");
    }

    /**
     * The method to show a new Event task has been added
     * @param task
     * @param count
     */
    public static void UiEvent(Task task, int count) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Got it. I've added this task:" + "\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("   Now you have " + (count + 1) + " tasks in the list.\n");
        System.out.println("__________________________________________________\n");
    }

    /**
     * The method to show a new Deadline task has been added
     * @param task
     * @param count
     */
    public static void UiDeadline(Task task, int count) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Got it. I've added this task:" + "\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("   Now you have " + (count + 1) + " tasks in the list.\n");
        System.out.println("__________________________________________________\n");
    }
}
