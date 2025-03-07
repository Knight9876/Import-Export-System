package models;

public class SellerUpdateDelete {
    private String portId;
    private String password;
    private String location;

    public SellerUpdateDelete(String portId, String password, String location) {
        this.portId = portId;
        this.password = password;
        this.location = location;
    }

    public String getPortId() { return portId; }
    public void setPortId(String portId) { this.portId = portId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
