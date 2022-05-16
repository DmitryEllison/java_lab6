import dimka.blinb.collection.commands.*;
import dimka.blinb.collection.utilities.*;
import dimka.blinb.collection.interfaces.CommandAble;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author DimkaBlinb
 * @version lab6.client
 * */

public class lab6_client {
    /**
     * Main class
     */
    public static void main(String[] args) throws Exception {
        // Создание объекта который будет работать с командами
        Commands commands = new Commands();
        // Добавляем наши команды
        commands.addCommands(
                new execute_script(), new filter_starts_with_name(), new info(), new insert(),
                new print_field_ascending_distance(), new print_field_descending_distance(), new show(),
                new remove_key(), new remove_lower(), new update_id(),
                new history(), new help(), new exit(), new clear());
        // Начало работы с пользователем
        Scanner in = new Scanner(System.in, "windows-1251");

        System.out.println("The program is ready to work!");
        System.out.println("Enter your first command to send it to the Server: ");
        while (Commands.IS_WORKING){
            // Подключение
            ClientSender.reconnect();
            // Работа с сервером
            while (ClientSender.SERVER_IS_CONNECTED){
                try {
                    String s = in.nextLine();
                    // Создание объекта комманды с заполненными полями
                    CommandAble command  = commands.handle(s.split(" "));
                    if (command != null) {
                        ClientSender.send(command);
                        try {
                            // Get data from server
                            Notification notification = ClientReceiver.receive();
                            // and print it
                            if (notification.toString() != null)
                                System.out.println(notification.toString());
                            else
                                command.execute(commands, s.split(" "));
                        } catch (SocketTimeoutException e) {
                            System.err.println("The Server is not connected or busy right now, try again later.");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println(e.getCause());
                        }
                    }
                } catch (NoSuchElementException | ClassNotFoundException | InterruptedException | SocketException e) {
                    System.err.println(e);
                }

            }
        }
    }
}
