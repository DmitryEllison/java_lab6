package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class remove_key extends CommandAble implements Serializable {
    public remove_key(){
        super(2);
    }
    /**
     * Delete element by key.
     *
     * @param commands
     * @param args
     * @return
     * @throws IOException
     **/

    public String execute(Commands commands, String[] args) throws IOException {
        if (commands.getCollection().hasElement(Integer.valueOf(args[1])))
            commands.getCollection().getLHM().remove(Integer.valueOf(args[1]));
        return null;
    }

    @Override
    public String getName() {
        return "remove_key";
    }

    @Override
    public String toString(){
        return "Delete element by key";
    }
}
