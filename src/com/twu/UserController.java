import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> userData;

    UserController() {
        this.userData = new ArrayList<>();
    }

    public List<User> getUserData() {
        return userData;
    }

    void addUser(User user) {
        userData.add(user);
    }

    int findUserIndex(String userName) {
        for (int index = 0; index < userData.size(); index++) {
            if (userData.get(index).getUserName().equals(userName)) {
                return index;
            }
        }
        return -1;
    }

    User getUser(int index) {
        return userData.get(index);
    }
}
