import dimka.blinb.collection.exception.*;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

import dimka.blinb.collection.interfaces.CommandAble;
import dimka.blinb.collection.utilities.*;

/**
 * @author DimkaBlinb
 * @version lab6.server
 * */

public class lab6_server {
    /**
     * Main class
     */
    public static void main(String[] args) throws Exception {
        CreateServer.create();
        CreateServer.commands.openFile(new String[]{"C:\\Users\\dimka\\IdeaProjects\\java_lab_6\\lab6_server\\src\\file.txt"});
        while (!CreateServer.server.isClosed()) {
            Socket socket = CreateServer.server.accept();
            System.out.println("Connecting: " + socket.getLocalAddress() + " " + socket.getPort());

            try {
                ServerSender serverSender = new ServerSender(socket);
                ServerReceiver serverReceiver = new ServerReceiver(socket);
                while (CreateServer.collection.IS_WORKING) {
                    try{
                        CommandAble cmd = serverReceiver.receive();
                        // The command has delivered
                        System.out.println(cmd.toString());
                        Notification notification = new Notification(cmd.execute(CreateServer.commands));
                        serverSender.send(notification);
                    } catch (SocketTimeoutException e){

                    }

                }
            }catch (Exception e){
                System.err.println(e.fillInStackTrace());
            }
        }
    }
}

