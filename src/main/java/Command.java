import java.util.Date;

/**
 * The class to set command information types
 */
public class Command {
    public int index;
    public Date date;
    public String description;
    public String cmdType;

    /**
     * Initialization of variables of in command
     */
    public Command() {
        this.index = -1;
        this.date = null;
        this.description = "";
        this.cmdType = "";
    }
}
