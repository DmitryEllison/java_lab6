package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.io.Serializable;

public class filter_starts_with_name extends CommandAble implements Serializable {
    public filter_starts_with_name(){
        super(2);
    }


    public String execute(Commands commands, String[] args) throws IOException {
        // вывести элементы, значение поля name которых начинается с заданной подстроки
        commands.getCollection().getLHM().entrySet().stream().filter(
                element -> element.getValue().getName().
                        startsWith(args[1])).forEach(System.out::println);
        return null;
    }

    @Override
    public String getName() {
        return "filter_starts_with_name";
    }

    @Override
    public String toString(){
        return "Return all elements that starts with name \"NAME\"";
    }
}
