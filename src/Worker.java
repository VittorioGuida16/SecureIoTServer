import javax.net.ssl.SSLSocket;
import java.io.*;

public class Worker extends Thread {
    private SSLSocket clientSocket;

    public Worker(SSLSocket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            out.println("🔒 Connessione SSL stabilita!");
            System.out.println("✅ Client connesso da: " + clientSocket.getInetAddress());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("📩 Messaggio ricevuto: " + message);
                out.println("Echo: " + message); // Risponde al client con un messaggio di conferma
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
