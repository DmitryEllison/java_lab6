package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;
import dimka.blinb.collection.objects.Route;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class remove_lower extends CommandAble implements Serializable {
    public Integer key;
    public remove_lower(){
        super(2);
    }
    /**
     * Удалить из коллекции все элементы, меньшие, чем заданный
     *
     * @return
     * @throws IOException
     */

    @Override
    public void initialize(String[] args){
        this.key = Integer.valueOf(args[1]);
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
