package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;
import dimka.blinb.collection.utilities.Notification;

import java.io.IOException;
import java.io.Serializable;
import java.util.stream.Collectors;

public class show extends CommandAble implements Serializable {
    static final long serialVersionUID = 123456;
    /**
     * Showing the collection
     **/

    @Override
    public void initialize(String[] args) throws Exception{

    }

    @Override
    public String execute(Commands commands) throws IOException {
        if (commands.getCollection().getLHM().size() > 0)
            return commands.getCollection().LHMtoString();
        else
            return "The collection is empty =( ";
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String toString(){
        return "Show the collection";
    }
}
