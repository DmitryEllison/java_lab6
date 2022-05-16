package dimka.blinb.collection.utilities;

import dimka.blinb.collection.commands.*;
import dimka.blinb.collection.exception.NameIsEmpty;
import dimka.blinb.collection.exception.OutOfRange;
import dimka.blinb.collection.utilities.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;

public class CreateServer {
    public static ServerSocket server;
    public static Collection collection = new Collection();
    public static Commands commands;


    static {
        try {
            commands = new Commands(collection);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void create() throws Exception{
        CreateServer.checkForExitSaveCommand();
        // Добавляем наши команды
        commands.addCommands(
                new execute_script(), new filter_starts_with_name(), new info(), new insert(),
                new print_field_ascending_distance(), new print_field_descending_distance(), new show(),
                new remove_key(), new remove_lower(), new update_id(),
                new history(), new help(), new exit(), new clear());

        try {
            server = new ServerSocket(2222);
            System.out.println("Сервер запущен");
        } catch (BindException e) {
            System.out.println("Данный порт уже занят,возможно сервер уже запущен!\n Принудительно завершаю работу.");
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkForExitSaveCommand() {
        Thread backgroundReaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (!Thread.interrupted()) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.equalsIgnoreCase("exit")) {
                            commands.handle(new String[]{"save"});
                            System.out.println("Завершаю работу.");
                            System.exit(0);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (NameIsEmpty nameIsEmpty) {
                    nameIsEmpty.printStackTrace();
                } catch (OutOfRange outOfRange) {
                    outOfRange.printStackTrace();
                }
            }
        });
        backgroundReaderThread.setDaemon(true);
        backgroundReaderThread.start();
    }

}
