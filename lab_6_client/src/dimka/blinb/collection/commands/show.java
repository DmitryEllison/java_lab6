package dimka.blinb.collection.commands;

import dimka.blinb.collection.exception.NameIsEmpty;
import dimka.blinb.collection.exception.OutOfRange;
import dimka.blinb.collection.interfaces.CommandAble;
import dimka.blinb.collection.utilities.Commands;

import java.io.IOException;
import java.io.Serializable;

public class show extends CommandAble implements Serializable {
    static final long serialVersionUID = 123456;
    /**
     * Showing the collection
     **/

    @Override
    public String execute(Commands commands, String[] args) throws IOException, NameIsEmpty, OutOfRange{
        return null;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String toString(){
        return "Showing the collection";
    }
}
