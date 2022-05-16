package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class remove_key extends CommandAble implements Serializable {
    public Integer key;
    public remove_key(){
        super(2);
    }
    @Override
    public void initialize(String[] args){
        this.key = Integer.valueOf(args[1]);
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
