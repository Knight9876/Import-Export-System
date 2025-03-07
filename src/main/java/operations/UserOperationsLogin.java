package operations;

import models.UserLogin;

public interface UserOperationsLogin {
    UserLogin loginUser(String portId, String password, String role);
}
