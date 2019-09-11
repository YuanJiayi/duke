import Tasks.Deadline;
import Tasks.Event;
import Tasks.ListOfTask;
import Tasks.ToDo;

import java.io.*;
import java.util.Scanner;

/**
 * The class to write and read the file that is saved on local disk
 */
public class Storage {

    /**
     * The method for writing the data file
     * @param tasks
     * @param count
     * @throws IOException
     */
    public static void saveTask(ListOfTask tasks, int count) throws IOException {
        FileWriter fileWriter = new FileWriter("data/duke.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        for (int i = 0; i < count; i++) {
            String buf = null;
            if (tasks.get(i) instanceof ToDo) {
                if (tasks.get(i).isDone) {
                    buf = (tasks.get(i).type + " | 1 | " + tasks.get(i).description + "\n");
                } else {
                    buf = (tasks.get(i).type + " | 0 | " + tasks.get(i).description + "\n");
                }
            } else if (tasks.get(i) instanceof Event) {
                if (tasks.get(i).isDone) {
                    buf = (tasks.get(i).type + " | 1 | " + tasks.get(i).description + " | " + ((Event) tasks.get(i)).at + "\n");
                } else {
                    buf = (tasks.get(i).type + " | 0 | " + tasks.get(i).description + " | " + ((Event) tasks.get(i)).at + "\n");
                }
            } else if (tasks.get(i) instanceof Deadline) {
                if (tasks.get(i).isDone) {
                    buf = (tasks.get(i).type + " | 1 | " + tasks.get(i).description + " | " + ((Deadline) tasks.get(i)).by + "\n");
                } else {
                    buf = (tasks.get(i).type + " | 0 | " + tasks.get(i).description + " | " + ((Deadline) tasks.get(i)).by + "\n");
                }
            }
            bufferedWriter.append(buf);
        }
        bufferedWriter.close();
    }

    /**
     * Read in the current data
     * @param tasks
     * @param count
     * @return Return the number of tasks that listoftask contains
     * @throws FileNotFoundException
     */
    public static int LoadTask(ListOfTask tasks, int count) throws FileNotFoundException {
        FileReader fileReader = new FileReader("data/duke.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner sc = new Scanner(fileReader);

        while (sc.hasNextLine()) {
            String[] keywords = sc.nextLine().split(" | ");
            switch (keywords[0]) {
                case "T":
                    tasks.add(new ToDo(keywords[2]));
                    tasks.get(count).isDone = keywords[1].equals("1");
                    break;
                case "E":
                    tasks.add(new Event(keywords[2]));
                    tasks.get(count).isDone = keywords[1].equals("1");
                    break;
                case "D":
                    tasks.add(new Deadline(keywords[2]));
                    tasks.get(count).isDone = keywords[1].equals("1");
                    break;
            }
            count++;
        }
        return count;
    }
}
