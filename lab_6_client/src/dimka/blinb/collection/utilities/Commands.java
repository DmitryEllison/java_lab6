package dimka.blinb.collection.utilities;

import dimka.blinb.collection.exception.IncorrectCommand;
import dimka.blinb.collection.interfaces.*;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class Commands {
    private static Map <String, CommandAble> mapOfCommands = new TreeMap<>();
    private static LinkedList<String> history = new LinkedList<String>();
    public static Boolean IS_LOGGED = false;
    public static Boolean IS_WORKING = true;

    /**
     * Adding available command
     * @param commands
     */
    public void addCommands(CommandAble... commands){
        for (CommandAble command: commands){
            mapOfCommands.put(command.getName(), command);
        }
    }
    public Map getMapOfCommands(){
        return mapOfCommands;
    }
    public LinkedList<String> getHistory(){
        return history;
    }
    private void addToHistory(String command){
        this.getHistory().addFirst(command);
        if (this.getHistory().size()>5)
            this.getHistory().removeLast();
    }

    /**
     * Handle the current command out
     */
    public CommandAble handle(String[] args) throws Exception { //save path
        CommandAble command;
        try {
            String nameOfCommand = args[0];
            // Контроль корректности команды
            if(mapOfCommands.get(nameOfCommand).EXPECTED_LEN != args.length)
                throw new IncorrectCommand();
            // Вызываем метод объекта CommandAble, хранящийся в коллекции по ключу (Имя Команды)
            command = mapOfCommands.get(nameOfCommand);
            command.initialize(args);
            // Добавляем имя команды в историю
            this.addToHistory(nameOfCommand);
            return command;
        } catch ( IncorrectCommand e){
            System.err.println("The arguments of command are wrong!");
        } catch (NullPointerException e){
            System.err.println("The command not recognized!");
        }
        return null;
    }
}
