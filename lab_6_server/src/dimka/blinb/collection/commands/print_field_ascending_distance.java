package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;
import dimka.blinb.collection.objects.Route;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

public class print_field_ascending_distance extends CommandAble implements Serializable {
    /**
     * Вывести значения поля distance всех элементов в порядке возрастания
     *
     * @param commands
     * @param args
     * @return
     * @throws IOException
     */
    @Override
    public String execute(Commands commands) throws IOException {
        commands.getCollection().getLHM().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Route::getDistance)))
                .forEach(x -> System.out.println(x.getValue()));
        return null;
    }

    @Override
    public String getName() {
        return "print_field_ascending_distance";
    }

    @Override
    public String toString(){
        return "вывести значения поля distance всех элементов в порядке возрастания";
    }
}
