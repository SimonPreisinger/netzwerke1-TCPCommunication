import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageReceiver {
    public static final int PORT = 4711;

    public static void main(String... args){
        MessageReceiver receiver = new MessageReceiver();
        receiver.startReceiver();
    }

    public void startReceiver() {
        try(ServerSocket s1 = new ServerSocket(PORT)) {
            try (Socket s2 = s1.accept(); BufferedReader fromClient = new BufferedReader(new InputStreamReader(s2.getInputStream()))){
                for (String line = fromClient.readLine(); line != null && line.length() > 0; line = fromClient.readLine()) {


                    System.out.println("Received message: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
