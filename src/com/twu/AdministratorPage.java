import java.util.Scanner;

public class AdministratorPage {
    private Administrator administrator;

    public AdministratorPage(Administrator administrator) {
        this.administrator = administrator;
    }

    public void showAdministratorPage() {
        System.out.println("你好，" + administrator.getAdministratorName() + "，你可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
    }
}
