package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class help extends CommandAble implements Serializable {
    static final long serialVersionUID = 4L;

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String toString(){
        return "Return all available commands";
    }
}
