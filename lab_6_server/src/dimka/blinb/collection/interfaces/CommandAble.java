package dimka.blinb.collection.interfaces;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.exception.NameIsEmpty;
import dimka.blinb.collection.exception.OutOfRange;

import java.io.IOException;
import java.io.Serializable;

/**
 * Interface of all commands. Each command should be implements from this Interface.
 */
public class CommandAble implements Serializable {
    public Integer EXPECTED_LEN;
    public CommandAble(Integer EXPECTED_LEN){
        this.EXPECTED_LEN = EXPECTED_LEN;
    }
    public CommandAble(){
        this.EXPECTED_LEN = 1;
    }

    /**
     Initialize the params of the object that the command work with
     */
    public void initialize(String[] args) throws Exception{

    }

    /**
     * Execute the command.
     **/
    public String execute(Commands commands) throws IOException, NameIsEmpty, OutOfRange{
        return null;
    }
    /**
     * Return information about command.
     **/
    public String toString(){
        return null;
    }

    /**
     * Get name of command.
     */
    public String getName(){
        return null;
    }
}
