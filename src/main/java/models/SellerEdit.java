package models;

public class SellerEdit {
    private int portId;
    private String password;
    private String role;
    private String location;

    public SellerEdit(int portId, String password, String role, String location) {
        this.portId = portId;
        this.password = password;
        this.role = role;
        this.location = location;
    }

    public int getPortId() { return portId; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getLocation() { return location; }

    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setLocation(String location) { this.location = location; }
}
