import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.*;

public class ServerComm2 {
    private static final int PORT = 8443; // Porta HTTPS
    private static final String KEYSTORE_PATH = "src/keystoreProf/servercert.p12"; // Percorso del keystore in formato PKCS12
    private static final String KEYSTORE_PASSWORD = "abc123"; // Password del keystore
    private static final String TRUSTSTORE_PATH = "src/keystoreProf/truststore.jks"; // Percorso del truststore (dove importa il certificato dell'ESP32)
    private static final String TRUSTSTORE_PASSWORD = "abc123"; // Password del truststore

    public static void main(String[] args) {
        try {
            // Configura il server SSL
            SSLServerSocketFactory ssf = configureSSL();
            SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(PORT);

            // Abilita solo TLS 1.2 per compatibilità con ESP32
            serverSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

            System.out.println("🔒 Secure Server in ascolto sulla porta " + PORT);

            // Attende connessioni dai client
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("✅ Nuovo client connesso!");
                new Worker2(clientSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo per configurare il server SSL
    private static SSLServerSocketFactory configureSSL() throws Exception {
        // Carica il keystore del server (in formato PKCS12)
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(new FileInputStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

        // Carica il truststore del server (certificati di fiducia, inclusi quelli dell'ESP32)
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream(TRUSTSTORE_PATH), TRUSTSTORE_PASSWORD.toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(trustStore);

        // Configura l'SSLContext per TLS
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        return sslContext.getServerSocketFactory();
    }
}