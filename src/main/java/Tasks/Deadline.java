package Tasks;

import java.text.ParseException;
import java.util.Date;

public class Deadline extends Task {

    public String by;
    private String d;

    public Deadline (String description) {
        super (description);
        String[] keywords = description.split("/by ");
        this.by = keywords[1];
        this.type = "D";
        this.d = keywords[0];
    }

    @Override
    public String toString() {
        Date date = null;
        try {
            date = super.getDate(this.by);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            return "[D]" + super.toString() + d + " (by: " + date + ")";
        }
        else return "[D]" + super.toString() + d + " (by: " + by + ")";
    }
}
