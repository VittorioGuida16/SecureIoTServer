import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class ClientTest {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8443;
    private static final String TRUSTSTORE_PATH = "src/resources/keystore.jks";
    private static final String TRUSTSTORE_PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Configura SSL per il client
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            KeyStore trustStore = KeyStore.getInstance("JKS");

            try (FileInputStream fis = new FileInputStream(TRUSTSTORE_PATH)) {
                trustStore.load(fis, TRUSTSTORE_PASSWORD.toCharArray());
            }

            tmf.init(trustStore);
            sslContext.init(null, tmf.getTrustManagers(), null);

            // Connetti il client al server
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            SSLSocket socket = (SSLSocket) ssf.createSocket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("🔗 Connesso al server!");

            // Invio/Ricezione dati
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("🌍 Messaggio dal client!");
            System.out.println("📩 Risposta dal server: " + in.readLine());

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

