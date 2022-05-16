package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class clear extends CommandAble implements Serializable {
    @Override
    public String execute(Commands commands) throws IOException {
        commands.getCollection().getLHM().clear();
        return null;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String toString(){
        return "Clear the collection.";
    }
}