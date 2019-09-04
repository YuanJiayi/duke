import java.io.IOException;
import java.util.Scanner;
import java.text.ParseException;

public class Duke {
    private ListOfTask tasks;
    private Parser parser;

    public Duke() {}

    public static void main (String[] args) throws IOException {
        new Duke().run();
    }

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
                    tasks.delete(command.index, count);
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
                default:
                    exceptions.InvalidInput();
                    break;
            }
            Storage.saveTask(tasks, count);
        }
    }
}
