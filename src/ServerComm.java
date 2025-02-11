import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class ServerComm {
    private static final int PORT = 8443; // Porta HTTPS
    private static final String KEYSTORE_PATH = "src/keystore/keystore.jks"; // Assicurati che il file sia qui
    private static final String KEYSTORE_PASSWORD = "123456"; // Cambia con la tua password

    public static void main(String[] args) {
        try {
            // Configura il server SSL
            SSLServerSocketFactory ssf = configureSSL();
            SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(PORT);

            // 🔹 Abilita solo TLS 1.2 per compatibilità con ESP32
            serverSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

            System.out.println("🔒 Secure Server in ascolto sulla porta " + PORT);

            // Attende connessioni dai client
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("✅ Nuovo client connesso!");
                new Worker(clientSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo per configurare il server SSL
    private static SSLServerSocketFactory configureSSL() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS"); // 🔹 CORRETTO: Usa JKS (non PKCS12)
        keyStore.load(new FileInputStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2"); // 🔹 Forza TLS 1.2
        sslContext.init(kmf.getKeyManagers(), null, null);

        return sslContext.getServerSocketFactory();
    }
}