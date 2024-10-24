import java.net.Socket;

public class ClientHandler implements Runnable {
    private TCPHandler handler;

    //TODO Constructor
    //CREATE OBJECT
    public ClientHandler(Socket socket) {
        handler = new TCPHandler(socket);
    }


    @Override
    public void run() {
        //TODO Logic of the communication with the usage if TCPHandler
        handler.sendMessage("Server hello\n");
        System.out.println(handler.getMessage());
        System.out.println(handler.getMessage());
        handler.close();
    }
}
