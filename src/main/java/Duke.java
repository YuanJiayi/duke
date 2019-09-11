import Tasks.Deadline;
import Tasks.Event;
import Tasks.ListOfTask;
import Tasks.ToDo;

import java.io.IOException;
import java.util.Scanner;

/**
 * The overall control of Duke. Handle the process flow.
 */
public class Duke {
    private ListOfTask tasks;
    private Parser parser;

    public Duke() {}

    /**
     * Call duke to run
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {
        new Duke().run();
    }

    /**
     * Run the overall program
     * @throws IOException
     */
    public void run() throws IOException {
        tasks = new ListOfTask();
        parser = new Parser();
        DukeExceptions exceptions = new DukeExceptions();

        UI.Start();
        int count = Storage.LoadTask(tasks, 0);

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            Command command = parser.parse(input);

            switch (command.cmdType) {
                case "bye":
                    UI.UiBye();
                    System.exit(0);
                case "list":
                    UI.UiList(tasks, count);
                    break;
                case "done":
                    UI.UiDone(tasks.done(command.index));
                    break;
                case "delete":
                    UI.UiDelete(tasks.get(command.index), count);
                    tasks.delete(command.index);
                    count--;
                    break;
                case "find":
                    tasks.find(command.description);
                    break;
                case "todo":
                    tasks.add(new ToDo(command.description));
                    UI.UiTodo(tasks.get(tasks.size() - 1), count);
                    count++;
                    break;
                case "event":
                    tasks.add(new Event(command.description));
                    UI.UiEvent(tasks.get(tasks.size() - 1), count);
                    count++;
                    break;
                case "deadline":
                    tasks.add(new Deadline(command.description));
                    UI.UiDeadline(tasks.get(tasks.size() - 1), count);
                    count++;
                    break;
                case "InvalidInput":
                    exceptions.InvalidInput();
            }
            Storage.saveTask(tasks, count);
        }
    }
}
