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
                    System.out.println(i + "." + dukeList[i-1].toString() + "\n");
                }
                System.out.println("__________________________________________________\n");
            }

            else if (in.contains("done")) {
                String temp = in.replaceAll("[^0-9]", "");
                int number = Integer.parseInt(temp);
                dukeList[number - 1].markAsDone();
                System.out.println("__________________________________________________\n");
                System.out.println("Nice! I've marked this task as done:\n");
                System.out.println("[✓]" + dukeList[number - 1].description + "\n");
                System.out.println("__________________________________________________\n");
            }

            // other commands like "read book" to be added in the list
            else {
                String[] keyword = in.split(" ");
                switch (keyword[0]) {
                    case "todo": {
                        Task task = new ToDo (in.replaceFirst("todo ", ""));
                        dukeList[tasknumber++] = task;
                        System.out.println("__________________________________________________\n");
                        System.out.println("   Got it. I've added this task: \n");
                        System.out.println("   " + dukeList[tasknumber-1].toString() + "\n");
                        System.out.println(" Now you have " + tasknumber + " tasks in the list.\n");
                        System.out.println("__________________________________________________\n");
                        break;
                    }
                    case "event": {
                        Task task = new Event (in.replaceFirst("event", ""), in.replaceFirst("/at ", "(at: "));
                        dukeList[tasknumber++] = task;
                        System.out.println("__________________________________________________\n");
                        System.out.println("   Got it. I've added this task: \n");
                        System.out.println("   " + dukeList[tasknumber-1].toString() + "\n");
                        System.out.println(" Now you have " + tasknumber + " tasks in the list.\n");
                        System.out.println("__________________________________________________\n");
                        break;
                    }
                    case "deadline": {
                        Task task = new Deadline(in.replaceFirst("deadline ", ""), in.replaceFirst("/by ", "(by: "));
                        dukeList[tasknumber++] = task;
                        System.out.println("__________________________________________________\n");
                        System.out.println("   Got it. I've added this task: \n");
                        System.out.println("   " + dukeList[tasknumber-1].toString() + "\n");
                        System.out.println(" Now you have " + tasknumber + " tasks in the list.\n");
                        System.out.println("__________________________________________________\n");
                        break;
                    }
                }
            }
        }
    }
}
