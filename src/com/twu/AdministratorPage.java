import java.util.Scanner;

class AdministratorPage {
    private Administrator administrator;

    AdministratorPage(Administrator administrator) {
        this.administrator = administrator;
    }

    void action() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            showAdministratorPage();
            int operationNumber = scanner.nextInt();
            switch (operationNumber) {
                case 1: {
                    administrator.showEvent();
                    break;
                }
                case 2: {
                    System.out.println("请输入要添加的热搜名称：");
                    String eventName = scanner.next();
                    administrator.addEvent(eventName, false);
                    break;
                }
                case 3: {
                    System.out.println("请输入要添加的超级热搜名称：");
                    String eventName = scanner.next();
                    administrator.addEvent(eventName, true);
                    break;
                }
                case 4: {
                    run = false;
                    break;
                }
                default: {
                    System.out.println("请重新输入!");
                }
            }
        }
    }

    private void showAdministratorPage() {
        System.out.println("你好，" + administrator.getAdministratorName() + "，你可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
    }
}
