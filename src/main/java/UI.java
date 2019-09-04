import java.util.ArrayList;

public class UI {

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

    public static void UiBye() {
        System.out.println("__________________________________________________\n"
                + "   Bye. Hope to see you again soon!\n"
                + "__________________________________________________\n");
    }

    public static void UiList(ListOfTask tasks, int count) {
        System.out.println("__________________________________________________\n");
        for (int No = 1; No <= count; No++) {
            System.out.println("   " + No + ". " + tasks.get(No - 1).toString());
        }
        System.out.println("__________________________________________________\n");
    }

    public static void UiDone(Task task) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Nice! I've marked this task as done:\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("__________________________________________________\n");
    }

    public static void UiDelete(Task task, int count) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Noted. I've removed this task:\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("   Now you have " + (count - 1) + " tasks in the list.\n");
        System.out.println("__________________________________________________\n");
    }

    public static void UiTodo(Task task, int count) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Got it. I've added this task:" + "\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("   Now you have " + (count + 1) + " tasks in the list.\n");
        System.out.println("__________________________________________________\n");
    }

    public static void UiEvent(Task task, int count) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Got it. I've added this task:" + "\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("   Now you have " + (count + 1) + " tasks in the list.\n");
        System.out.println("__________________________________________________\n");
    }

    public static void UiDeadline(Task task, int count) {
        System.out.println("__________________________________________________\n");
        System.out.println("   Got it. I've added this task:" + "\n");
        System.out.println("   " + task.toString() + "\n");
        System.out.println("   Now you have " + (count + 1) + " tasks in the list.\n");
        System.out.println("__________________________________________________\n");
    }
}
