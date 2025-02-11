import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// Worker che gestisce ogni connessione client
class Worker2 extends Thread {
    private SSLSocket clientSocket;

    public Worker2(SSLSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Leggi la richiesta HTTP dal client
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break; // Fine degli header
                }
                System.out.println(line); // Stampa gli header della richiesta
            }

            // Rispondi al client
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/plain");
            writer.println("Connection: close");
            writer.println();  // Linea vuota per separare gli header dal corpo
            writer.println("Dati ricevuti correttamente");

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}