import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthSystem auth = new AuthSystem("users.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LOGIN SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter username: ");
                    String regUser = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPass = scanner.nextLine();
                    auth.register(regUser, regPass);
                    break;

                case "2":
                    System.out.print("Enter username: ");
                    String logUser = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String logPass = scanner.nextLine();
                    auth.login(logUser, logPass);
                    break;

                case "3":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("❗ Invalid choice. Try again.");
            }
        }
    }
}
