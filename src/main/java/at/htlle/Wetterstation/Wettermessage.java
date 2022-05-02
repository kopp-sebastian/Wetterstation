package at.htlle.Wetterstation;

import java.time.Instant;

public class Wettermessage {
    String stationId;
    Instant empfangszeitpunkt;
    Double temperature_c;
    Location location;

    /*
    Erzeugt aus einer APRS Zeile eine Wettermessage (sofern das Format stimmt)
    Vollständige Zeile aus dem APRS / CWOP Server
     */
    public Wettermessage(String aprsMessage) {
        // Parsen der Zeile nach den gesuchten Daten

        this.stationId = "OEGTHM";
        this.empfangszeitpunkt = Instant.now();
        this.temperature_c = 21.0;
        this.location = Location.fromLoranPosition("3700.33N", "08440.47W");
    }
}
