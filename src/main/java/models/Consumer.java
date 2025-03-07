package models;

public class Consumer {
    private String portId;
    private String location;

    public Consumer(String portId, String location) {
        this.portId = portId;
        this.location = location;
    }

    public String getPortId() { return portId; }
    public String getLocation() { return location; }
}

