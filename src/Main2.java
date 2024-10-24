public class Main2 {
    public static void main(String[] args) {
        int port = 9005;
        new Thread(new TCPServerTask2(port)).start();
    }
}
