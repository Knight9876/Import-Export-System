package models;

public class UserLogin {
    private String portId;
    private String password;
    private String role;
    private String location;

    public UserLogin(String portId, String password, String role, String location) {
        this.portId = portId;
        this.password = password;
        this.role = role;
        this.location = location;
    }

    public String getPortId() { return portId; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getLocation() { return location; }
}
