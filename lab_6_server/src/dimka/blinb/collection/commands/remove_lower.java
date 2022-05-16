package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;
import dimka.blinb.collection.objects.Route;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;

public class remove_lower extends CommandAble implements Serializable {
    public remove_lower(){
        super(2);
    }
    /**
     * Удалить из коллекции все элементы, меньшие, чем заданный
     *
     * @param commands
     * @param args
     * @return
     * @throws IOException
     */

    public String execute(Commands commands, String[] args) throws IOException {
        LinkedHashMap<Integer, Route> newLHM = new LinkedHashMap<>();
        commands.getCollection().getLHM().entrySet().stream().
                filter(element -> element.getKey() < Integer.valueOf(args[1])).
                forEach(element -> newLHM.put(element.getKey(), element.getValue()));
        commands.getCollection().setLHM(newLHM);
        return null;
    }

    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String toString(){
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
