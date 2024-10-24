import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public TCPServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();

        } catch (IOException e) {
            System.out.printf("Error during the connection - %s\n", e.getMessage());
        }
    }


    public String getMessage() {
        byte[] buffer = new byte[1];
        StringBuilder sb = new StringBuilder();
        try {
            InputStream stream = clientSocket.getInputStream();
            while (stream.read(buffer) != -1) {
                String c = new String(buffer);
                sb.append(c);
                if(c.equals("\n"))
                    break;
            }
        } catch (IOException e) {
            System.out.printf("Error during receiving the message - %s\n", e.getMessage());
        }

        return sb.toString();
    }


//    public void sendMessage(String message) {
//        byte[] buffer = message.getBytes();
//        try {
//            OutputStream stream = this.socket.getOutputStream();
//            stream.write(buffer);
//            stream.flush();
//        } catch (IOException e) {
//            System.out.printf("Error during sending the message - %s\n", e.getMessage());
//        }
//    }
//
//    public void close() {
//        try {
//            this.socket.close();
//        } catch (IOException e) {
//            System.out.printf("Error during closing the socket - %s\n", e.getMessage());
//        }
//    }
}
