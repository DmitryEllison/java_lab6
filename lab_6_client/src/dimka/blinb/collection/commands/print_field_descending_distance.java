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
     * Вывести значения поля distance всех элементов в порядке убывания
     *
     * @param commands
     * @param args
     * @return
     * @throws IOException
     */

    @Override
    public String getName() {
        return "print_field_descending_distance";
    }

    @Override
    public String toString(){
        return "Вывести значения поля distance всех элементов в порядке убывания";
    }
}
