package Tasks;

import java.text.ParseException;
import java.util.Date;

public class Event extends Task {
    public String at;
    private String d;

    public Event (String description) {
        super(description);
        String[] keywords = description.split("/at ");
        this.at = keywords[1];
        this.type = "E";
        this.d = keywords[0];
    }

    @Override
    public String toString() {
        Date date = null;
        try {
            date = super.getDate(this.at);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            return "[E]" + super.toString() + d + " (at: " + date + ")";
        }
        else return "[E]" + super.toString() + d + " (at: " + at + ")";
    }
}
