import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> userData;

    public UserController() {
        this.userData = new ArrayList<>();
    }

    public void addUser(User user) {
        userData.add(user);
    }
}
