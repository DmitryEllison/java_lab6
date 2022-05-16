package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class save extends CommandAble implements Serializable {

    public String execute(Commands commands, String[] args) throws IOException {
        commands.writeFile();
        return null;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String toString(){
        return "Saving the collection in file";
    }
}
