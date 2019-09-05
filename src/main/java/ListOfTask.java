import java.util.ArrayList;

public class ListOfTask {
    public ArrayList<Task> tasks;

    public ListOfTask() {
        this.tasks = new ArrayList<>();
    }

    public boolean add (Task task) {
        return tasks.add(task);
    }

    public int size() {
        return tasks.size();
    }

    public Task done (int index) {
        tasks.get(index).isDone = true;
        return tasks.get(index);
    }

    public void delete (int index, int count) {
        UI.UiDelete(tasks.get(index), count);
        tasks.remove(index);
    }

    public void find (String findInfo) {
        int countFind = 0;
        for (int No = 1; No <= tasks.size(); No++) {
            if (tasks.get(No - 1).description.contains(findInfo)) {
                countFind++;
                System.out.println("   " + countFind + ". " + tasks.get(No - 1).toString() + "\n");
            }
        }
    }

    public Task get(int index) {
        return tasks.get(index);
    }
}
