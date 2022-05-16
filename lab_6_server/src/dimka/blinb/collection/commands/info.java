package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class info extends CommandAble implements Serializable {
    static final long serialVersionUID = 1L;
    /**
     * Return information about the collection.
     *
     * @param commands
     * @return
     * @throws IOException
     */
    @Override
    public String execute(Commands commands) throws IOException {
        return commands.getCollection().toString();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String toString(){
        return "Return information about the collection.";
    }
}
