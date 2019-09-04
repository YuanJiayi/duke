import java.util.Date;

public class Command {
    public int index;
    public Date date;
    public String description;
    public String cmdType;

    public Command() {
        this.index = -1;
        this.date = null;
        this.description = "";
        this.cmdType = "";
    }
}
