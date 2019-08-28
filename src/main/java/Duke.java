import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Duke {
    private static Task[] dukeList = new Task[100];
    private static int taskNumber = 0;

    public static void main(String[] args) throws IOException, DukeExceptions {
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


        UpdateSave updateSave = new UpdateSave();
        dukeList = updateSave.requestData();
        taskNumber = updateSave.requestTasksAmount();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");

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
                    System.out.println("   " + i + "." + dukeList[i-1].toString() + "\n");
                }
                System.out.println("__________________________________________________\n");
            }
            else if (in.contains("done")) {
                String temp = in.replaceAll("[^0-9]", "");
                int number = Integer.parseInt(temp);
                dukeList[number - 1].markAsDone();
                System.out.println("__________________________________________________\n");
                System.out.println("   Nice! I've marked this task as done:\n");
                System.out.println("   [✓] " + dukeList[number - 1].description + "\n");
                System.out.println("__________________________________________________\n");
            }

            // other commands like "read book" to be added in the list
            else {
                try {
                    String[] keyword = in.split(" ");
                    if (!(keyword[0].equals("todo") || keyword[0].equals("event") || keyword[0].equals("deadline"))) {
                        throw new DukeExceptions("   \u2639 OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                    }

                    switch (keyword[0]) {
                        case "todo": {
                            if (in.equals("todo")) {
                                throw new DukeExceptions("   \u2639 OOPS!!! The description of a todo cannot be empty.\n");
                            }
                            Task task = new ToDo(in.replaceFirst("todo ", ""));
                            dukeList[taskNumber++] = task;
                            break;
                        }
                        case "event": {
                            if (in.equals("event")) {
                                throw new DukeExceptions("   \u2639 OOPS!!! The description of an event cannot be empty.\n");
                            }
                            String[] getDate = in.split("/at ");
                            Date date = simpleDateFormat.parse(getDate[getDate.length-1]);
                            String formatDate = simpleDateFormat.format(date);

                            Task task = new Event(getDate[0].replaceFirst("event", ""), formatDate);
                            dukeList[taskNumber++] = task;
                            break;
                        }
                        case "deadline": {
                            if (in.equals("deadline")) {
                                throw new DukeExceptions("   \u2639 OOPS!!! The description of a deadline cannot be empty.\n");
                            }
                            String[] getDate = in.split("/by ");
                            Date date = simpleDateFormat.parse(getDate[getDate.length-1]);
                            String formatDate = simpleDateFormat.format(date);

                            Task task = new Deadline(getDate[0].replaceFirst("deadline ", ""), formatDate);
                            dukeList[taskNumber++] = task;
                            break;
                        }
                    }
                    updateSave.requestWrite(dukeList);
                    System.out.println("__________________________________________________\n");
                    System.out.println("   Got it. I've added this task: \n");
                    System.out.println("   " + dukeList[taskNumber - 1].toString() + "\n");
                    System.out.println("   Now you have " + taskNumber + " tasks in the list.\n");
                    System.out.println("__________________________________________________\n");
                }
                catch (DukeExceptions | ParseException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
