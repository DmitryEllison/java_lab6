package dimka.blinb.collection.utilities;

import dimka.blinb.collection.exception.IncorrectCommand;
import dimka.blinb.collection.exception.NameIsEmpty;
import dimka.blinb.collection.exception.OutOfRange;
import dimka.blinb.collection.interfaces.*;
import dimka.blinb.collection.objects.Route;

import java.io.*;
import java.util.*;


public class Commands implements Serializable{
    private transient static Map <String, CommandAble> mapOfCommands = new TreeMap<>();
    private transient static LinkedList<String> history = new LinkedList<String>();
    private transient static Collection collection;
    transient String nameOfFile = "";

    public Commands(Collection collection) throws FileNotFoundException {
        this.collection = collection;
    }
    /**
     * Adding available command
     * @param commands
     */
    public void addCommands(CommandAble... commands){
        for (CommandAble command: commands){
            mapOfCommands.put(command.getName(), command);
        }
    }
    public Collection getCollection() { return this.collection; }
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
    public void handle(String[] args) throws IOException, NameIsEmpty, OutOfRange { //save path
        try {
            String nameOfCommand = args[0];
            // Контроль корректности команды
            if(mapOfCommands.get(nameOfCommand).EXPECTED_LEN != args.length)
                throw new IncorrectCommand();
            // Вызываем метод объекта CommandAble, хранящийся в коллекции по ключу (Имя Команды)
            mapOfCommands.get(nameOfCommand).execute(this);
            // Добавляем имя команды в историю
            this.addToHistory(nameOfCommand);
        } catch (NullPointerException | IncorrectCommand e){
            System.out.println("The command not recognized!");
            System.out.println(e.getMessage());
        }

    }
    public void writeFile() throws IOException{
        /** Write collection in the file by name of file given as parameter **/
        try {
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(nameOfFile));
            // Write elements of collection line by line
            for(Map.Entry<Integer, Route> element: collection.getLHM().entrySet()){
                stream.write((element.getValue().toString() + "\n").getBytes());
            }
            stream.close();
        } catch (IOException e){
            // If available memory is over
            e.printStackTrace();
        }
    }

    public void openFile(String[] path) throws NullPointerException{
        /** Open the file.csv by name of file given as parameter and read collection **/
        try{
            File file = new File(path[0]);
            Scanner scanner = new Scanner(file, "windows-1251");
            this.scan(scanner); // here he is writing
            scanner.close();
            this.nameOfFile = path[0];
        } catch(Exception e){
            System.out.println("No such file exists, please enter again!");
            this.openFile(new String[] {askNameOfFile()});
        }
    }

    public static String askNameOfFile(){
        /** Ask name of file from user **/
        Scanner input = new Scanner(System.in, "windows-1251");
        String line = input.nextLine();
        if (line.compareTo("exit") == 0)
            System.exit(0);
        return line;
    }

    public void scan(Scanner scanner) throws NullPointerException{
        /** Put elements in collection from opened file **/
        try {
            String line;
            if (!Objects.isNull(scanner.findInLine("-skip"))) scanner.nextLine();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                Route route = new Route(line.split(";"));
                this.collection.add(route);
            }
        } catch (NameIsEmpty nameIsEmpty) {
            System.out.println("The name cannot be empty!");
        } catch (OutOfRange outOfRange) {
            System.out.println("Data is incorrect!");
        }
    }
}
