package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class history extends CommandAble implements Serializable {
    static final long serialVersionUID = 2L;
    /**
     * Return last 5 commands
     * @param commands
     * @param args
     * @return
     * @throws IOException
     */
    @Override
    public String execute(Commands commands, String[] args) throws IOException {
        if (commands.getHistory().size()!=0)
            commands.getHistory().stream().forEach(cmd -> System.out.println("\t" + cmd));
        return null;
    }

    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String toString(){
        return "Return history of commands";
    }
}
