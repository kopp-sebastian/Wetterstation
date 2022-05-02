package at.htlle.Wetterstation;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class VirtualWx {

    public static void main(String[] args) {

        // 1. Socket öffnen
        try (Socket sock = new Socket("rotate.aprs2.net", 10152)) {
            // 2. Aus dem Socket den Input und Output Stream holen

            // Client -> Server
            OutputStream sout = sock.getOutputStream();
            PrintStream psout = new PrintStream(sout);

            // Server -> Client
            InputStream sin = sock.getInputStream();
            BufferedReader bisr = new BufferedReader(new InputStreamReader(sin));

            // 3. In die streams (entlang des vereinbarten Protokolls) schreiben / lesen

            // Welcome Message ausgeben
            System.out.println(bisr.readLine());
            Thread.sleep(500);

            // Anmelden beim Server
            psout.println("user HTLLE pass -1 vers VirtualWx-Kopp");
            Thread.sleep(500);

            String line;
            List<Wettermessage> messages = new ArrayList<>();
            while(true) {
                line = bisr.readLine();
                // Auf line steht immer eine Meldung.
                // Es ist aber nicht sicher ob es auch einer Wettermeldung ist.
                if(line.contains(":@")) {
                    // Wahrscheinlich ist es eine WX Message
                    System.out.println(line);
                    try {
                        Wettermessage wmsg = new Wettermessage(line);
                        messages.add(wmsg);
                    } catch (Exception e) {
                        // Do nothing (on purpose)!
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // 4. Streams schließen
        // 5. Socket schließen

    }
}
