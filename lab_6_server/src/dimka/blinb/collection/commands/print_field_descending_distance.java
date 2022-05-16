package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.interfaces.CommandAble;
import dimka.blinb.collection.objects.Route;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

public class print_field_descending_distance extends CommandAble implements Serializable {
    /**
     * ������� �������� ���� distance ���� ��������� � ������� ��������
     *
     * @param commands
     * @param args
     * @return
     * @throws IOException
     */
    @Override
    public String execute(Commands commands) throws IOException {
        LinkedList<Integer> sorted = new LinkedList<Integer>();
        commands.getCollection().getLHM().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Route::getDistance)))
                .forEach(x -> sorted.add(x.getKey()));

        // Reverse the collection
        Collections.reverse(sorted);
        sorted.stream().forEach(x -> System.out.println(commands.getCollection().getLHM().get(x)));
        return null;
    }

    @Override
    public String getName() {
        return "print_field_descending_distance";
    }

    @Override
    public String toString(){
        return "������� �������� ���� distance ���� ��������� � ������� ��������";
    }
}
