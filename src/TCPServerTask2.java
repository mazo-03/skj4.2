import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTask2 implements Runnable {
    private int port;
    public TCPServerTask2(int port) {
        this.port = port;
    }

    public void run(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

}

