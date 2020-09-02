import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMainPage();
            int whoAreYou = scanner.nextInt();
            switch (whoAreYou) {
                case 1: {
                    System.out.println("请输入您的昵称:");
                    String userName = scanner.next();
                    User user = new User(userName);
                    boolean run = true;
                    while (run) {
                        showUserPage(userName);
                        int operationNumber = scanner.nextInt();
                        switch (operationNumber) {
                            case 1: {
                                user.showEvent();
                                break;
                            }
                            case 2: {
                                System.out.println("请输入你要投票的热搜名字：");
                                String eventName = scanner.next();
                                System.out.println("请输入你要投入的票数：" + "(你目前还有：" + user.getTicketsNumber() + "票)");
                                int votes = scanner.nextInt();
                                user.vote(eventName, votes);
                                break;
                            }
                            case 4: {
                                System.out.println("请输入要添加的热搜名称：");
                                String eventName = scanner.next();
                                user.addEvent(eventName);
                                break;
                            }
                            case 5: {
                                run = false;
                                break;
                            }
                        }
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

    public static void showMainPage() {
        System.out.println("欢迎来到热搜榜，你是？");
        System.out.println("1.用户");
        System.out.println("2.管理员");
        System.out.println("3.退出");
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
