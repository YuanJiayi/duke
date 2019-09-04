import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    protected boolean isDone;
    protected String description;
    protected String type;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[✓]" : "[✗]");
    }

    public String toString() {
        return this.getStatusIcon();
    }

    public Date getDate(String timeIn) throws ParseException {
        DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HHmm");
        DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = format2.parse(timeIn);
        }
        catch (ParseException ex) {
            date = format1.parse(timeIn);
        }
        return date;
    }

}
