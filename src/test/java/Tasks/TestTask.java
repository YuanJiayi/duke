package Tasks;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask {

    @Test
    public void TestgetStatusIcon() {
        assertEquals("[✗]", new Task("Task description").getStatusIcon());
    }

    @Test
    public void TesttoString() {
        assertEquals("task", new Task("task").toString());
    }

    @Test
    public void TestgetDate() throws ParseException {
        assertEquals("", new Task("task 12/09/2019").getDate("12/09/2019"));
    }
}
