import java.util.Scanner;


public class Duke {
    private static Task[] dukeList = new Task[100];
    private static int tasknumber = 0;

    public static void main(String[] args) {
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

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();

            if (in.equals("bye")) {
                System.out.println("__________________________________________________\n"
                + "   Bye. Hope to see you again soon!\n"
                + "__________________________________________________\n");
                break;
            }
            if (in.equals("list")) {
                System.out.println("__________________________________________________\n");
                for (int i = 1; dukeList[i-1] != null; i++) {
                    System.out.println(i + "." + dukeList[i-1].isString() + "\n");
                }
                System.out.println("__________________________________________________\n");
            }

            // other commands like "read book" to be added in the list
            else {
                System.out.println("__________________________________________________\n");
                System.out.println("   added: " + in + "\n");
                System.out.println("__________________________________________________\n");
                dukeList[tasknumber].description = in;
            }
        }
    }
}
