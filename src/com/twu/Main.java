import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RankController rankController = new RankController();
        EventController eventController = new EventController(rankController);
        UserController userController = new UserController();
        while (true) {
            showMainPage();
            int whoAreYou = scanner.nextInt();
            switch (whoAreYou) {
                case 1: {
                    User user;
                    System.out.println("请输入您的昵称:");
                    String userName = scanner.next();
                    int userIndex = userController.findUserIndex(userName);
                    if (userIndex == -1) {
                        user = new User(userName, eventController, rankController);
                        userController.addUser(user);
                    } else {
                        user = userController.getUser(userIndex);
                    }
                    UserPage userPage = new UserPage(user);
                    userPage.action();
                    break;
                }
                case 2: {
                    System.out.println("请输入您的昵称:");
                    String administratorName = scanner.next();
                    Administrator administrator = new Administrator(administratorName, eventController);
                    AdministratorPage administratorPage = new AdministratorPage(administrator);
                    administratorPage.action();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("请重新输入!");
                }
            }
        }
    }

    private static void showMainPage() {
        System.out.println("欢迎来到热搜榜，你是？");
        System.out.println("1.用户");
        System.out.println("2.管理员");
        System.out.println("3.退出");
    }
}
