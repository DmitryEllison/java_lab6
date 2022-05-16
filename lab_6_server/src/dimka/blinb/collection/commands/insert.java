package dimka.blinb.collection.commands;

import dimka.blinb.collection.utilities.Commands;
import dimka.blinb.collection.exception.IncorrectInsert;
import dimka.blinb.collection.interfaces.CommandAble;
import dimka.blinb.collection.objects.Coordinates;
import dimka.blinb.collection.objects.Location;
import dimka.blinb.collection.objects.Route;

import java.io.IOException;
import java.io.Serializable;

public class insert extends CommandAble implements Serializable {
    public Route r;
    public insert(){
        super(3);
    }
    static final long serialVersionUID = 3L;
    /**
     * Insert new element by key [insert KEY {~element~}]
     * // insert NAME {Coordinates(Int,Float);from;to(Name,Float,Long);Float} : добавить новый элемент с заданным ключом
     * insert 3131 {1,1;;Чебоксары,1,1;200.5}
     * @param commands
     * @param args
     * @return
     * @throws IOException
     **/


    public String execute(Commands commands, String[] args) throws IOException {

        try{
            commands.getCollection().add(this.r);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(new IncorrectInsert().getMessage());
        }
        return null;
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String toString(){
        return "Insert new element by key [insert KEY {~element~}]";
    }
}
