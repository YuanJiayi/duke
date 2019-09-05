public class Parser {
    public Command command;
    private DukeExceptions exceptions;

    public Parser() {
        this.command = new Command();
        this.exceptions = new DukeExceptions();
    }

    public Command parse(String input) {

        if (input.equals("list")) {
            this.command.cmdType = "list";
        }

        else if (input.equals("bye")) {
            command.cmdType = "bye";
        }

        else if (input.length() > 3 && input.substring(0, 4).equals("done")) {
            if (input.length() == 4) {
                exceptions.EmptyDescription("done");
            }
            else {
                command.cmdType = "done";
                command.index = Integer.parseInt(input.substring(5)) - 1;
            }
        }

        else if (input.length() > 5 && input.substring(0, 6).equals("delete")) {
            if (input.length() == 6) {
                exceptions.EmptyDescription("delete");
            }
            else {
                command.cmdType = "delete";
                command.index = Integer.parseInt(input.substring(7)) - 1;
            }
        }

        else if (input.length() > 3 && input.substring(0, 4).equals("find")) {
            if (input.length() == 4) {
                exceptions.EmptyDescription("find");
            }
            else {
                command.cmdType = "find";
                command.description = input.substring(5);
            }
        }

        else if (input.length() > 3 && input.substring(0, 4).equals("todo")) {
            if (input.length() == 4) {
                exceptions.EmptyDescription("todo");
            }
            else {
                command.cmdType = "todo";
                command.description = input.substring(5);
            }
        }

        else if (input.length() > 4 && input.substring(0, 5).equals("event")) {
            if (input.length() == 5) {
                exceptions.EmptyDescription("event");
            }
            else {
                command.cmdType = "event";
                command.description = input.substring(6);
            }
        }

        else if (input.length() > 7 && input.substring(0, 8).equals("deadline")) {
            if (input.length() == 8) {
                exceptions.EmptyDescription("deadline");
            }
            else {
                command.cmdType = "deadline";
                command.description = input.substring(9);
            }
        }
        else {
            command.cmdType = "InvalidInput";
        }
        return command;
    }
}
