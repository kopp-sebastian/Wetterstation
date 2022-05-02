package at.htlle.Wetterstation;

// Repräsentiert einen Punkt auf der Erde

public class Location {

    Double lat; //< Breitengrad
    Double lon; //< Längengrad

    // Nobody should call this.
    // Use static method therefore.
    private Location() {
    }

    // Nimmt eine Loran Position entgegen und wandelt sie in ein Location Objekt um
    public static Location fromLoranPosition(String loranLat, String loranLon) {
        //Todo: Implement me!
        return null;
    }
}
