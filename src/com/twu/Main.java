import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎来到热搜榜，你是？");
            System.out.println("1.用户");
            System.out.println("2.管理员");
            System.out.println("3.退出");
            Scanner scanner = new Scanner(System.in);
            int whoAreYou = scanner.nextInt();
            switch (whoAreYou) {
                case 1: {
                    break;
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
}
