package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class help extends CommandAble implements Serializable {
    @Override
    public String execute(Commands commands) throws IOException {
        commands.getMapOfCommands().entrySet().stream().forEach(System.out::println);
        return null;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String toString(){
        return "Return all available commands";
    }
}
