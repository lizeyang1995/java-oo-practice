import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> userData;

    public UserController() {
        this.userData = new ArrayList<>();
    }

    public List<User> getUserData() {
        return userData;
    }

    public void addUser(User user) {
        userData.add(user);
    }

    public int findUserIndex(String userName) {
        for (int index = 0; index < userData.size(); index++) {
            if (userData.get(index).getUserName().equals(userName)) {
                return index;
            }
        }
        return -1;
    }
}
