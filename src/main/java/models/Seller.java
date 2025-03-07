package models;

public class Seller {
    private String portId;
    private String location;

    public Seller(String portId, String location) {
        this.portId = portId;
        this.location = location;
    }

    public String getPortId() { return portId; }
    public String getLocation() { return location; }
}
