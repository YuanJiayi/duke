import java.io.*;

public class UpdateSave {
    private static Task[] dukeList = new Task[100];
    private static int taskNumber = 0;

    public UpdateSave() throws IOException, DukeExceptions {
        try {
            FileReader fileReader = new FileReader("data/duke.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace('|', '@');
                String[] info = line.split(" @ ");

                if (!(info[0].equals("T") || info[0].equals("E") || info[0].equals("D"))) {
                    throw new DukeExceptions("Invalid Input!!!");
                }
                Task task = new Task("default");

                switch (info[0]) {
                    case "T":
                        task = new ToDo(info[2]);
                        break;
                    case "E":
                        task = new Event(info[2], info[3]);
                        break;
                    case "D":
                        task = new Deadline(info[2], info[3]);
                        break;
                }
                // no update on task
                if (task.description.equals("default")) {
                    throw new DukeExceptions("This task is not refreshed yet.");
                }
                if (info[1].equals("1")) {
                    task.markAsDone();
                }
                dukeList[taskNumber++] = task;
            }
            bufferedReader.close();
        }
        catch (IOException | DukeExceptions ex) {
            ex.printStackTrace();
        }
    }

    public void requestWrite(Task[] taskList) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("data/duke.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");

            for (Task task : taskList) {
                if (task instanceof ToDo) {
                    if (!task.isDone) {
                        bufferedWriter.write(task.type + " | 0 | " + task.description + "\n");
                    } else {
                        bufferedWriter.write(task.type + " | 1 | " + task.description + "\n");
                    }
                } else if (task instanceof Event) {
                    if (!task.isDone) {
                        bufferedWriter.write(task.type + " | 0 | " + task.description + " | " + ((Event) task).at + "\n");
                    } else {
                        bufferedWriter.write(task.type + " | 1 | " + task.description + " | " + ((Event) task).at + "\n");
                    }
                } else if (task instanceof Deadline) {
                    if (!task.isDone) {
                        bufferedWriter.write(task.type + " | 0 | " + task.description + " | " + ((Deadline) task).by + "\n");
                    } else {
                        bufferedWriter.write(task.type + " | 1 | " + task.description + " | " + ((Deadline) task).by + "\n");
                    }
                }
            }
            bufferedWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Task[] requestData() {
        return dukeList;
    }

    public int requestTasksAmount() {
        return taskNumber;
    }
}
