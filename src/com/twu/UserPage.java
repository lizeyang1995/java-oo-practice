import java.util.Scanner;

class UserPage {
    private User user;

    UserPage(User user) {
        this.user = user;
    }

    void action() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            showUserPage(user.getUserName());
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
                case 3: {
                    System.out.println("请输入要购买的热搜名称：");
                    String eventName = scanner.next();
                    System.out.println("请输入要购买的排名：");
                    int desiredRanking = scanner.nextInt();
                    System.out.println("请输入要购买的价格：");
                    int priceToBuy = scanner.nextInt();
                    user.purchaseEvent(eventName, desiredRanking, priceToBuy);
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
                default: {
                    System.out.println("请重新输入!");
                }
            }
        }
    }

    private static void showUserPage(String userName) {
        System.out.println("你好，" + userName + "，你可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("5.退出");
    }
}
