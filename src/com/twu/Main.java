import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎来到热搜榜，你是？");
            System.out.println("1.用户");
            System.out.println("2.管理员");
            System.out.println("3.退出");
            int whoAreYou = scanner.nextInt();
            switch (whoAreYou) {
                case 1: {
                    System.out.println("请输入您的昵称:");
                    String userName = scanner.next();
                    while (true) {
                        showUserPage(userName);
                    }
                }
                case 2: {
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
            }
        }
    }

    public static void showUserPage(String userName) {
        System.out.println("你好，" + userName + "，你可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("5.退出");
    }
}
