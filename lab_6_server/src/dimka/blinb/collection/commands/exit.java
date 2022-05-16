package dimka.blinb.collection.commands;
import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.Serializable;

public class exit extends CommandAble implements Serializable {
    /**
     * Closing the program without saving
     * @return
     */
    @Override
    public String execute(Commands commands){
        commands.getCollection().turnOff();
        return null;
    }

    @Override
    public String toString(){
        return "Closing the program without saving";
    }

    @Override
    public String getName(){
        return "exit";
    }
}
