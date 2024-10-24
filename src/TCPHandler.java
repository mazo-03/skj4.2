import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//TODO Copy and modify the proper constructor of tcp communication schema
// sokcet 1. accet sockter other one accept host and ip

public class TCPHandler {
    private Socket socket;

    public TCPHandler(Socket socket) {
        this.socket = socket;
    }


    public TCPHandler(String host, int port) {
        try {
            this.socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.printf("Error during the connection - %s\n", e.getMessage());
            return;
        }
    }

    public String getMessage() {
        byte[] buffer = new byte[1];
        StringBuilder sb = new StringBuilder();
        try {
            InputStream stream = this.socket.getInputStream();
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


    public void sendMessage(String message) {
        byte[] buffer = message.getBytes();
        try {
            OutputStream stream = this.socket.getOutputStream();
            stream.write(buffer);
            stream.write('\n');

            stream.flush();
        } catch (IOException e) {
            System.out.printf("Error during sending the message - %s\n", e.getMessage());
        }
    }

    public void close() {
        try {
            this.socket.close();
        } catch (IOException e) {
            System.out.printf("Error during closing the socket - %s\n", e.getMessage());
        }
    }


}

